package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme

@Composable
fun RentalInformation() {
    Text(text = "Rental Information")
}

@Composable
@Preview
fun previewRentalInformation() {
    co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme {
        RentalInformation()
    }
}