package com.payments.orchestration.application.balance.validate

import com.payments.buildingBlock.application.CommandHandler
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateSendEvent
import org.springframework.stereotype.Service

@Service
class BalanceValidateCommandHandler(
    private val balanceValidateSendEvent: BalanceValidateSendEvent,
) : CommandHandler<BalanceValidateCommand> {
    override fun handle(command: BalanceValidateCommand) {
        println("command $command")
        balanceValidateSendEvent.send(command.toEvent())
    }
}