/*
 * Created on Jun 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Christian Sukale
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

import java.util.List;

import com.schedule.hibernate.*;
import com.schedule.jsfbeans.*;

public class Test {

	/**
	 *  
	 */
	public Test() {
		
	}

	public static void main(String[] args) 
	{
		
		MessageHandlerBean msg = new MessageHandlerBean();
		List msgList = msg.getMessageList();
		
		for (int i=0; i < msgList.size(); i++)
		{
			Messages message = (Messages) msgList.get(i);
			System.out.println(message.getSubject());
		}
		
	}
}
