package com.payments.orchestration.application.balance.validate

import com.payments.buildingBlock.application.CommandHandler
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateSendEvent
import com.payments.orchestration.infrastructure.pix.receiveEvent.PixReceiveEvent
import org.springframework.stereotype.Service

@Service
class BalanceValidateCommandHandler(
    private val balanceValidateSendEvent: BalanceValidateSendEvent,
    private val pixReceiveEvent: PixReceiveEvent,
) : CommandHandler<BalanceValidateCommand> {
    override fun handle(command: BalanceValidateCommand) {
        println("command $command")
        balanceValidateSendEvent.send(command.toEvent())

        pixReceiveEvent.receive(command.correlationId.toString())
    }
}