package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@Composable
fun Schedule (){
    Text(text = "Schedules",modifier = Modifier
        .zIndex(123f)
        .border(
            2.dp, Color.Red,
            RectangleShape
        )
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(50.dp))
}

@Composable
@Preview
fun previewSchedule(){
    UnidadResidencialAlameda181Theme {
        Schedule()
    }
}
