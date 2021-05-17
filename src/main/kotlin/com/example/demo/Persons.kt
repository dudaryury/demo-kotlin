package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
        @Id @GeneratedValue val id: Long?,
        val email: String
)

interface Persons : JpaRepository<Person, Long>