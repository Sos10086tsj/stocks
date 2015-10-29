package com.chinesedreamer.stocks.business.session.exception;

import com.chinesedreamer.stocks.common.exception.BusinessException;


/**
 * Description: 
 * @author Paris
 * @date Feb 11, 201510:17:22 AM
 * @version beta
 */
public class SessionOverdueException extends BusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4423641251918769005L;

	public SessionOverdueException(String message) {
		super(message);
	}

}
