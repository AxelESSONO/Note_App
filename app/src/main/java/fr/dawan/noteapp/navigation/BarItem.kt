package fr.dawan.noteapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BarItem(
    val title : String,
    val image : ImageVector,
    val route : String
)

object NavBarItems{
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = NavRoute.Home.route
        ),
        BarItem(
            title = "Details",
            image = Icons.Filled.DateRange,
            route = NavRoute.Details.route
        ),
        BarItem(
            title = "Profile",
            image = Icons.Filled.Person,
            route = NavRoute.Profile.route
        )
    )
}
