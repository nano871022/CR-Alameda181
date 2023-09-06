package co.com.alameda181.unidadresidencialalameda181.ui.composite.navigator

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.com.alameda181.unidadresidencialalameda181.ui.composite.home.HomeScreen

@Composable
fun Navigator(navController: NavHostController,modifier:Modifier,context:Context){
    NavHost(navController = navController, startDestination = "home",modifier = modifier) {

        composable("home") { HomeScreen(context = context) }

        composable("acerca de"){
            Text(text = "Acerca De",modifier = Modifier.zIndex(123f).border(2.dp, Color.Red,
                RectangleShape
            ).fillMaxWidth().fillMaxHeight().padding(50.dp))
        }

        composable("schedules"){
            Text(text = "Schedules",modifier = Modifier.zIndex(123f).border(2.dp, Color.Red,
                RectangleShape
            ).fillMaxWidth().fillMaxHeight().padding(50.dp))
        }

        composable("administrationpayment"){
            Text(text = "Administration Payment",modifier = Modifier.zIndex(123f).border(2.dp, Color.Red,
                RectangleShape
            ).fillMaxWidth().fillMaxHeight().padding(50.dp))
        }
    }
}