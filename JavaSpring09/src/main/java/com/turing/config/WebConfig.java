package com.turing.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * SpringMVC的配置项
 * @author fred
 *
 */

@Configuration //标识一个配置项
@ComponentScan(basePackages = {"com.turing.controller"}) //扫描指定的包中，打了四种组件注解的
@EnableWebMvc //开启SpringMVC注解
public class WebConfig extends WebMvcConfigurerAdapter{

	//配置视图解析器
//	@Bean
//	public ViewResolver viewResolver() {
//		//创建视图解析器，并设置前缀和后缀
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/jsp/",".jsp");
//        //设置bean在请求属性中也可以访问
//		resolver.setExposeContextBeansAsAttributes(true);
//		return resolver;
//	}
	
	//配置模板解析器
	@Bean
	public ITemplateResolver templateResolver(ApplicationContext applicationContext) {
		//模板解析器
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		//设置上下文（IOC容器）
		templateResolver.setApplicationContext(applicationContext);
		//设置前缀
		templateResolver.setPrefix("/");
		//设置后缀
		templateResolver.setSuffix(".html");
		//设置模板类型
		templateResolver.setTemplateMode(TemplateMode.HTML);
		//开发时为了调试方便，禁用页面缓存
		templateResolver.setCacheable(false);
		//设置编码
		templateResolver.setCharacterEncoding("utf-8");
		return templateResolver;
	}
	
	//Spring模板引擎
	@Bean
	public ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		//模板引擎
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		//设置解析器
		templateEngine.setTemplateResolver(templateResolver);
		//支持SpEL(Spring的EL表达式)
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	//视图解析器
	@Bean
	public ViewResolver viewResolver(ISpringTemplateEngine templateEngine) {
		//创建Thymeleaf视图解析器
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		//设置模板引擎
		viewResolver.setTemplateEngine(templateEngine);
		//设置编码
		viewResolver.setCharacterEncoding("utf-8");
		return viewResolver;
	}
	

	//开启静态资源的访问
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//开启
		configurer.enable();
	}
}
