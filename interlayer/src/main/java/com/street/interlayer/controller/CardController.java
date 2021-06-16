package com.street.interlayer.controller;

import com.street.interlayer.model.Card;
import com.street.interlayer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Card> getCardById(@PathVariable String id) {
        return ResponseEntity.ok(cardService.getCardById(Long.valueOf(id)));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        if (card != null) {
            return ResponseEntity.ok(cardService.saveCard(card));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        cardService.deleteCard(Long.valueOf(id));
    }

}
