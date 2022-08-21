package com.example.demo.dto

import java.time.LocalDate

data class TestDto(
    val id: Long?,
    val documentId: Long,
    val documentDate: LocalDate,
    val dictionaryId: Long,
    val dictionaryName: String,
    val sortOrder: Long
)
