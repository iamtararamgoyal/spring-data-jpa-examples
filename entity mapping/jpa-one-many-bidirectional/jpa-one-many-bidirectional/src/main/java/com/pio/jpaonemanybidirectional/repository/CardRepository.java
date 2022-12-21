package com.pio.jpaonemanybidirectional.repository;

import com.pio.jpaonemanybidirectional.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
