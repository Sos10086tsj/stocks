package com.chinesedreamer.stocks.message;

public class ResponseVo {
	private Boolean success = Boolean.TRUE;
	private String errorCode;
	private String errorMsg;
	public Boolean getSuccess() {
		return success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
