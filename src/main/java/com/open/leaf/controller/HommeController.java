package com.open.leaf.controller;

import java.util.Locale;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HommeController {
	
	private JdbcTemplate jdbcTemplate;
	public HommeController(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
		
	}

	@GetMapping
	public String index(Locale locale) {
		System.out.println(locale.getLanguage());
		try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.println("✅ DB connected! Result = " + result);
        } catch (Exception e) {
            System.out.println("❌ DB connection failed!");
            e.printStackTrace();
        }
		return "index";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
}
