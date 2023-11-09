package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.content.Context
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme
import co.com.alameda181.unidadresidencialalameda181.R
import co.com.japl.interfaces.dtos.CarouselDTO
import co.com.japl.services.implement.CarouselImpl
import kotlinx.coroutines.delay
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection
import java.net.URL
import java.util.Collections
import java.util.stream.Collectors

@RequiresApi(34)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    context:Context,
    modifier:Modifier = Modifier
) {
   // GDrive().connect(context = context)
    val pagerState = rememberPagerState {
        0
    }
    //getImagesFromUrl(context)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
                , verticalArrangement = Arrangement.Top
                , horizontalAlignment = Alignment.CenterHorizontally

    ) {
        HomePagerScreen(
            context = context,
            pagerState = pagerState,
            modifier = modifier
        )
    }

}
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun HomePagerScreen(
        context:Context,
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ){
        Carousel(context)
    }
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Carousel(context:Context){
    val list = getImagesName(context)

    val pagerState = rememberPagerState(pageCount = {list.size})

    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    if(isDragged.not()){
        with(pagerState){
            var currentPageKey by remember { mutableIntStateOf(0) }
            LaunchedEffect(key1 = currentPageKey){
                delay(3000L)
                val nextPage = (currentPage + 1) % pageCount
                animateScrollToPage(nextPage)
                currentPageKey = nextPage
            }
        }
    }

    Box {
        HorizontalPager(
            contentPadding = PaddingValues(horizontal = 10.dp),
            pageSpacing = 5.dp,
            state = pagerState
        ) {
            CarouselItem(list[it].first, list[it].second)
        }

        DotIndicator(
            pageCount = list.size,
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DotIndicator(pageCount: Int, pagerState: PagerState, modifier: Modifier) {

    Row(modifier=modifier){
        repeat(pageCount){
            val color = if(pagerState.currentPage == it) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.tertiary

            Box(
                modifier = modifier
                    .padding(top = 20.dp, start = 2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(8.dp)
            ){

            }
        }
    }
}

@Composable
fun CarouselItem(drawable: Int,drawableName: String) {
    Card(
        modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = drawableName
        )
    }
}

fun getImagesName(context:Context):List<Pair<Int,String>> {
    val resources = context.resources
    return R.drawable::class.java.fields.filter { it.name.startsWith("carousel") }
        .map{Pair(resources.getIdentifier(it.name,"drawable",context.packageName),it.name)}
        .filter { it.first != 0 }
        .sortedBy { it.second }
}

fun getImagesFromUrl(context: Context):List<CarouselDTO>{
    return CarouselImpl(context).getCarouselHome()
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun preview(){
        val pagerState = rememberPagerState {
            0
        }
    val context:Context = LocalContext.current
    UnidadResidencialAlameda181Theme {
            HomePagerScreen(context, pagerState = pagerState)
        }
}




