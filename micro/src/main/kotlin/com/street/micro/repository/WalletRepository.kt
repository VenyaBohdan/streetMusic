package com.street.micro.repository

import com.street.micro.entity.Wallet
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository : MongoRepository<Wallet, String> {

    fun findOneById(id: ObjectId): Wallet

}