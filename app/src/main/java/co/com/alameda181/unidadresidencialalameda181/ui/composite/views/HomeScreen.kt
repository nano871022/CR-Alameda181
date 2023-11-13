package co.com.alameda181.unidadresidencialalameda181.ui.composite.views

import android.content.Context
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.com.alameda181.ui.theme.theme.MaterialThemeComposeUI
import co.com.alameda181.unidadresidencialalameda181.model.HomeScreen.HomeScreenModel
import coil.compose.AsyncImage
import coil.memory.MemoryCache
import kotlinx.coroutines.delay

val DELAY_CAROUSEL = 10000L

@RequiresApi(34)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenModel:HomeScreenModel = viewModel()
) {
    val homeScreenState by homeScreenModel.uiState.collectAsState()
    val pagerState = rememberPagerState(pageCount = {homeScreenState.carouselList.size})
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()
    if(isDragged.not()){
        with(pagerState){
            var currentPageKey by remember { mutableIntStateOf(0) }
            LaunchedEffect(key1 = currentPageKey){
                delay(DELAY_CAROUSEL)
                val nextPage = (currentPage + 1) % pageCount
                animateScrollToPage(nextPage)
                currentPageKey = nextPage
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
                , verticalArrangement = Arrangement.Top
                , horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box {
            HorizontalPager(
                contentPadding = PaddingValues(horizontal = 10.dp),
                pageSpacing = 5.dp,
                state = pagerState
            ) {
                val image = homeScreenState.carouselList[it]
                if (image.url.isEmpty()) {
                    CarouselItem(image.drawable, image.name)
                } else {
                    CarouselItemWeb(url = image.url, drawableName = image.name)
                }

            }
            DotIndicator(
                pageCount = homeScreenState.carouselList.size,
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
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
    val rotationState = remember { mutableFloatStateOf(1f) }
    val scale = remember { mutableFloatStateOf(1f) }
    val offset = remember { mutableStateOf(Offset(0f,0f)) }
    Card(
        modifier = Modifier.padding(10.dp)
            .pointerInput (Unit){
                detectTransformGestures{ centroId,pan,zoom,rotation ->
                    scale.value *= zoom
                    rotationState.floatValue += rotation
                    offset.value = Offset(
                        offset.value.x + (pan.x / density * scale.floatValue),
                        offset.value.y + (pan.y / density * scale.floatValue)
                    )
                }
            }) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = drawableName,
            modifier = Modifier.graphicsLayer {
                scaleX = maxOf(.5f, maxOf(1f,scale.floatValue))
                scaleY = maxOf(.5f, maxOf(1f,scale.floatValue))
                rotationZ = rotationState.value
                translationX = offset.value.x
                translationY = offset.value.y
            }

        )
    }
}

@Composable
fun CarouselItemWeb(url:String,drawableName:String){
    val rotationState = remember { mutableFloatStateOf(1f) }
    val scale = remember { mutableFloatStateOf(1f) }
    var placeholder: MemoryCache.Key? = null
    Card(
        modifier = Modifier.padding(10.dp)
            .pointerInput (Unit){
                detectTransformGestures{ centroId,pan,zoom,rotation ->
                    scale.value *= zoom
                    rotationState.value += rotation
                }}) {
        AsyncImage(
            modifier = Modifier.graphicsLayer {
                scaleX = maxOf(.5f, maxOf(1f,scale.value))
                scaleY = maxOf(.5f, maxOf(1f,scale.value))
                rotationZ = rotationState.value
            },
            model = url,
            error = ColorPainter(Color.Red),
            onSuccess = { placeholder = it.result.memoryCacheKey },
            contentDescription = drawableName
        )
    }
}

@RequiresApi(34)
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun preview(){
    val context:Context = LocalContext.current
    MaterialThemeComposeUI {
            HomeScreen()
        }
}




