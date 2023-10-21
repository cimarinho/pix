package com.payments.orchestration.infrastructure.balance.validate

import com.payments.buildingBlock.infrastructure.EventSend
import org.springframework.stereotype.Component

@Component
class BalanceValidateSendEvent (
) : EventSend<BalanceValidateEvent>() {

    override fun send(event: BalanceValidateEvent) {
        sendMessage(event)
        println("==FOI")
    }
}