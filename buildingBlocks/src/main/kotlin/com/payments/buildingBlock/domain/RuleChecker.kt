package com.payments.buildingBlock.domain
class RuleChecker {
    fun checkAllRules(vararg rules: BusinessRule) {
        val brokenRules = rules.filter { it.isBroken() }

        if (brokenRules.isNotEmpty()) {
            throw BusinessRulesBrokenException(brokenRules)
        }
    }
}