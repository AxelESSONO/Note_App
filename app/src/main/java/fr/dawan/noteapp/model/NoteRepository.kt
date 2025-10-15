package fr.dawan.noteapp.model

import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteDao: NoteDao
) {

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    fun getNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    suspend fun getNoteById(id: Int): Note {
        return noteDao.getNoteById(id)
    }

    suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    fun researchNotes(query: String): Flow<List<Note>> {
        return noteDao.searchNotes(query)
    }
}