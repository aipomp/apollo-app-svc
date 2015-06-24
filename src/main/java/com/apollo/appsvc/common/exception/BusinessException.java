package com.apollo.appsvc.common.exception;

/**
 * 项目名称：apollo-app-svc   
 * 类名称：BusinessException   
 * 类描述：自定义异常处理类 用于针对用户的友好提示   
 * 创建人：zhoult   
 * 创建时间：2015年6月23日 下午3:08:33   
 * @version
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 3152616724785436891L;

	public BusinessException(String frdMessage) {
		super(createFriendlyErrMsg(frdMessage));
	}

	public BusinessException(Throwable throwable) {
		super(throwable);
	}

	public BusinessException(Throwable throwable, String frdMessage) {
		super(throwable);
	}

	private static String createFriendlyErrMsg(String msgBody) {
		String prefixStr = "抱歉，";
		String suffixStr = " 请稍后再试或与管理员联系！";

		StringBuffer friendlyErrMsg = new StringBuffer("");

		friendlyErrMsg.append(prefixStr);

		friendlyErrMsg.append(msgBody);

		friendlyErrMsg.append(suffixStr);

		return friendlyErrMsg.toString();
	}
}
