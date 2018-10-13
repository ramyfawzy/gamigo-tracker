package com.gamigo.tracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class ChartController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = {""})
	public String toCharts(Model model) {
		return "entry/chart.html";
	}

}
