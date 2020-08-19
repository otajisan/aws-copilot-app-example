package com.example

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {
  @GetMapping("/")
  fun get(): ResponseEntity<Result> =
      ResponseEntity(Result(message = "Hello AWS Copilot!!!!"), HttpStatus.OK)

  data class Result(
      val message: String
  )
}