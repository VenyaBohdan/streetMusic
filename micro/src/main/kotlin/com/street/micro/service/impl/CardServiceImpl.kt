package com.street.micro.service.impl

import com.street.micro.entity.Card
import com.street.micro.repository.CardRepository
import com.street.micro.service.CardService
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class CardServiceImpl(
    private val cardRepository: CardRepository
) : CardService {

    override fun getCardById(id: String): Card {
        return cardRepository.findOneById(ObjectId(id))
    }

    override fun getAllCards(): List<Card> {
        return cardRepository.findAll()
    }

}