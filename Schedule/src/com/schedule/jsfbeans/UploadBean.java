/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 * @author Kevin Klein
 *
 */
public class UploadBean {

	private UploadedFile myFile;
    private String myParam = "MD5";
    private String myResult;
    private int isSet = 0;

    public UploadedFile getMyFile() {
        return myFile;
    }

    public void setMyFile(UploadedFile myFile) {
        this.myFile = myFile;
    }

    public String getMyParam() {
        return myParam;
    }

    public void setMyParam(String myParam) {
        this.myParam = myParam;
    }

    public String getMyResult() {
        return myResult;
    }

    public void setMyResult(String myResult) {
        this.myResult = myResult;
    }
    public String processMyFile() {
        try {
        		BufferedOutputStream os = null;
            MessageDigest md
                = MessageDigest.getInstance(myParam);
            InputStream in = new BufferedInputStream(
                myFile.getInputStream());
            os = new BufferedOutputStream(
            	       new FileOutputStream( "/"+ myFile.getName() ) ); //Zielverzeichniss
            
            try {
                byte[] buffer = new byte[64 * 1024];
                int count;
                while ((count = in.read(buffer)) > 0){
                    md.update(buffer, 0, count);
                    os.write(buffer, 0, count);
                    
                }
            } finally {
                in.close();
            }
            byte hash[] = md.digest();
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                int b = hash[i] & 0xFF;
                int c = (b >> 4) & 0xF;
                c = c < 10 ? '0' + c : 'A' + c - 10;
                buf.append((char) c);
                c = b & 0xF;
                c = c < 10 ? '0' + c : 'A' + c - 10;
                buf.append((char) c);
            }
            myResult = buf.toString();
            this.isSet = 1;
            return "OK";
        } catch (Exception x) {
            FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_FATAL,
                x.getClass().getName(), x.getMessage());
            FacesContext.getCurrentInstance().addMessage(
                null, message);
            return null;
        }
    }
	/**
	 * @return Returns the isSet.
	 */
	public int getIsSet() {
		return this.isSet;
	}
	/**
	 * @param isSet The isSet to set.
	 */
	public void setIsSet(int isSet) {
		this.isSet = isSet;
	}
}
