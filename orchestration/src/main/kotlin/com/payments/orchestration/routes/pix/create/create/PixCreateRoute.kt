package com.payments.orchestration.routes.pix.create.create

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class OrderRoute(

) {

    @PostMapping("/pix")
    fun create(@RequestBody request: PixCreateRequest): ResponseEntity<PixCreateRequest> {
        println("Create $request")


        return ResponseEntity<PixCreateRequest>(request, HttpStatus.CREATED)
    }
}