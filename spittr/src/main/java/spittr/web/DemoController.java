package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 14:12 2019/8/23
 * @modifyTime
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	/**
	 * 传递Demo对象到Index页面，Index页面才能提交一个Bean到后台
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("demo",new Demo());
		return "index";
	}

	/**
	 * 把demo传递到welcome页面
	 * @param demo
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@ModelAttribute(value = "demo") Demo demo, Model model){
		model.addAttribute("demo",demo);
		return "welcome";
	}
}
