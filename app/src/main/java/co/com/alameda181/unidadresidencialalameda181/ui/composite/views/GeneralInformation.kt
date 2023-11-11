package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.alameda181.ui.theme.theme.MaterialThemeComposeUI
import co.com.alameda181.unidadresidencialalameda181.R

@Composable
fun GeneralInformation(){
    val txt = stringResource(R.string.general_information_detail)
    val html = remember { HtmlCompat.fromHtml(txt, HtmlCompat.FROM_HTML_MODE_COMPACT)}
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(10.dp)) {

        Row() {
            Icon(
                painter = painterResource(id = R.drawable.baseline_info_24),
                contentDescription = stringResource(
                    id = R.string.general_information
                )
            )

            Text(
                text = stringResource(id = R.string.general_information),
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Divider()

        AndroidView(
            factory = {
                TextView(it).apply {
                    movementMethod = LinkMovementMethod.getInstance()
                }
            },
            update = { it.text = html },
            modifier= Modifier.padding(top = 20.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun previewGeneralInformation(){
    MaterialThemeComposeUI {
        GeneralInformation()
    }
}