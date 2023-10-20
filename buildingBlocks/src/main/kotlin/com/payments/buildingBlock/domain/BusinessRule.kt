package com.payments.buildingBlock.domain

abstract class BusinessRule(
    val message: String,
    val id: String
) {
    abstract fun isBroken(): Boolean
}

