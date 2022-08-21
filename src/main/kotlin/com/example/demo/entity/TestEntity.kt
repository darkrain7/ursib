package com.example.demo.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "test")
data class TestEntity(

    @Id
    val id: Long? = null,

    @Column(name = "document_id")
    val documentId: Long,

    @Column(name = "document_date")
    val documentDate: LocalDate,

    @Column(name = "dictionary_id")
    val dictionaryId: Long,

    @Column(name = "dictionary_name")
    val dictionaryName: String,

    @Column(name = "sort_order")
    val sortOrder: Long

)
