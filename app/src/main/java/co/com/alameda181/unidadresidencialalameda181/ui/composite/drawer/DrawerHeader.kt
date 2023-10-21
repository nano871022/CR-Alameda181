package co.com.alameda181.unidadresidencialalameda181.ui.composite.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme

@Composable
fun DrawerHeader() {
    Box(
        Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .fillMaxWidth()
    , contentAlignment = Alignment.Center
    ) {
        Column ( horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {

            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.favicon),
                    contentDescription = stringResource(id = R.string.description_logo)
                )
                Column (modifier = Modifier.padding(start = 5.dp)) {

                    Row(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .padding(5.dp), verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = stringResource(id = R.string.name_first),
                            color = MaterialTheme.colorScheme.inversePrimary
                            ,fontSize = 18.sp
                            , fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = stringResource(id = R.string.name_second),
                            color = MaterialTheme.colorScheme.tertiaryContainer
                            , modifier = Modifier.padding(start=5.dp)
                            ,fontSize = 18.sp
                            , fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Text(text = stringResource(id = R.string.kind_unit), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }

                    Row{
                        Text(text = stringResource(id = R.string.address), fontSize = 12.sp, color = MaterialTheme.colorScheme.inversePrimary)
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun previewHeader(){
    co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme {
        DrawerHeader()
    }
}