package com.thrivent.barbershop.barbershopweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="APPOINTMENT_ID")
    private long id;
    @Column(name="BARBER_ID")
    private long barberId;
    @Column(name="CUSTOMER_ID")
    private long customerId;
    @Column(name="APP_DATE")
    private LocalDateTime appDate;
    @Column(name="ACTIVE_INDICATOR")
    private String activeIndicator;

    public Appointment() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBarberId() {
        return barberId;
    }

    public void setBarberId(long barberId) {
        this.barberId = barberId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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