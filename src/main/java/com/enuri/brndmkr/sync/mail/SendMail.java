package com.enuri.brndmkr.sync.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    /*******************************************
	  	에러 발송 메일
	*******************************************/
	public boolean setHtmlMailSendProc(SendMail_Data smDt) throws Exception{
	    Properties props = new Properties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.host", "mail.g2works.kr");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.debug", "false");

	    //보내는 사람 메일 주소
	 	String sendAddr = smDt.getSendMailAddr();

		//받는 사람 메일 주소
		String receiverAddr = smDt.getReceiverMailAddr();

		String mailTitle = smDt.getMailTitle().toString();
		String mailContent = smDt.getMailContents();

	    Authenticator auth = new Authenticator(){
	        protected PasswordAuthentication getPasswordAuthentication() {
	        	return new PasswordAuthentication("gm@enuri.com", "Enuri@211");
	        }
	    };

	    Session session = Session.getInstance(props,auth);
	    Transport transport = session.getTransport();

	    MimeMessage message = new MimeMessage(session);
	    message.setSubject(mailTitle);
	    message.setFrom(new InternetAddress(sendAddr));
	    message.setContent(mailContent, "text/html;charset=UTF-8");
	    message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverAddr));

	    transport.connect();
	    transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	    transport.close();

	    return true;
	}

}