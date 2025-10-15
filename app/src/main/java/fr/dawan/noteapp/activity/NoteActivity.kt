package fr.dawan.noteapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import fr.dawan.noteapp.activity.ui.theme.NoteAppTheme
import fr.dawan.noteapp.model.NoteDao
import fr.dawan.noteapp.model.NoteRepository
import fr.dawan.noteapp.screens.NoteScreen
import fr.dawan.noteapp.viewmodel.NoteViewModel

@AndroidEntryPoint
class NoteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {

                val email = intent.getStringExtra("email")
                val password = intent.getStringExtra("password")

                NoteScreen(
                    email = email,
                    password = password
                )
            }
        }
    }
}
