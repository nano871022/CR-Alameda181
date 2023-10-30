package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme
import co.com.japl.schedule.ui.schedule.ScheduleBoard

@Composable
fun Schedule (){

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_page))
            .fillMaxSize()
    ) {

        ScheduleBoard()

        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_between)))

        contactNumber()

        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_between)))

        email()
    }
}

@Composable
fun email(){
    val context = LocalContext.current.applicationContext
    val resource = context.resources
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(id = R.drawable.baseline_email_24),
            contentDescription = "email"
        )
        
        Text(text = stringResource(id = R.string.contact_email), fontSize = 20.sp)
    }

    Divider()
    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_min_between)))

    Row( modifier = Modifier.fillMaxWidth(),  verticalAlignment = Alignment.CenterVertically
    , horizontalArrangement = Arrangement.SpaceBetween) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = "email"
            )

            Text(text = stringResource(id = R.string.email_contact))
        }

        OutlinedIconButton(onClick = {
            val email = resource.getString(R.string.email_contact)
            val intent = Intent(Intent.ACTION_SEND, Uri.parse("mailto:$email"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra(android.content.Intent.EXTRA_EMAIL, "Buenos Dias")
            intent.putExtra(android.content.Intent.EXTRA_CC, email)
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Asunto")
            val intentEnd = Intent.createChooser(intent,"Send Email Using:")
            intentEnd.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intentEnd)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = "email"
            )
        }
    }
}

@Composable
fun contactNumber(){
    val context = LocalContext.current.applicationContext
    val resource = context.resources
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_contact_phone_24),
            contentDescription = "timer"
        )

        Text(text = stringResource(id = R.string.contact_number), fontSize = 20.sp)
    }

    Divider()

    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_min_between)))

    Row( modifier = Modifier.fillMaxWidth(),  verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceBetween) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_phone_24),
                contentDescription = "call"
            )

            Text(text = stringResource(id = R.string.number_contact))
        }

        OutlinedIconButton(onClick = {
            val phoneNumber = resource.getString(R.string.number_contact).replace(" ","")
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_phone_24),
                contentDescription = "call"
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewSchedule(){
    UnidadResidencialAlameda181Theme {
        Schedule()
    }
}
