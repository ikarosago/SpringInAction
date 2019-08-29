package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 15:30 2019/8/29
 * @modifyTime
 */
@Configuration
@EnableWebSecurity  //启动Web安全性
//@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
