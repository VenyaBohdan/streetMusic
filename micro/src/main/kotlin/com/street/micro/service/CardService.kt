package com.street.micro.service

import com.street.micro.entity.Card
import org.springframework.stereotype.Service

@Service
interface CardService {

    fun getCardById(id: String): Card
    fun getAllCards(): List<Card>

}