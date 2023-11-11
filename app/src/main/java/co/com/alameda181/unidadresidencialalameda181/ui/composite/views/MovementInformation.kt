package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun MovementInformation (){

    Column(
        modifier=Modifier.padding(10.dp)
    ) {

        ScheduleMovement()

        MoreInformationMovement()

        RequirementsMovement()
    }
}

@Composable
fun RequirementsMovement(){

    val text = stringResource(id = R.string.require_for_movement_detail)
    val html = remember { HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)}

    Row(modifier = Modifier.padding(top=10.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_rule_24),
            contentDescription = stringResource(id = R.string.require_for_movement)
        )
        Text(text = stringResource(id = R.string.require_for_movement),modifier= Modifier.padding(start=5.dp))

    }

    Divider()

    AndroidView(
        factory = {
            TextView(it).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        update = { it.text = html },
        modifier = Modifier.padding(top=5.dp)
    )
}

@Composable
fun MoreInformationMovement(){

    val text = stringResource(id = R.string.schedule_movement_info_detail)
    val html = remember { HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)}
    Row(modifier = Modifier.padding(top=10.dp)) {
        Icon(
            painter = painterResource(id = co.com.alameda181.unidadresidencialalameda181.about.R.drawable.baseline_info_24),
            contentDescription = stringResource(id = R.string.schedule_movement_information)
        )
        Text(text = stringResource(id = R.string.schedule_movement_information),modifier= Modifier.padding(start=5.dp))

    }

    Divider()

    AndroidView(
        factory = {
            TextView(it).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        update = { it.text = html },
        modifier = Modifier.padding(top=5.dp)
    )

}

@Composable
fun ScheduleMovement(){
    val text = stringResource(id = R.string.schedule_movement_date)
    val html = remember { HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)}

    val scheduleOut = stringResource(id = R.string.schedule_out_dont_allow)
    val htmlScheduleOut = remember { HtmlCompat.fromHtml(scheduleOut, HtmlCompat.FROM_HTML_MODE_COMPACT)}
    Row() {
        Icon(
            painter = painterResource(id = co.com.alameda181.unidadresidencialalameda181.about.R.drawable.baseline_schedule_24),
            contentDescription = stringResource(id = R.string.schedule_movement)
        )
        Text(text = stringResource(id = R.string.schedule_movement),modifier= Modifier.padding(start=5.dp))

    }

    Divider()

    AndroidView(
        factory = {
            TextView(it).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        update = { it.text = html },
        modifier = Modifier.padding(top=5.dp)
    )

    AndroidView(
        factory = {
            TextView(it).apply {
                movementMethod = LinkMovementMethod.getInstance()
            }
        },
        update = { it.text = htmlScheduleOut },
        modifier = Modifier.padding(top=5.dp)
    )

    Text(text = stringResource(id = R.string.holiday_dont_allow),modifier= Modifier.padding(start=5.dp))
}

@Composable
@Preview(showBackground = true)
fun previewMovementInformation(){
    MaterialThemeComposeUI {
        MovementInformation()
    }
}