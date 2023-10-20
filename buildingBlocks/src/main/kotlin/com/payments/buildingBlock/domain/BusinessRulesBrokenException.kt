package com.payments.buildingBlock.domain

class BusinessRulesBrokenException(val brokenRules: List<BusinessRule>) : Exception() {

    override val message: String
        get() = brokenRules.joinToString {
            "${it.id}: ${it.message}"
        }

    override fun toString(): String {
        return brokenRules.joinToString {
            "${it.id}: ${it.message}"
        }
    }
}