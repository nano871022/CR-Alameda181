package co.com.alameda181.unidadresidencialalameda181.ui.composite

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer.drawerContent
import co.com.alameda181.unidadresidencialalameda181.ui.composite.navigator.Navigator
import co.com.alameda181.unidadresidencialalameda181.ui.composite.topbar.HomeTopAppBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable fun Alameda181 (context: Context){
    val state = rememberDrawerState(DrawerValue.Closed)
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        0
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()


    ModalNavigationDrawer(
        drawerState = state
        , drawerContent = { drawerContent(scope = scope, state = state, navController = navController) }
    ) {
        Scaffold(
            topBar = {
                HomeTopAppBar(pagerState = pagerState, scrollBehavior = scrollBehavior,drawerState = state, navController = navController)
            }, modifier = Modifier
        ) {
            Navigator(navController = navController, modifier = Modifier.padding(it), context = context)
        }
    }
}


@Preview
@Composable
fun preview(){
    Alameda181(context = LocalContext.current)
}

