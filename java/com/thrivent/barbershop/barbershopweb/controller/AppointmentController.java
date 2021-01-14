package com.thrivent.barbershop.barbershopweb.controller;

import java.util.List;
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

import com.thrivent.barbershop.barbershopweb.domain.Appointment;
import com.thrivent.barbershop.barbershopweb.domain.AppointmentResultEntity;
import com.thrivent.barbershop.barbershopweb.domain.Barber;
import com.thrivent.barbershop.barbershopweb.domain.Customer;
//import com.thrivent.barbershop.barbershopweb.domain.Barber;
//import com.thrivent.barbershop.barbershopweb.domain.Customer;
import com.thrivent.barbershop.barbershopweb.domain.EntityListModel;
import com.thrivent.barbershop.barbershopweb.repository.AppointmentRepository;
import com.thrivent.barbershop.barbershopweb.repository.BarberRepository;
import com.thrivent.barbershop.barbershopweb.repository.CustomerRepository;

@Controller
public class AppointmentController {
    


    @Autowired
    private AppointmentRepository appointmentRepository;

    
    @Autowired 
    private CustomerRepository customerRepository;
    
    @Autowired 
    private BarberRepository barberRepository;
    
    
    
    @GetMapping("/appointmentsignup")
    public ModelAndView showSignUpForm(Appointment appointment) {
    	
    	EntityListModel entityListModel = new EntityListModel();
    	ModelAndView mav = new ModelAndView("add-appointment");
    	
    	Customer[] customerList = customerRepository.findAllActive();
    	entityListModel.setSearchCustomerList(customerList);
    	
    	Barber[] barberList = barberRepository.findAllActiveBarbers();
    	entityListModel.setSearchBarberList(barberList);
    	
    	mav.addObject("customerList", customerList);
    	mav.addObject("barberList", barberList);
    	
        return mav;
    }
        
    @PostMapping("/addappointment")
    public ModelAndView addAppointment(@ModelAttribute Appointment appointment) {
    	
    	appointment.setActiveIndicator("Y");
        appointmentRepository.save(appointment);
        
		ModelAndView mav = new ModelAndView();
		List<AppointmentResultEntity> appo = appointmentRepository.findAllActiveAppointments();
		
		mav.addObject("appo", appo);
		mav.setViewName("appointmentmanager");
		return mav;
    }
    
    @GetMapping("/appointmentsignupwidget")
    public ModelAndView showSignUpFormWidget(Appointment appointment) {
    	
    	EntityListModel entityListModel = new EntityListModel();
    	ModelAndView mav = new ModelAndView("add-appointment-widget");
    	
    	Customer[] customerList = customerRepository.findAllActive();
    	entityListModel.setSearchCustomerList(customerList);
    	
    	Barber[] barberList = barberRepository.findAllActiveBarbers();
    	entityListModel.setSearchBarberList(barberList);
    	
    	mav.addObject("customerList", customerList);
    	mav.addObject("barberList", barberList);
    	
        return mav;
    }
        
    @PostMapping("/addappointmentwidget")
    public ModelAndView addAppointmentFromWidget(@ModelAttribute Appointment appointment) {
    	
    	appointment.setActiveIndicator("Y");
        appointmentRepository.save(appointment);
        
		ModelAndView mav = new ModelAndView();
    	EntityListModel entityListModel = new EntityListModel();
    	
    	Customer[] customerList = customerRepository.findAllActive();
    	entityListModel.setSearchCustomerList(customerList);
    	
    	Barber[] barberList = barberRepository.findAllActiveBarbers();
    	entityListModel.setSearchBarberList(barberList);
    	
    	mav.addObject("customerList", customerList);
    	mav.addObject("barberList", barberList);
        

		List<AppointmentResultEntity> appo = appointmentRepository.findAllActiveAppointments();
		
		mav.addObject("appo", appo);
		mav.setViewName("/add-appointment-widget");
		return mav;
    }
    
       
    @GetMapping("/appointmentmanager")
    public ModelAndView showAppointments(@ModelAttribute Appointment appointment) {
       
		ModelAndView mav = new ModelAndView();
		List<AppointmentResultEntity> appo = appointmentRepository.findAllActiveAppointments();
	
		mav.addObject("appo", appo);
		mav.setViewName("appointmentmanager");
		return mav;
    }
        
    @GetMapping("/editappointment/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));
        model.addAttribute("appointment", appointment);
        return "update-appointment";
    }
    
    @PostMapping("/updateappointment/{id}")
    public ModelAndView updateAppointment(@PathVariable("id") long id, @Valid Appointment appointment, BindingResult result, Model model) {   
    	appointment.setActiveIndicator("Y");
        appointmentRepository.save(appointment);
		ModelAndView mav = new ModelAndView();
		List<AppointmentResultEntity> appo = appointmentRepository.findAllActiveAppointments();
	
		mav.addObject("appo", appo);
		mav.setViewName("appointmentmanager");
		return mav;
    }
    
    @GetMapping("/deleteappointment/{id}")
    public ModelAndView deleteAppointment(@PathVariable("id") long id, Model model) {
    	Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));
    	
    	appointment.setActiveIndicator("N");
        appointmentRepository.save(appointment);

		ModelAndView mav = new ModelAndView();
		List<AppointmentResultEntity> appo = appointmentRepository.findAllActiveAppointments();
	
		mav.addObject("appo", appo);
		mav.setViewName("appointmentmanager");
		return mav;
    }
}
