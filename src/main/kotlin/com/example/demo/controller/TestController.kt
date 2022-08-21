package com.example.demo.controller

import com.example.demo.dto.TestDto
import com.example.demo.service.TestService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestController(
    private val testService: TestService
) {

    @PostMapping
    fun save(@RequestBody dto: TestDto): TestDto = testService.save(dto)

    @PutMapping
    fun update(@RequestBody update: TestDto) = testService.update(update)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = testService.deleteById(id)

    @GetMapping("/by-id/{id}")
    fun findById(@PathVariable("id") id: Long) = testService.findById(id)

    @PostMapping("/by-ids")
    fun findByIdIn(@RequestBody ids: List<Long>) = testService.findByIdIn(ids)

}