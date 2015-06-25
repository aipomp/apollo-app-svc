package com.apollo.appsvc.common.service;

public interface MailService {

	/**
	 * 发送文本邮件
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 * @return
	 * @throws Exception
	 */
	public boolean sendTextMail(final String to, final String mailSubject, final String mailBody) throws Exception;
	
	/**
	 * 发送HTML邮件
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 * @return
	 * @throws Exception
	 */
	public boolean sendHtmlMail(final String name, final String to, final String mailSubject, final String mailBody) throws Exception;
}
