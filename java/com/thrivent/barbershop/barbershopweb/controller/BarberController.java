package com.thrivent.barbershop.barbershopweb.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thrivent.barbershop.barbershopweb.domain.Barber;
import com.thrivent.barbershop.barbershopweb.repository.BarberRepository;


@Controller
public class BarberController {
    
    private final BarberRepository barberRepository;

    @Autowired
    public BarberController(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }
    
    @GetMapping("/barbersignup")
    public String showSignUpForm(Barber barber) {
        return "add-barber";
    }
        
    @PostMapping("/addbarber")
    public ModelAndView addbarber(@ModelAttribute Barber barber) {
    	
    	barber.setActiveIndicator("Y");
        barberRepository.save(barber);
        
		ModelAndView mav = new ModelAndView();
		Barber[] barb = barberRepository.findAllActiveBarbers();
		
		mav.addObject("barb", barb);
		mav.setViewName("barbermanager");
		return mav;
    }
    
    @GetMapping("/barbermanager")
    public ModelAndView showCustomers(@ModelAttribute Barber barber) {
       
		ModelAndView mav = new ModelAndView();
		Barber[] barb = barberRepository.findAllActiveBarbers();
	
		mav.addObject("barb", barb);
		mav.setViewName("barbermanager");
		return mav;
    }
        
    @GetMapping("/editbarber/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Barber barber = barberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid barber Id:" + id));
        model.addAttribute("barber", barber);
        return "update-barber";
    }
    
    @PostMapping("/updatebarber/{id}")
    public ModelAndView updatecustomer(@PathVariable("id") long id, @Valid Barber barber, BindingResult result, Model model) {   
    	barber.setActiveIndicator("Y");
        barberRepository.save(barber);
		ModelAndView mav = new ModelAndView();
		Barber[] barb = barberRepository.findAllActiveBarbers();
	
		mav.addObject("barb", barb);
		mav.setViewName("barbermanager");
		return mav;
    }
    
    @GetMapping("/deletebarber/{id}")
    public ModelAndView deletecustomer(@PathVariable("id") long id, Model model) {
    	Barber barber = barberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid barber Id:" + id));
    	
    	barber.setActiveIndicator("N");
        barberRepository.save(barber);

		ModelAndView mav = new ModelAndView();
		Barber[] barb = barberRepository.findAllActiveBarbers();
	
		mav.addObject("barb", barb);
		mav.setViewName("barbermanager");
		return mav;
    }
}
