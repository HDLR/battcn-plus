package com.battcn.framework.monitor.swagger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(name = {"swagger.enabled"})
@EnableSwagger2
public class SwaggerAutoConfiguration implements BeanFactoryAware {
    private BeanFactory beanFactory;

    public SwaggerAutoConfiguration() {
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public List<Docket> createRestApi(SwaggerProperties swaggerProperties) {
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) this.beanFactory;
        if (swaggerProperties.getDocket().size() == 0) {
            ApiInfo apiInfo = (new ApiInfoBuilder()).title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription()).version(swaggerProperties.getVersion()).license(swaggerProperties.getLicense()).licenseUrl(swaggerProperties.getLicenseUrl()).contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail())).termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl()).build();
            if (swaggerProperties.getBasePath().isEmpty()) {
                swaggerProperties.getBasePath().add("/**");
            }

            List<Predicate<String>> basePath = new ArrayList<>();
            Iterator bases = swaggerProperties.getBasePath().iterator();

            while (bases.hasNext()) {
                String path = (String) bases.next();
                basePath.add(PathSelectors.ant(path));
            }

            List<Predicate<String>> excludePath = new ArrayList<>();
            Iterator excludes = swaggerProperties.getExcludePath().iterator();

            while (excludes.hasNext()) {
                String path = (String) excludes.next();
                excludePath.add(PathSelectors.ant(path));
            }

            Docket docket = (new Docket(DocumentationType.SWAGGER_2)).apiInfo(apiInfo).select().apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage())).paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath))).build();
            configurableBeanFactory.registerSingleton("defaultDocket", docket);
            return null;
        } else {
            List<Docket> docketList = new LinkedList<>();
            Iterator dockets = swaggerProperties.getDocket().keySet().iterator();

            while (dockets.hasNext()) {
                String groupName = (String) dockets.next();
                SwaggerProperties.DocketInfo docketInfo = swaggerProperties.getDocket().get(groupName);
                ApiInfo apiInfo = (new ApiInfoBuilder()).title(docketInfo.getTitle().isEmpty() ? swaggerProperties.getTitle() : docketInfo.getTitle()).description(docketInfo.getDescription().isEmpty() ? swaggerProperties.getDescription() : docketInfo.getDescription()).version(docketInfo.getVersion().isEmpty() ? swaggerProperties.getVersion() : docketInfo.getVersion()).license(docketInfo.getLicense().isEmpty() ? swaggerProperties.getLicense() : docketInfo.getLicense()).licenseUrl(docketInfo.getLicenseUrl().isEmpty() ? swaggerProperties.getLicenseUrl() : docketInfo.getLicenseUrl()).contact(new Contact(docketInfo.getContact().getName().isEmpty() ? swaggerProperties.getContact().getName() : docketInfo.getContact().getName(), docketInfo.getContact().getUrl().isEmpty() ? swaggerProperties.getContact().getUrl() : docketInfo.getContact().getUrl(), docketInfo.getContact().getEmail().isEmpty() ? swaggerProperties.getContact().getEmail() : docketInfo.getContact().getEmail())).termsOfServiceUrl(docketInfo.getTermsOfServiceUrl().isEmpty() ? swaggerProperties.getTermsOfServiceUrl() : docketInfo.getTermsOfServiceUrl()).build();
                if (docketInfo.getBasePath().isEmpty()) {
                    docketInfo.getBasePath().add("/**");
                }

                List<Predicate<String>> basePath = new ArrayList<>();
                Iterator bases = docketInfo.getBasePath().iterator();

                while (bases.hasNext()) {
                    String path = (String) bases.next();
                    basePath.add(PathSelectors.ant(path));
                }

                List<Predicate<String>> excludePath = new ArrayList<>();
                Iterator excludes = docketInfo.getExcludePath().iterator();

                while (excludes.hasNext()) {
                    String path = (String) excludes.next();
                    excludePath.add(PathSelectors.ant(path));
                }
                Docket docket = (new Docket(DocumentationType.SWAGGER_2)).apiInfo(apiInfo).groupName(groupName).select().apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage())).paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath))).build();
                configurableBeanFactory.registerSingleton(groupName, docket);
                docketList.add(docket);
            }

            return docketList;
        }
    }
}