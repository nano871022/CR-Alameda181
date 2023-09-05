package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import android.view.MenuItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DrawerItem(menuItem: String, modifier:Modifier = Modifier, onItemClick:(String)->Unit) {
   Column(
       modifier = Modifier.clickable {onItemClick(menuItem)}

   ) {
       Row (verticalAlignment = Alignment.CenterVertically
       , modifier = modifier.padding(8.dp)){
           Text(
               text = menuItem
               ,modifier = Modifier.padding(horizontal = 10.dp)
           )
       }
       Divider()
   }
}