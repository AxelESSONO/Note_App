package fr.dawan.noteapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import fr.dawan.noteapp.R
import fr.dawan.noteapp.ui.theme.CardBg
import fr.dawan.noteapp.ui.theme.TextColor

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NoteTopAppBar(email: String?) {
    TopAppBar(
        title = {
            // ?: ==> Elvis Operator
            Text(
                text = email ?: "Email",
                color = TextColor,
                fontWeight = FontWeight.Medium
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Logout",
                    tint = TextColor
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Logout",
                    tint = TextColor
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CardBg
        )
    )
}