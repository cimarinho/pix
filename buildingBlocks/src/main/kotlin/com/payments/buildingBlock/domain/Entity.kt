package com.payments.buildingBlock.domain

abstract class Entity {


    abstract val id: Id

    companion object {
        private val ruleChecker: RuleChecker = RuleChecker()
        @JvmStatic
        protected fun checkAllRules(vararg rules: BusinessRule) {
            ruleChecker.checkAllRules(*rules)
        }
    }
}
