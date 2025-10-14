package fr.dawan.noteapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.dawan.noteapp.R
import fr.dawan.noteapp.components.NoteItem
import fr.dawan.noteapp.components.NoteTopAppBar
import fr.dawan.noteapp.names
import fr.dawan.noteapp.navigation.BottomNavigationBar
import fr.dawan.noteapp.navigation.NavRoute
import fr.dawan.noteapp.ui.theme.Background
import fr.dawan.noteapp.ui.theme.ButtonBg
import fr.dawan.noteapp.ui.theme.CardBg
import fr.dawan.noteapp.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NoteScreen(
    email: String? = "email@mail.com",
    password: String? = "123654789"
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        topBar = { NoteTopAppBar(email) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = ButtonBg,
                contentColor = TextColor
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Notifications"
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = NavRoute.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavRoute.Home.route) {
                HomeScreen()
            }
            composable(NavRoute.Details.route) {
                DetailsScreen()
            }
            composable(NavRoute.Profile.route) {
                ProfileScreen()
            }
        }
    }
}
