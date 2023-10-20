package com.payments.buildingBlock.application


interface ResultCommandHandler<in TCommand, TResult> where TCommand : ResultCommand<TResult> {
    fun handle(command: TCommand): TResult
}