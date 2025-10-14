package fr.dawan.noteapp.navigation

sealed class NavRoute(val route : String) {
    object Home : NavRoute("home")
    object Details : NavRoute("details")
    object Profile : NavRoute("profile")
}