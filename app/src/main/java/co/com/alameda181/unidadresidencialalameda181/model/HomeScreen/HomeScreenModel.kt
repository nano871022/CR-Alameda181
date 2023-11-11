package co.com.alameda181.unidadresidencialalameda181.model.HomeScreen

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import co.com.alameda181.unidadresidencialalameda181.adapter.port.CarouselPort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class HomeScreenModel @Inject constructor(application:Application): AndroidViewModel(application) {

    private lateinit var  carouselPort:CarouselPort
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    init{
        val context = (application as Context)
        carouselPort = CarouselPort(context)
        val carouselList = carouselPort.getCarousel()
        _uiState.value = HomeScreenState(carouselList)
    }
}