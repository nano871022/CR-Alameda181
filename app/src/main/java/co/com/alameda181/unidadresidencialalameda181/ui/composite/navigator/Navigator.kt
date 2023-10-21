package co.com.alameda181.unidadresidencialalameda181.ui.composite.navigator

import android.content.Context
import android.content.Intent
import android.util.Log
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
import androidx.core.view.ContentInfoCompat.Flags
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.com.alameda181.unidadresidencialalameda181.about.AboutActivity
import co.com.alameda181.unidadresidencialalameda181.ui.composite.Alameda181
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.HomeScreen
import co.com.alameda181.unidadresidencialalameda181.ui.composite.splash.SplashScreen
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.AdministrationPayment
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.GeneralInformation
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.LocalRepairs
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.Location
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.MovementInformation
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.PaymentInformation
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.Regulation
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.RentalInformation
import co.com.alameda181.unidadresidencialalameda181.ui.composite.views.Schedule
import co.com.alameda181.unidadresidencialalameda181.utils.DrawerRoutes
import co.com.alameda181.unidadresidencialalameda181.utils.MAIN_MENU
import co.com.alameda181.unidadresidencialalameda181.utils.MenuOptions
import co.com.alameda181.unidadresidencialalameda181.utils.TopMenuOption

@Composable
fun NavigatorSplash(navController: NavHostController,modifier:Modifier,context:Context){
    NavHost(navController = navController, startDestination = MAIN_MENU.SPLASH.name,modifier = modifier) {
        composable(MAIN_MENU.SPLASH.name) {
            SplashScreen(navController = navController)
        }

        composable(MAIN_MENU.MAIN.name) {
            Alameda181(context = context)
        }
    }
}

@Composable
fun Navigator(navController: NavHostController,modifier:Modifier,context:Context){
    NavHost(navController = navController, startDestination = DrawerRoutes.HOME.name,modifier = modifier) {

        composable(DrawerRoutes.HOME.name) { HomeScreen(context = context) }

        composable(MenuOptions.ABOUT.name){
            co.com.alameda181.unidadresidencialalameda181.about.UI.About()
        }

        composable(TopMenuOption.SCHEDULES.name){Schedule()}

        composable(TopMenuOption.ADMINISTRATION_PAYMENT.name){AdministrationPayment()}

        composable(DrawerRoutes.LOCATION.name){ Location() }

        composable(DrawerRoutes.REGULATION.name){ Regulation() }

        composable(DrawerRoutes.GENERAL_INFORMATION.name){ GeneralInformation() }

        composable(DrawerRoutes.PAYMENT_INFORMATION.name){ PaymentInformation() }

        composable(DrawerRoutes.MOVEMENT_INFORMATION.name){ MovementInformation() }

        composable(DrawerRoutes.LOCAL_REPAIRS.name){ LocalRepairs() }

        composable(DrawerRoutes.RENTAL_INFORMATION.name){ RentalInformation() }
    }
}