package fr.dawan.noteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dawan.noteapp.model.Note
import fr.dawan.noteapp.model.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor (
    private val noteRepository: NoteRepository
) : ViewModel(){

    private var _notes : MutableStateFlow<List<Note>> = MutableStateFlow(
        emptyList()
    )
    val notes : StateFlow<List<Note>> = _notes

    fun insertNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
        getAllNotes()
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        if(note.title.isBlank() || note.content.isBlank()){
            return@launch
        }
        noteRepository.updateNote(note)
    }

    fun getAllNotes() = viewModelScope.launch {
        noteRepository.getNotes().collectLatest { notesList ->
            _notes.value = notesList
        }
    }

    fun getNoteById(id: Int) = viewModelScope.launch {
        noteRepository.getNoteById(id)
    }

    fun deleteAllNotes() = viewModelScope.launch {
        noteRepository.deleteAllNotes()
        getAllNotes()
    }


    fun researchNotes(query: String) = viewModelScope.launch {
        noteRepository.researchNotes(query).collectLatest { notesList ->
            _notes.value = notesList
        }
    }
}