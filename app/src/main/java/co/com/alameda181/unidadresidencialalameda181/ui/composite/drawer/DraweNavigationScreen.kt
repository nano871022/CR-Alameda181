package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import android.content.res.Resources
import android.view.ContextMenu
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.unidadresidencialalameda181.model.MenuItem
import co.com.alameda181.unidadresidencialalameda181.utils.DrawerRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawerContent(scope:CoroutineScope,state:DrawerState,navController:NavHostController){
    ModalDrawerSheet (
        drawerContainerColor = Color.White
    ){
        val resources = LocalContext.current.resources
        DrawerHeader()
        Spacer(Modifier.height(12.dp))
        val menu = getMenus(resources)
        DrawerBody(menuItems = menu , scope = scope, onItemClick = {
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

fun getMenus(resources:Resources):List<MenuItem>{
    return DrawerRoutes.values().map {
        MenuItem(
            name = resources.getString(it.title),
            iconDrawer = it.icon,
            route = it.name
        )
    }.toList()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun preview(){
    drawerContent(scope = rememberCoroutineScope(),state = rememberDrawerState(initialValue = DrawerValue.Closed),navController = rememberNavController())
}