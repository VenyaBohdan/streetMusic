package com.street.micro.controller

import com.street.micro.entity.Card
import com.street.micro.repository.CardRepository
import com.street.micro.service.CardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}