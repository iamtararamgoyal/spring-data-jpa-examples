package com.pio.jpaonetooneunidirectional.repository;

import com.pio.jpaonetooneunidirectional.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
