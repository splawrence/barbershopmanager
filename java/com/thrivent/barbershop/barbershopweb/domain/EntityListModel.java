package com.thrivent.barbershop.barbershopweb.domain;


public class EntityListModel {
	private Customer[] searchCustomerList;
	private Appointment[] searchAppointmentList;
	private Barber[] searchBarberList;
	
	public Customer[] getSearchCustomerList() {
		return searchCustomerList;
	}
	public void setSearchCustomerList(Customer[] searchCustomerList) {
		this.searchCustomerList = searchCustomerList;
	}
	public Appointment[] getSearchAppointmentList() {
		return searchAppointmentList;
	}
	public void setSearchAppointmentList(Appointment[] searchAppointmentList) {
		this.searchAppointmentList = searchAppointmentList;
	}
	public Barber[] getSearchBarberList() {
		return searchBarberList;
	}
	public void setSearchBarberList(Barber[] searchBarberList) {
		this.searchBarberList = searchBarberList;
	}
}
