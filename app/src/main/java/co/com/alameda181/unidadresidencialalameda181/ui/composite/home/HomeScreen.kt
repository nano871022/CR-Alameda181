package co.com.alameda181.unidadresidencialalameda181.ui.composite.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.alameda181.unidadresidencialalameda181.ui.composite.HomeTopAppBar
import co.com.alameda181.unidadresidencialalameda181.ui.theme.UnidadResidencialAlameda181Theme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    context:Context,
    modifier:Modifier = Modifier
) {
    Log.d("HomeScreen", "load")
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black,)
                , verticalArrangement = Arrangement.Center
                , horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Practice")
        HomePagerScreen(
            pagerState = PagerState(),
            modifier = modifier
        )
    }

}
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun HomePagerScreen(
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ){
        Text("Hola Test",Modifier.padding(120.dp).fillMaxSize())
    }

    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun preview(){
    UnidadResidencialAlameda181Theme{
        HomePagerScreen(pagerState = PagerState())
    }
}




