package com.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class ExampleControllerTest {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @Autowired
  private val mapper = jacksonObjectMapper()

  @Test
  fun `response data contains welcome message`() {

    val expected = ExampleController.Result(
        message = "Hello AWS Copilot!!!!"
    )

    mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk)
        .andExpect(content().json(mapper.writeValueAsString(expected)))
  }
}