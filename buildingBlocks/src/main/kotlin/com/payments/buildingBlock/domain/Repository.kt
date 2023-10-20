package com.payments.buildingBlock.domain

import java.math.BigInteger

interface Repository<T, R> where T: Entity, R: Id {

    val clazz: Class<T>

    fun findById(id: R): T?

    fun findAll(): List<T>

    fun save(entity: T): T

    fun saveAll(entities: Iterable<T>)

    fun saveAndCommit(entity: T): T

    fun delete(entity: T)

    fun deleteById(id: R)

    fun nextId(): R

    fun createId(value: BigInteger): R

}