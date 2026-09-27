package pti.sb_namedays_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pti.sb_namedays_rest.dto.XmlResponseDTO;
import pti.sb_namedays_rest.service.AppService;

@RestController
public class AppController {

	private final AppService appService;

	@Autowired
	public AppController(AppService appService) {
		super();
		this.appService = appService;
	}

	@GetMapping("/namedays")
	public XmlResponseDTO getNamedays() {

		return appService.getXml();

	}
}
