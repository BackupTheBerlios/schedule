/*
 * Created on 27.06.2005
 *
 */
package com.schedule;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author reinhard
 *
 */
public class CryptoManager {
	
	/**
	 * Computes a digest of a string
	 * @param buffer The string the digest is made of
	 * @param algorithm The algorithm used (e.g. MD5, SHA-1)
	 * @return The digest of the string
	 */
	public static String getDigest(String buffer, String algorithm) {
        try {
            MessageDigest sha = MessageDigest.getInstance(algorithm);
            sha.update(buffer.getBytes());
            return new String(sha.digest());
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

}
