package com.battcn.framework.monitor.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.battcn.framework.monitor.swagger.properties.ApiInfoProperties;
import com.battcn.framework.monitor.swagger.properties.DocketProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("swagger")
public class SwaggerProperties {
	private boolean enabled = false;
	private String title = "";
	private String description = "";
	private String version = "";
	private String license = "";
	private String licenseUrl = "";
	private String termsOfServiceUrl = "";
	private SwaggerProperties.Contact contact = new SwaggerProperties.Contact();
	private String basePackage = "";
	private List<String> basePath = new ArrayList();
	private List<String> excludePath = new ArrayList();
	private Map<String, SwaggerProperties.DocketInfo> docket = new LinkedHashMap();

	public SwaggerProperties() {
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return this.licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getTermsOfServiceUrl() {
		return this.termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public SwaggerProperties.Contact getContact() {
		return this.contact;
	}

	public void setContact(SwaggerProperties.Contact contact) {
		this.contact = contact;
	}

	public String getBasePackage() {
		return this.basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public List<String> getBasePath() {
		return this.basePath;
	}

	public void setBasePath(List<String> basePath) {
		this.basePath = basePath;
	}

	public List<String> getExcludePath() {
		return this.excludePath;
	}

	public void setExcludePath(List<String> excludePath) {
		this.excludePath = excludePath;
	}

	public Map<String, SwaggerProperties.DocketInfo> getDocket() {
		return this.docket;
	}

	public void setDocket(Map<String, SwaggerProperties.DocketInfo> docket) {
		this.docket = docket;
	}

	public static class Contact {
		private String name = "";
		private String url = "";
		private String email = "";

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Contact() {
		}
	}

	public static class DocketInfo {
		private String title = "";
		private String description = "";
		private String version = "";
		private String license = "";
		private String licenseUrl = "";
		private String termsOfServiceUrl = "";
		private SwaggerProperties.Contact contact = new SwaggerProperties.Contact();
		private String basePackage = "";
		private List<String> basePath = new ArrayList();
		private List<String> excludePath = new ArrayList();

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getVersion() {
			return this.version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getLicense() {
			return this.license;
		}

		public void setLicense(String license) {
			this.license = license;
		}

		public String getLicenseUrl() {
			return this.licenseUrl;
		}

		public void setLicenseUrl(String licenseUrl) {
			this.licenseUrl = licenseUrl;
		}

		public String getTermsOfServiceUrl() {
			return this.termsOfServiceUrl;
		}

		public void setTermsOfServiceUrl(String termsOfServiceUrl) {
			this.termsOfServiceUrl = termsOfServiceUrl;
		}

		public SwaggerProperties.Contact getContact() {
			return this.contact;
		}

		public void setContact(SwaggerProperties.Contact contact) {
			this.contact = contact;
		}

		public String getBasePackage() {
			return this.basePackage;
		}

		public void setBasePackage(String basePackage) {
			this.basePackage = basePackage;
		}

		public List<String> getBasePath() {
			return this.basePath;
		}

		public void setBasePath(List<String> basePath) {
			this.basePath = basePath;
		}

		public List<String> getExcludePath() {
			return this.excludePath;
		}

		public void setExcludePath(List<String> excludePath) {
			this.excludePath = excludePath;
		}

		public DocketInfo() {
		}
	}
}
