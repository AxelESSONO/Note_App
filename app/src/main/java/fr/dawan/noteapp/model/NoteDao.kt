package fr.dawan.noteapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    // CRUD : Create, Read, Update, Delete
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Note

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM notes WHERE titre LIKE :query OR contenu LIKE :query")
    fun searchNotes(query: String): Flow<List<Note>>
}