package co.com.alameda181.unidadresidencialalameda181.about.UI

import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme
import co.com.alameda181.unidadresidencialalameda181.about.R

@Composable
fun About(){
        Column (
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
                , modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 15.dp, start = 5.dp, end = 5.dp)
        ){
                Row() {
                        Image(
                                painter = painterResource(id = R.drawable.img),
                                contentDescription = stringResource(id = R.string.name)
                        )

                        Text(stringResource(id = R.string.description),modifier=Modifier.padding(start=10.dp))

                }

                Text(stringResource(id = R.string.copy_right), modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 20.dp))

                AppBrothers()

        }

}

@Composable
fun AppBrothers(){
        Divider(modifier=Modifier.padding(10.dp))

        Row() {
                CardTorres()
                CardFinanzas()

        }

        CardOwn()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTorres(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_urtss)
        Card(
                onClick = {
                        val link = url
                        val uri = Uri.parse(link)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(intent)
                },
                modifier = Modifier
                        .width(200.dp)
                        .padding(5.dp)
        ) {

                Image(painter= painterResource(id = R.drawable.urtorressansebastian),contentDescription = stringResource(
                        id = R.string.urtss
                ))
                Divider(modifier=Modifier.padding(top=10.dp, bottom=10.dp))
                Text(text = stringResource(id = R.string.urtss),modifier= Modifier
                        .align(
                                alignment = Alignment.CenterHorizontally
                        )
                        .padding(5.dp))
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardFinanzas(){
        val context = LocalContext.current.applicationContext
        val url = stringResource(id = R.string.url_app_urtss)
        Card( onClick = {
                val link = url
                val uri = Uri.parse(link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
        },modifier = Modifier
                .width(200.dp)
                .padding(5.dp)) {

                Image(painter= painterResource(id = R.drawable.finanzaspersonales),contentDescription = stringResource(
                        id = R.string.fiances
                ))

                Divider(modifier=Modifier.padding(top=10.dp, bottom=10.dp))

                Text(text = stringResource(id = R.string.fiances),modifier= Modifier
                        .align(
                                alignment = Alignment.CenterHorizontally
                        )
                        .padding(5.dp))


        }
}

@Composable
fun CardOwn(){
        val context = LocalContext.current.applicationContext
        val urlGit = stringResource(id = R.string.url_app_github)
        val urlLinkedIn = stringResource(id = R.string.url_app_linkedin)
        val txt = stringResource(R.string.own_detail)
        val html = remember { HtmlCompat.fromHtml(txt, HtmlCompat.FROM_HTML_MODE_COMPACT)}
        Card(modifier=Modifier.padding(10.dp)){

                AndroidView(
                        factory = {
                                TextView(it).apply {
                                        movementMethod = LinkMovementMethod.getInstance()
                                }
                        },
                        update = { it.text = html },
                        modifier= Modifier.padding(20.dp)
                )

                Row(modifier=Modifier.padding(10.dp)) {

                        IconButton(onClick = {
                                val link = urlGit
                                val uri = Uri.parse(link)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                        }, modifier = Modifier.width(100.dp).height(100.dp)) {
                                Image(
                                        painter = painterResource(id = R.drawable.guithub),
                                        contentDescription = stringResource(
                                                id = R.string.own_detail
                                        )
                                )
                        }

                        IconButton(onClick = {
                                val link = urlLinkedIn
                                val uri = Uri.parse(link)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                        }, modifier = Modifier.width(100.dp).height(100.dp).padding(start=10.dp)) {
                                Image(
                                        painter = painterResource(id = R.drawable.linkedin),
                                        contentDescription = stringResource(
                                                id = R.string.own_detail
                                        )
                                )
                        }
                }
        }
}

@Preview(showBackground = true)
@Composable
fun preview(){
        UnidadResidencialAlameda181Theme {
                About()
        }
}

