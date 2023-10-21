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

@Composable
fun Schedule (){

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_page))
            .fillMaxSize()
    ) {

        scheduleBoard()

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
fun scheduleBoard(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_calendar_month_24),
            contentDescription = "timer"
        )

        Text(text = stringResource(id = R.string.schedule_administrator), fontSize = 20.sp)
    }

    Divider()

    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.spacer_min_between)))

    Card (modifier = Modifier
        .fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.card_padding_left_right),
                    end = dimensionResource(id = R.dimen.card_padding_left_right),
                    top = dimensionResource(id = R.dimen.card_padding_top_bottom),
                    bottom = dimensionResource(id = R.dimen.card_padding_top_bottom)
                )
        ) {
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(id = R.string.time), fontSize = 12.sp)

                listTimes()
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.monday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_monday)
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.tuesday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_tuesday)
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.wednesday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_wednesday)
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.thursday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_thursday)
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.friday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_friday)
            }
            Column(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_column_schedule),
                    end = dimensionResource(id = R.dimen.padding_column_schedule)
                ), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.saturday), fontSize = 12.sp
                )

                listTimes(R.array.schedule_saturday)
            }

        }
    }
}

@Composable
fun listTimes(idScheduleday:Int){
    val list = stringArrayResource(id = idScheduleday).asList()

    for(i in 8..17) {
        val color = if (list.contains(i.toString())) MaterialTheme.colorScheme.tertiary else Color.Transparent
       Box(
            modifier = Modifier
                .background(color)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_box_schedule_left_right),
                    end = dimensionResource(id = R.dimen.padding_box_schedule_left_right),
                    top = dimensionResource(id = R.dimen.padding_box_schedule_top_bottom),
                    bottom = dimensionResource(id = R.dimen.padding_box_schedule_top_bottom)
                )
        ) {

        }
    }
}

@Composable
fun listTimes(){
    val list = stringArrayResource(id = R.array.schedule_time).forEach {
        Text(text = it, fontSize = 12.sp)
    }
}

@Composable
@Preview(showBackground = true)
fun previewSchedule(){
    co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme {
        Schedule()
    }
}
