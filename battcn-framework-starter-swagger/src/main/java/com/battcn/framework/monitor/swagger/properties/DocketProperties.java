package com.battcn.framework.monitor.swagger.properties;

public class DocketProperties implements java.io.Serializable {

	private static final long serialVersionUID = 3342663558680329645L;
	
	private String groupName;
	private String basePackage;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

}
