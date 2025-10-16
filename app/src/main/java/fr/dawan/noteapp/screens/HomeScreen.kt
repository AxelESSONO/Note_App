package fr.dawan.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import fr.dawan.noteapp.components.NoteItem
import fr.dawan.noteapp.descriptions
import fr.dawan.noteapp.model.Note
import fr.dawan.noteapp.titles
import fr.dawan.noteapp.ui.theme.Background
import fr.dawan.noteapp.viewmodel.NoteViewModel

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen(
    noteViewModel: NoteViewModel = hiltViewModel()
) {

    noteViewModel.getAllNotes()
    val notes : List<Note> = noteViewModel.notes.collectAsState().value

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().background(Background),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalItemSpacing = 10.dp,
        contentPadding = PaddingValues(10.dp)
    ) {
        items(
            notes,
            key = { note -> note.id }
        ){ note ->
            NoteItem(note)
        }
    }
}


