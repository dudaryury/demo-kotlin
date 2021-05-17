package com.example.demo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(val persons: Persons, var notes: Notes) {

    @PostMapping
    fun createPerson(@RequestBody person: Person) = persons.save(person)

    @PostMapping("/{personId}/notes")
    fun addNote(@PathVariable personId: Long, @RequestBody note: Note) = note.let {
        it.person = persons.getOne(personId)
        notes.save(it)
    }

    @GetMapping("/{personId}/notes")
    fun getAllNotesByPerson(@PathVariable personId: Long) = notes.findAllByPersonId(personId)
            .map { it.toDto() }
}

private fun Note.toDto() = NoteDto(this.id!!, this.title)