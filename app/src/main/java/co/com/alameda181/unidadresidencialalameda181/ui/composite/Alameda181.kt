package co.com.alameda181.unidadresidencialalameda181.ui.composite

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.zIndex
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer.DrawerNavigationScreen
import co.com.alameda181.unidadresidencialalameda181.ui.composite.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun Alameda181 (context: Context){
    Scaffold(
        topBar = {
            DrawerNavigationScreen(context = context)
        }
    ) {
    Text("load", modifier = Modifier.zIndex(3f))
    }

}

