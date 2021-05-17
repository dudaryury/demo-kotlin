package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
data class Note(
        @Id @GeneratedValue val id: Long?,
        val title: String,
        @ManyToOne @JoinColumn(name = "person_id") var person: Person?
)

data class NoteDto(val id: Long, val title: String)

interface Notes : JpaRepository<Note, Long> {
    fun findAllByPersonId(personId: Long): List<Note>
}