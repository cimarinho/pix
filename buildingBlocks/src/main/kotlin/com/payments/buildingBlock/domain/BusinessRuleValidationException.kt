package com.payments.buildingBlock.domain

class BusinessRuleValidationException(val brokenRule: BusinessRule) : Exception(brokenRule.message) {
    val details: String = brokenRule.message

    override fun toString(): String {
        return "${brokenRule::class.simpleName}: ${brokenRule.message}"
    }
}