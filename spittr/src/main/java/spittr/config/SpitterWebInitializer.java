package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 15:17 2019/8/15
 * @modifyTime
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 将 DispatcherServlet 映射到"/"，这表示它是应用的默认Servlet，它会处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	/**
	 * 当 DispatcherServlet 启动的时候，它会创建 Spring 应用上下文，并加载配置文件或配置类中所声明的 Bean
	 * 加载包含Web组件的 bean，如控制器、视图解析器、处理器映射
	 *
	 * 得到controler和ViewResolver的配置
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	/**
	 * 用来配置 ContextLoaderListener 创建的应用上下文中的 Bean
	 * 加载的 bean 通常是驱动应用后端的中间层和数据层组件
	 *
	 * 得到中间层(service、dao、aop、po等)的配置
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

}
