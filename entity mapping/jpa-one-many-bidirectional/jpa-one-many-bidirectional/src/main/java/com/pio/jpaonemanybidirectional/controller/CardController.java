package com.pio.jpaonemanybidirectional.controller;

import com.pio.jpaonemanybidirectional.model.Card;
import com.pio.jpaonemanybidirectional.model.Item;
import com.pio.jpaonemanybidirectional.repository.CardRepository;
import com.pio.jpaonemanybidirectional.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        try {
            Card save = cardRepository.save(card);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Card>> getCards() {
        try {
            List<Card> cards = (List<Card>) cardRepository.findAll();
            if (!cards.isEmpty())
                return new ResponseEntity<>(cards, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCard(@PathVariable("cardId") long cardId) {
        try {
            Optional<Card> cards = cardRepository.findById(cardId);
            if (cards.isPresent())
                return new ResponseEntity<>(cards.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable("cardId") long cardId, @RequestBody Card card) {

        try {
            Card oldCard = cardRepository.findById(cardId).get();
            oldCard.setName(card.getName());
            oldCard.setItems(card.getItems());
            Card save = cardRepository.save(oldCard);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*@PutMapping("/{id}/item")
    public Card updateCardAndItems(@PathVariable("id") long id, @RequestBody Card card) {
        Card oldCard = cardRepository.findById(id).get();
        List<Item> items = card.getItems();
        List<Item> existItem = oldCard.getItems();
        existItem.addAll(items);
        oldCard.setItems(existItem);
        oldCard.setName(card.getName());
        return cardRepository.save(oldCard);
    }*/

    @PutMapping("/{cardId}/item/{itemId}")
    public Card updateCardAndItem(@PathVariable("cardId") long cardId, @PathVariable("itemId") long itemId) {
        Item item = itemRepository.findById(itemId).get();
        Card card = cardRepository.findById(cardId).get();
        List<Item> items = card.getItems();
        items.add(item);
        card.setItems(items);
        return cardRepository.save(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable("id") long id) {
        cardRepository.deleteById(id);
    }


}
