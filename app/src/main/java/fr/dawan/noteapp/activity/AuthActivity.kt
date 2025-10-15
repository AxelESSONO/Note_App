package fr.dawan.noteapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import fr.dawan.noteapp.screens.AuthScreen
import fr.dawan.noteapp.ui.theme.NoteAppTheme

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                AuthScreen { email, password ->
                    val noteIntent = Intent(
                        this, NoteActivity::class.java)

                    // Send email and password to NoteActivity
                    noteIntent.putExtra("email", email)
                    noteIntent.putExtra("password", password)

                    // Start NoteActivity
                    startActivity(noteIntent)
                }
            }
        }
    }
}