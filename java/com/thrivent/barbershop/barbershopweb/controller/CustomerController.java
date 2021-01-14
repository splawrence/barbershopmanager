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

import com.thrivent.barbershop.barbershopweb.domain.Customer;
import com.thrivent.barbershop.barbershopweb.repository.CustomerRepository;

@Controller
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @GetMapping("/customersignup")
    public String showSignUpFormFromCustomer(Customer customer) {
        return "add-customer";
    }
        
    @PostMapping("/addcustomer")
    public ModelAndView addcustomer(@ModelAttribute Customer customer) {
    	
    	customer.setActiveIndicator("Y");
        customerRepository.save(customer);
        
		ModelAndView mav = new ModelAndView();
		Customer[] cust = customerRepository.findAllActive();
		
		mav.addObject("cust", cust);
		mav.setViewName("customermanager");
		return mav;
    }
    
    @GetMapping("/customermanager")
    public ModelAndView showCustomers(@ModelAttribute Customer customer) {
       
		ModelAndView mav = new ModelAndView();
		Customer[] cust = customerRepository.findAllActive();
	
		mav.addObject("cust", cust);
		mav.setViewName("customermanager");
		return mav;
    }
        
    @GetMapping("/editcustomer/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
        model.addAttribute("customer", customer);
        return "update-customer";
    }
    
    @PostMapping("/updatecustomer/{id}")
    public ModelAndView updatecustomer(@PathVariable("id") long id, @Valid Customer customer, BindingResult result, Model model) {   
    	customer.setActiveIndicator("Y");
        customerRepository.save(customer);
		ModelAndView mav = new ModelAndView();
		Customer[] cust = customerRepository.findAllActive();
	
		mav.addObject("cust", cust);
		mav.setViewName("customermanager");
		return mav;
    }
    
    @GetMapping("/deletecustomer/{id}")
    public ModelAndView deletecustomer(@PathVariable("id") long id, Model model) {
    	Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
    	
    	customer.setActiveIndicator("N");
        customerRepository.save(customer);

		ModelAndView mav = new ModelAndView();
		Customer[] cust = customerRepository.findAllActive();
	
		mav.addObject("cust", cust);
		mav.setViewName("customermanager");
		return mav;
    }
}
