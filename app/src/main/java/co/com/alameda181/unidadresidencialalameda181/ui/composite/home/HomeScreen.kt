package co.com.alameda181.unidadresidencialalameda181.ui.composite.home

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    context:Context,
    modifier:Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
                , verticalArrangement = Arrangement.Center
                , horizontalAlignment = Alignment.CenterHorizontally

    ) {
        HomePagerScreen(
            text = stringResource(id = R.string.home_info),
            pagerState = PagerState(),
            modifier = modifier
        )
    }

}
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun HomePagerScreen(
        text:String,
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ){
        Text(text,modifier.fillMaxSize())
    }

    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun preview(){
    UnidadResidencialAlameda181Theme{
        HomePagerScreen(stringResource(id = R.string.home_info),pagerState = PagerState())
    }
}



