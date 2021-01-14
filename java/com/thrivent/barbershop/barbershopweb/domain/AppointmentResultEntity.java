package com.thrivent.barbershop.barbershopweb.domain;

import java.time.LocalDateTime;
import java.util.Date;


public class AppointmentResultEntity {

	private long id;
    private String barberName;
    private String customerName;
    private LocalDateTime appDate;
    private String activeIndicator;

    public AppointmentResultEntity() {}
    
//    public AppointmentResultEntity(long id, String barberName, String customerName, Date date, String activeIndicator) {
//		super();
//		this.id = id;
//		this.barberName = barberName;
//		this.customerName = customerName;
//		this.date = date;
//		this.activeIndicator = activeIndicator;
//	}
    
    public AppointmentResultEntity(long id, String barberName, String customerName, LocalDateTime appDate, String activeIndicator) {
		super();
		this.id = id;
		this.barberName = barberName;
		this.customerName = customerName;
		this.appDate = appDate;
		this.activeIndicator = activeIndicator;
	}

    public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getBarberName() {
		return barberName;
	}



	public void setBarberName(String barberName) {
		this.barberName = barberName;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	public LocalDateTime getAppDate() {
        return appDate;
    }

	
	
    public void setAppDate(LocalDateTime appDate) {
        this.appDate = appDate;
    }

    
    
	public String getActiveIndicator() {
		return activeIndicator;
	}

	
	
	public void setActiveIndicator(String activeIndicator) {
		this.activeIndicator = activeIndicator;
	}
}