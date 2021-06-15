package com.street.micro.repository

import com.street.micro.entity.Card
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository : MongoRepository<Card, String> {

    fun findOneById(id: ObjectId): Card

}