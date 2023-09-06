package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawerContent(scope:CoroutineScope,state:DrawerState,navController:NavHostController){
    ModalDrawerSheet (
        drawerContainerColor = Color.White
    ){
        DrawerHeader()
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun preview(){
    drawerContent(scope = rememberCoroutineScope(),state = rememberDrawerState(initialValue = DrawerValue.Closed),navController = rememberNavController())
}