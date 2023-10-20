package com.payments.buildingBlock.application


interface CommandHandler<in TCommand> where TCommand : Command {
    fun handle(command: TCommand)
}