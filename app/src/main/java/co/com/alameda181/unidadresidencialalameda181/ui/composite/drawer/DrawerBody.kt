package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import android.view.MenuItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Composable
fun DrawerBody(
    menuItems: List<String>
    , scope: CoroutineScope
    , modifier: Modifier = Modifier
    , onItemClick: (String) -> Unit
){
    LazyColumn(modifier = modifier){
        items(menuItems) { menuItem ->
            DrawerItem( menuItem, modifier = Modifier){
                scope.launch {
                }
                onItemClick(menuItem)
            }

        }
    }
}