package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.UploadController;

@Configuration
public class SpringMvcConfiguration {
	@Bean
	public UploadController uploadController(){
		return new UploadController();
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		return new CommonsMultipartResolver();
		/*
		 * <bean id="multipartResolver" class="...CommonsMultipartResolver"/>
		 */
	}
}
