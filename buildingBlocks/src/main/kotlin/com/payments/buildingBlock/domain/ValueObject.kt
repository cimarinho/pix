package com.payments.buildingBlock.domain
abstract class ValueObject {

    override fun equals(other: Any?): Boolean {
        if (other == null || this::class.simpleName != other::class.simpleName) {
            return false
        }
        return super.equals(other)
    }

    protected companion object {
        fun checkRule(rule: BusinessRule) {
            if (rule.isBroken()) {
                throw  BusinessRuleValidationException(rule);
            }
        }
    }
}