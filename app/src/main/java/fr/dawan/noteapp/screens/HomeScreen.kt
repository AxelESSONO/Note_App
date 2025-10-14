package fr.dawan.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.dawan.noteapp.components.NoteItem
import fr.dawan.noteapp.names
import fr.dawan.noteapp.ui.theme.Background

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .background(Background),
        horizontalArrangement = Arrangement
            .spacedBy(10.dp),
        verticalItemSpacing = 10.dp,
        contentPadding = PaddingValues(10.dp)
    ) {
        items(names){ name ->
            NoteItem(name)
        }
    }
}


