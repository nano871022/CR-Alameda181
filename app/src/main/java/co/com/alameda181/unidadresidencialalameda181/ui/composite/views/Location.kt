package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@Composable
fun Location (){
    Text(text = "Location",modifier = Modifier.padding(50.dp))
}

@Composable
@Preview
fun previewLocation(){
    UnidadResidencialAlameda181Theme {
        Location()
    }
}