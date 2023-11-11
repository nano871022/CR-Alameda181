package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.alameda181.unidadresidencialalameda181.R

@Composable
fun Regulation(){
    val context = LocalContext.current.applicationContext
    val resource = context.resources
    val text = stringResource(id = R.string.regulation_info_detail)
    val html = remember { HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)}
    Column (
        modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = stringResource(id = R.string.regulation_title),modifier=Modifier.padding(bottom = 20.dp))

        Button(onClick = {
            val url = resource.getString(R.string.regulation_link)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }){
            Text(text = stringResource(id = R.string.regulation_info))
        }

        AndroidView(
            factory = {
                TextView(it).apply {
                    movementMethod = LinkMovementMethod.getInstance()
                }
            },
            update = { it.text = html },
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun previewRegulation(){
    co.com.alameda181.ui.theme.theme.MaterialThemeComposeUI {
        Regulation()
    }
}