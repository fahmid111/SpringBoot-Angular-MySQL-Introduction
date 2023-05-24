package com.fahmid.springboot_angular_mysql_intro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootAngularMysqlIntroController {

	@RequestMapping("/text")
	public String text(){
		return "SpringBoot, Angular and MySQL Introduction by Fahmid";
	}
}
