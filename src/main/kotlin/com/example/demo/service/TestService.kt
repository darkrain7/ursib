package com.example.demo.service

import com.example.demo.dto.TestDto
import com.example.demo.entity.TestEntity
import com.example.demo.exc.TestNotFoundException
import com.example.demo.repo.TestRepo
import org.springframework.stereotype.Service
import java.util.*


@Service
class TestService(
    private val testRepo: TestRepo
) {

    fun save(test: TestDto): TestDto =
        test.toEntity()
            .let { testRepo.save(it) }
            .toDto()

    fun findById(id: Long): Optional<TestDto> =
        testRepo.findById(id).map { it.toDto() }

    fun findByIdIn(ids: List<Long>): List<TestDto> =
        testRepo.findAllById(ids).map { it.toDto() }

    fun update(test: TestDto): TestDto =
        if (test.id == null) throw IllegalArgumentException("id must be not null")
        else findById(test.id)
            .orElseThrow { throw TestNotFoundException(test.id) }
            .let { testRepo.save(test.toEntity()).toDto() }

    fun deleteById(id: Long) = testRepo.deleteById(id)

    private fun TestEntity.toDto(): TestDto =
        TestDto(
            id = id,
            documentId = documentId,
            documentDate = documentDate,
            dictionaryId = dictionaryId,
            dictionaryName = dictionaryName,
            sortOrder = sortOrder
        )

    private fun TestDto.toEntity(): TestEntity =
        TestEntity(
            id = id,
            documentId = documentId,
            documentDate = documentDate,
            dictionaryId = dictionaryId,
            dictionaryName = dictionaryName,
            sortOrder = sortOrder
        )
}