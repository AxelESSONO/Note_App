package fr.dawan.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fr.dawan.noteapp.ui.theme.Background
import fr.dawan.noteapp.ui.theme.TextColor

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Profile Screen",
            color = TextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    }
}