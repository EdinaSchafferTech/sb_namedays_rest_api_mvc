package pti.sb_namedays_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pti.sb_namedays_mvc.dto.NamedayDTO;
import pti.sb_namedays_mvc.model.Nameday;
import pti.sb_namedays_mvc.service.AppService;

@Controller
public class AppController {

	private AppService appService;

	@Autowired
	public AppController(AppService appService) {
		super();
		this.appService = appService;
	}

	@GetMapping("/namedays")
	public String getNameDays(Model model) {

		Iterable<NamedayDTO> namedays = appService.getNameDays();

		model.addAttribute("namedays", namedays);

		return "namedays";
	}

}
