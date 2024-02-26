package com.chegg.automation;

import javax.mail.MessagingException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;



public class EmailSender {
	public static void sendEmail() throws MessagingException, EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("cheggemailskumar@gmail.com", "ctys bpyr xzhj ceda"));
		email.setStartTLSRequired(true);
		email.setFrom("velugulakumar786@gmail.com");
		email.setSubject("You got a Chegg question");
		email.setMsg("Respond quickly please you got a chegg question");
		email.addTo("velugulakumar999@gmail.com");
		email.send();
	}
}
