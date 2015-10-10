package com.chinesedreamer.stocks.message.mail.service;

import com.chinesedreamer.stocks.message.mail.config.EmailRecipient;
import com.chinesedreamer.stocks.message.mail.entity.AbstractVelocityTemplate;

public interface EmailSender {
	public void sendEmail(String from, EmailRecipient recipient, String subject, String content);
	
	public void sendHtmlEmail(String from, EmailRecipient recipient, String subject, String content);
	
	public void sendCaptureEmail(String from, EmailRecipient recipient, String subject, String content, String inline,String capture);
	
	public void sendAttachEmail(String from, EmailRecipient recipient, String subject, String content, String attachPath);
	
	public void sendTemplateEmail(String from, EmailRecipient recipient, String subject, String templatePath, AbstractVelocityTemplate velocityTemplate);
}
