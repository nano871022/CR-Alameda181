package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.unidadresidencialalameda181.R

@Composable
fun DrawerHeader() {
    Text(text = stringResource(id = R.string.app_name))
}

@Preview
@Composable
fun previewHeader(){
    DrawerHeader()
}