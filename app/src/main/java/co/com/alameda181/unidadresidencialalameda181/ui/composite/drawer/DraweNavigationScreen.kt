package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.unidadresidencialalameda181.ui.composite.HomeTopAppBar
import co.com.alameda181.unidadresidencialalameda181.ui.composite.home.HomeScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DrawerNavigationScreen(context:Context){

    val state = rememberDrawerState(DrawerValue.Closed)
    val pagerState = rememberPagerState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = state
        , drawerContent = {
            ModalDrawerSheet (
               drawerContainerColor = Color.DarkGray
            ){
                Spacer(Modifier.height(12.dp))
                DrawerBody(menuItems = stringArrayResource(id = R.array.menus).asList() , scope = scope, onItemClick = {
                    item->
                    scope.launch { state.close()  }
                    navController.navigate(item.lowercase()){
                        popUpTo(item.lowercase())
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
        }
    ) {
        Scaffold(
            topBar = {
                HomeTopAppBar(pagerState = PagerState(), scrollBehavior = scrollBehavior,drawerState = state)
            }, modifier = Modifier
            , bottomBar = {Text("Inferior")}
            , containerColor = Color.Black, contentColor = Color.Red
        ){
            NavHost(navController = navController, startDestination = "horarios",modifier = Modifier.padding(it)) {
                composable("home") {HomeScreen(context = context)}
                composable("horarios"){
                    Text(text = "Horario",modifier = Modifier.zIndex(123f).border(2.dp,Color.Red,
                        RectangleShape).fillMaxWidth().fillMaxHeight().padding(50.dp))
                }
            }

            Text(text = "Body", modifier = Modifier.padding(top = 80.dp).border(2.dp,Color.Red,
                RectangleShape).zIndex(0.1f))
        }
}

}