package com.pio.jpaonemanybidirectional.repository;

import com.pio.jpaonemanybidirectional.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
