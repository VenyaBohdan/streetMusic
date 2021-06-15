package com.street.micro.repository

import com.street.micro.entity.Transaction
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : MongoRepository<Transaction, String> {

    fun findOneById(id: ObjectId): Transaction
    fun findAllByIdIn(id: List<ObjectId>): List<Transaction>

//    @Query("{_id: {\$in: ?0}}")
//    fun findTransactionsByIds(transactions: Iterable<String>): List<Transaction>

}