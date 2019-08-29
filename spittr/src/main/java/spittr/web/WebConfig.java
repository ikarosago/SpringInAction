package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.IOException;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 15:21 2019/8/15
 * @modifyTime
 */
@Configuration
@EnableWebMvc  //启动 Spring MVC 组件
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}

//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}

	/**
	 * 配置静态资源的处理
	 * 此时会注册一个默认的Handler：DefaultServletHttpRequestHandler，
	 * 这个Handler也是用来处理静态文件的，它会尝试映射/*。
	 * 当DispatcherServelt映射/时（/ 和/* 是有区别的），并且没有找到合适的Handler来处理请求时，
	 * 就会交给DefaultServletHttpRequestHandler 来处理。
	 * 注意：这里的静态资源是放置在web根目录下，而非WEB-INF 下。
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//要求 DispatcherServlet 将对静态资源的请求转发到 Servlet 容器中默认的 Servlet 上，
		// 而不是使用 DispatcherServlet 本身来处理此类请求
		configurer.enable();
	}

	/**
	 * 此方法用来专门注册一个Handler，来处理静态资源的，例如：图片，js，css等。举例：
	 * registry.addResourceHandler("/resource/**").addResourceLocations("/WEB-INF/static/");
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}

	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	}
}
