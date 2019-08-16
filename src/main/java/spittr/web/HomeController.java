package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 11:04 2019/8/16
 * @modifyTime
 */
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}
}
