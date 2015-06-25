package com.apollo.appsvc.common.service.impl;

import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.apollo.appsvc.common.util.Configuration;

import com.apollo.appsvc.common.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	private static Logger logger  = Logger.getLogger(LogServiceImpl.class);
	
	@Autowired
	JavaMailSender javaMailSender;

	/**
	 * 发送文本邮件
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 * @return
	 * @throws Exception
	 */
	public boolean sendTextMail(final String to, final String mailSubject, final String mailBody) throws Exception {
        if (logger.isDebugEnabled())
            logger.debug("文本形式的邮件正在发送 ...");
        
        SimpleMailMessage mail = new SimpleMailMessage();
        String from = Configuration.getInstance().getValue("mail.from");
        mail.setFrom(from);// 发送人名片
        mail.setTo(to);// 收件人邮箱
        mail.setSubject(mailSubject);// 邮件主题
        mail.setSentDate(new Date());// 邮件发送时间
        mail.setText(mailBody);

        // 群发
        SimpleMailMessage[] mailMessages = { mail };
        javaMailSender.send(mailMessages);

        if (logger.isDebugEnabled())
            logger.debug("文本形式的邮件发送成功 ...");
        
		return true;
	}

	/**
	 * 发送HTML邮件
	 * @param to
	 * @param mailSubject
	 * @param mailBody
	 * @return
	 * @throws Exception
	 */
	public boolean sendHtmlMail(final String name, final String to, final String mailSubject, final String mailBody) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            if (logger.isDebugEnabled())
                logger.debug("HTML脚本形式邮件正在发送 ... ");
            
            // 设置UTF-8或GBK编码，否则邮件会有乱码
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            // 设置发送人名片
            String from = Configuration.getInstance().getValue("mail.from");
            helper.setFrom(from);
            // 设置收件人名片和地址
            helper.setTo(new InternetAddress("\"" + MimeUtility.encodeText(name) + "\" <" + to + ">"));// 发送者
            // 设置抄送的名片和地址
            // helper.setCc(InternetAddress.parse(MimeUtility.encodeText("抄送人001")
            // + " <@163.com>," + MimeUtility.encodeText("抄送人002")
            // + " <@foxmail.com>"));
            // 邮件发送时间
            helper.setSentDate(new Date());
            // 设置回复地址
            helper.setReplyTo(new InternetAddress(from));
            // 主题
            helper.setSubject(mailSubject);
            // 邮件内容，注意加参数true，表示启用html格式
            helper.setText(mailBody, true);
            // 发送
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (logger.isDebugEnabled())
            logger.debug("HTML脚本形式邮件发送成功 ... ");
        
        return true;
	}
}
