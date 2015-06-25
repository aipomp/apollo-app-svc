package com.apollo.appsvc.common.bean;

public class SystemLog {
	
	private String module;
	
	private String operateName;
	
	private String description;
	
	private String className;
	
	private String methodName;
	
	public SystemLog() {
		module = "";
		operateName = "";
		description = "";
		className = "";
		methodName = "";
	}
	
	public SystemLog(final String module, final String operateName, final String description, final String className, final String methodName) {
		this.module = module;
		this.operateName = operateName;
		this.description = description;
		this.className = className;
		this.methodName = methodName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public String toString() {
		return "SystemLog [module=" + module + ", operateName=" + operateName
				+ ", description=" + description + ", className=" + className
				+ ", methodName=" + methodName + "]";
	}
}
