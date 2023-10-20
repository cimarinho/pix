package com.payments.buildingBlock.application


interface QueryHandler<in TQuery, TResult> where TQuery : Query<TResult> {
    fun handle(query: TQuery):TResult
}