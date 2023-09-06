package co.com.alameda181.unidadresidencialalameda181.ui.composite.menuoptions

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.unidadresidencialalameda181.R
import kotlinx.coroutines.launch

@Composable
fun MenuOptions(expandedRemember:MutableState<Boolean>,onClick: (String) -> Unit) {
    val context = LocalContext.current.applicationContext
    DropdownMenu(
        expanded = expandedRemember.value
        , onDismissRequest = { expandedRemember.value = !expandedRemember.value}
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
           stringArrayResource(id = R.array.menu_settings).forEach {
                MenuItems(text = it, onClick = onClick)
            }
        }
    }
}

@Composable
fun MenuItems(text:String,onClick : (String) -> Unit){
    DropdownMenuItem(
        text = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = stringResource(id = R.string.menu_more)
                )
                Text(text = text)
            }
        }
        , onClick = {
            onClick(text)
        }
    )
}

@Composable
@Preview
fun previewMenuOptions(){
    MenuOptions( expandedRemember = remember { mutableStateOf(true) }, onClick ={})
}