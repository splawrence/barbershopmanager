package com.thrivent.barbershop.barbershopweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.thrivent.barbershop.barbershopweb.domain.Barber;


@Controller
public class HomeController {
	
    @GetMapping("/")
    public ModelAndView showhome(@ModelAttribute Barber barber) {
       
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
    } 
}
