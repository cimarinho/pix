package com.payments.orchestration.application.pix.receive

import com.payments.buildingBlock.application.CommandHandler
import org.springframework.stereotype.Service

@Service
class PixReceiveCommandHandler(

) : CommandHandler<PixReceiveCommand> {
    override fun handle(command: PixReceiveCommand) {
        println("PixReceiveCommandHandler $command")
    }
}