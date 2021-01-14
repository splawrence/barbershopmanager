package com.thrivent.barbershop.barbershopweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thrivent.barbershop.barbershopweb.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("FROM Customer WHERE activeIndicator = 'Y'")
	public Customer[] findAllActive();
}


//	public List<Customer> findByLastName(String lastName);


//public List<Customer> findByFirstName(String firstName);

//public Optional<Customer> findById(Long id);
//public List<PayeeAddressDAO> findByMfExpPayeeId(@Param("mfExpPyeeId") int mfExpPyeeId);