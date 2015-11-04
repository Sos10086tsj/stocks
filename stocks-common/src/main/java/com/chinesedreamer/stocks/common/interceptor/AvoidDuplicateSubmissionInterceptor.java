package com.chinesedreamer.stocks.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chinesedreamer.stocks.common.annotation.AvoidDuplicateSubmission;
import com.chinesedreamer.stocks.common.generator.TokenProcessor;

/**
 * 避免重复提交拦截器
 * 
 * @author Paris
 *
 */
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {

	private String tokenKey = "token";

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
		if (null != annotation) {
			boolean needSaveToken = annotation.needSaveToken();
			if (needSaveToken) {
				request.getSession(false).setAttribute(this.tokenKey,
						TokenProcessor.getInstance().generateToken(request));
			}

			boolean needRemoveToken = annotation.needRemoveToken();
			if (needRemoveToken) {
				if (needRemoveToken) {
					if (isRepeatSubmit(request)) {
						return false;
					}
					request.getSession(false).removeAttribute(this.tokenKey);
				}
			}
		}
		return true;
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = (String) request.getSession(false).getAttribute(this.tokenKey);
		if (null == serverToken) {
			return true;
		}

		String clientToken = request.getParameter(this.tokenKey);
		if (null == clientToken) {
			return true;
		}

		if (!serverToken.equals(clientToken)) {
			return true;
		}

		return false;
	}
}
