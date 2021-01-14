package com.thrivent.barbershop.barbershopweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.thrivent.barbershop.barbershopweb.domain.Barber;

@Repository
public interface BarberRepository extends PagingAndSortingRepository<Barber, Long> {
	@Query("FROM Barber WHERE activeIndicator = 'Y'")
	public Barber[] findAllActiveBarbers();
}