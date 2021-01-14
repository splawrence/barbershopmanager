package com.thrivent.barbershop.barbershopweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thrivent.barbershop.barbershopweb.domain.Appointment;
import com.thrivent.barbershop.barbershopweb.domain.AppointmentResultEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	@Query("SELECT DISTINCT NEW com.thrivent.barbershop.barbershopweb.domain.AppointmentResultEntity(Appointment.id, CONCAT(Barber.firstName, ' ',Barber.lastName) as barberName, CONCAT(Customer.firstName, ' ', Customer.lastName) as customerName, Appointment.appDate, Appointment.activeIndicator) from Appointment Appointment INNER JOIN Barber Barber ON Appointment.barberId = Barber.id INNER JOIN Customer Customer ON Customer.id = Appointment.customerId WHERE Appointment.activeIndicator = 'Y'")
	public List<AppointmentResultEntity> findAllActiveAppointments();
	
    List<AppointmentResultEntity> findByAppDate(LocalDateTime appDate);
}