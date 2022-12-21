package com.pio.jpaonemanybidirectional.controller;

import com.pio.jpaonemanybidirectional.model.Item;
import com.pio.jpaonemanybidirectional.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/item")
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping("/item")
    public List<Item> getsItems() {
        List<Item> items = (List<Item>) itemRepository.findAll();
        return items;
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable("id") long id) {
        Item item = itemRepository.findById(id).get();
        return item;
    }

    @PutMapping("/item/{id}")
    public Item updateItem(@PathVariable("id") long id, @RequestBody Item item) {
        Item item1 = itemRepository.findById(id).get();
        item.setId(item1.getId());
        return itemRepository.save(item);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItem(@PathVariable("id") long id) {

        itemRepository.deleteById(id);
    }
}
