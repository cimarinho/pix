package com.payments.pix.application

import com.payments.buildingBlock.application.QueryHandler
import org.springframework.stereotype.Service

@Service
class PixCreateCommandHandler(

) : QueryHandler<PixCreateQuery, PixCreateResult> {

    override fun handle(command: PixCreateQuery) : PixCreateResult {
        println("PixCreateCommandHandler == $command")
        return PixCreateResult(
            name = command.name,
            quantity = command.quantity,
            amount = command.amount,
            correlationId = command.correlationId,
        )
    }
}