package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@Composable
fun PaymentInformation() {
    Text(text = "Payment Information")
}

@Composable
@Preview
fun previewPaymentInformation() {
    UnidadResidencialAlameda181Theme {
        PaymentInformation()
    }
}