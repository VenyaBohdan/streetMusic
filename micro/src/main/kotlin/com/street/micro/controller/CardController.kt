package com.street.micro.controller

import com.street.micro.entity.Card
import com.street.micro.service.CardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/card")
class CardController(
    private val cardService: CardService
) {
    @GetMapping
    fun getAllCards(): ResponseEntity<List<Card>> {
        val cards = cardService.getAllCards()
        return ResponseEntity.ok(cards)
    }

    @GetMapping("/{id}")
    fun getCardById(@PathVariable id: String): ResponseEntity<Card> {
        return ResponseEntity.ok(cardService.getCardById(id))
    }

    @PostMapping
    fun saveCard(@RequestBody card: Card): Card {
        return cardService.saveCard(card)
    }

    @DeleteMapping("/{id}")
    fun deleteCard(@PathVariable id: String) {
        cardService.deleteCard(id)
    }
}