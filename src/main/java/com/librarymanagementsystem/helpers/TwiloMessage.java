package com.librarymanagementsystem.helpers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwiloMessage {

	private static TwiloMessage instance = null;
	
	private static final String ACCOUNT_SID = "AC911c97c68b35cb67ee0584d301056021";
	private static final String AUTH_TOKEN = "10c98c19462f0f64711fa12d3b31e4bd";
	private static final String PHONE_NUMBER = "+19807345045";
	
	private TwiloMessage()
	{
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}
	
	public static TwiloMessage getInstance()
	{
		if(instance == null)
		{
			instance = new TwiloMessage();
		}
		
		return instance;
	}
	
	public void sendMessage(String receiverPhoneNumber, String msg)
	{
		Message message = Message.creator(
			    new PhoneNumber(receiverPhoneNumber),
			    new PhoneNumber(PHONE_NUMBER),
			    msg)
			.create();
		
		ResourceSet<Message> messages = Message.reader().read();
		for (Message message2 : messages) {
		    System.out.println(message2.getSid() + " : " + message2.getStatus());
		}
	}
}
