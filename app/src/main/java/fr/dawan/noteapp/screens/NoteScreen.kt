package fr.dawan.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
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
    var showPopup by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Jaune", "Vert", "Bleu")
    val colors = listOf(Color.Yellow, Color.Green, Color.Blue)
    var colorSelected by remember { mutableStateOf(colors[0]) }


    if (expanded){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight()
                .background(
                    color = ButtonBg,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(text = "Choisir une couleur")
            }

            // Menu Contextuel
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },

            ) {
                options.forEach { option ->
                   Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       DropdownMenuItem(
                           modifier = Modifier.wrapContentSize(),
                           text = { Text(text = option) },
                           onClick = {
                               colorSelected = colors[options.indexOf(option)]
                               expanded = false
                           },
                           trailingIcon = {
                               Box(
                                   modifier = Modifier
                                       .size(20.dp)
                                       .background(
                                           color = colors[options.indexOf(option)],
                                           shape = RoundedCornerShape(5.dp)
                                       )
                               )
                           }
                       )
                   }
                }
            }
        }
    }

    if (showPopup){
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { showPopup = false },
            properties = PopupProperties(focusable = false)
        )
        {
            Box(modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight()
                .background(
                    color = ButtonBg,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment
                        .CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {

                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(text = "Titre de la note")
                        }
                    )

                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(text = "description de la note")
                        }
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = {showPopup = false}) {
                            Text(text = "Fermer")
                        }

                        Button(onClick = {showPopup = false}) {
                            Text(text = "Valider")
                        }
                    }
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Background,
        topBar = { NoteTopAppBar(email) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    expanded = true
                },
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
