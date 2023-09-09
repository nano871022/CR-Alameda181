package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@Composable
fun GeneralInformation(){
    Text(text = "General Information")
}

@Composable
@Preview
fun previewGeneralInformation(){
    UnidadResidencialAlameda181Theme {
        GeneralInformation()
    }
}