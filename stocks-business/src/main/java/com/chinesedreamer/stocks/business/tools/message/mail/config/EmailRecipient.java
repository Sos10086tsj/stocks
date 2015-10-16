package com.chinesedreamer.stocks.business.tools.message.mail.config;

public class EmailRecipient {
	private String[] to = new String[]{};
	private String[] cc = new String[]{};
	private String[] bcc = new String[]{};
	
	public EmailRecipient(String[] to, String[] cc, String[] bcc){
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
	}
	
	public String[] getTo() {
		return to;
	}
	public String[] getCc() {
		return cc;
	}
	public String[] getBcc() {
		return bcc;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	
	
}
