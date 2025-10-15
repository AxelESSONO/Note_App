package fr.dawan.noteapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.dawan.noteapp.model.NoteDao
import fr.dawan.noteapp.model.NoteDatabase
import fr.dawan.noteapp.model.NoteRepository
import fr.dawan.noteapp.viewmodel.NoteViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    // Une instance unique de la base de données
    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context, NoteDatabase::class.java, "note_db").build()
    }

    // Une instance unique du DAO
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.getNoteDao()

    // Une instance unique du repository
    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao) = NoteRepository(noteDao)

    // Une instance unique du ViewModel
    @Singleton
    @Provides
    fun provideNoteViewModel(noteRepository: NoteRepository) =
        NoteViewModel(noteRepository)
}