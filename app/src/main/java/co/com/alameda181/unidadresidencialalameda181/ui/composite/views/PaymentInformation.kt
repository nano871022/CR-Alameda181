package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.text.Layout.Alignment
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme

@Composable
fun PaymentInformation() {
    val context = LocalContext.current.applicationContext
    val resource = context.resources
    val html = remember {HtmlCompat.fromHtml(resource.getString(R.string.payment_info),HtmlCompat.FROM_HTML_MODE_COMPACT)}

    Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(5.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.pse), contentDescription = "pse")

        AndroidView(factory = {
            TextView(it).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
            update = { it.text = html },)
    }
}

@Composable
@Preview(showBackground = true)
fun previewPaymentInformation() {
    co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme {
        PaymentInformation()
    }
}