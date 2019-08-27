package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.Date;
import java.util.List;

/**
 * @author qiaofei@css.com.cn
 * @version 1.0
 * @description
 * @createTime 14:59 2019/8/16
 * @modifyTime
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	private SpittleRepository spittleRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRepository.findSpittles(max, count);
	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(
			@PathVariable("spittleId") long spittleId,
			Model model) {
		Spittle spittle = spittleRepository.findOne(spittleId);
		if (spittle == null) {
			throw new SpittleNotFoundException();
		}

		model.addAttribute(spittle);
		return "spittle";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(SpittleForm form, Model model) throws DuplicateSpittleException {
		spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
				form.getLongitude(), form.getLatitude()));
		return "redirect:/spittles";
	}

	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleNotFound() {
		return "error/duplicate";
	}

}
