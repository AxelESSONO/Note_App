package fr.dawan.noteapp.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.dawan.noteapp.ui.theme.ButtonBg
import fr.dawan.noteapp.ui.theme.CardBg
import fr.dawan.noteapp.ui.theme.SeparatorColor

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BottomNavigationBar(
    navController: NavHostController = rememberNavController(),
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                drawLine(
                    color = SeparatorColor,
                    start = Offset(0f, 0f),// Départ coin haut gauche
                    end = Offset(size.width, 0f), // Fin coin haut droit
                    strokeWidth = strokeWidth // Épaisseur du trait
                )
            },
        containerColor = CardBg
    ){
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title
                    )
                },
                label = {
                    Text(text = navItem.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = ButtonBg,
                    selectedTextColor = ButtonBg,
                    unselectedIconColor = SeparatorColor,
                    unselectedTextColor = SeparatorColor,
                    indicatorColor = CardBg
                )
            )
        }
    }
}