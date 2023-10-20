package com.payments.buildingBlock.infrastructure


interface EventSend<in TEvent> where TEvent : Event {
    fun send(event: TEvent)
}