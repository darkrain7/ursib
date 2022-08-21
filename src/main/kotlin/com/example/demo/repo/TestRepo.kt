package com.example.demo.repo

import com.example.demo.entity.TestEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepo: CrudRepository<TestEntity, Long> {
}