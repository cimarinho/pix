package com.payments.orchestration.presenter.pix.create.create

import com.payments.orchestration.application.balance.validate.BalanceValidateCommandHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class PixCreateRoute(
    private val balanceValidateCommandHandler: BalanceValidateCommandHandler,

    ) {
    @PostMapping("/pix")
    fun create(@RequestBody request: PixCreateRequest): ResponseEntity<PixCreateRequest> {
        println("Create $request")
        val correlationId = UUID.randomUUID()
        balanceValidateCommandHandler.handle(request.toCommand(correlationId))
        return ResponseEntity<PixCreateRequest>(request, HttpStatus.CREATED)
    }
}