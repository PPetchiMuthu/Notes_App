package com.example.notes.domain.use_case

import com.example.notes.domain.model.InvalidNoteException
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NoteRepository

class InsertUseCase(
    private val repository: NoteRepository
){
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note : Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}