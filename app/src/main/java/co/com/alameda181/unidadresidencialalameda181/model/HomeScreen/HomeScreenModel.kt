package co.com.alameda181.unidadresidencialalameda181.model.HomeScreen

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.alameda181.unidadresidencialalameda181.Aplication
import co.com.alameda181.unidadresidencialalameda181.module.Module
import co.com.alameda181.unidadresidencialalameda181.module.ModuleProvides
import co.com.alameda181.unidadresidencialalameda181.module.MyEntryPoint
import co.com.japl.alameda181.core.adapter.ports.inbound.CarouselPort
import co.com.japl.alameda181.core.adapter.ports.inbound.interfaces.ICarousel
import co.com.japl.alameda181.core.usercase.Carousel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.EntryPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Collections
import javax.inject.Inject


@RequiresApi(34)
@HiltViewModel
class HomeScreenModel @Inject constructor(private val application:Application): AndroidViewModel(application ) {

    var carouselPort:ICarousel?=EntryPoints.get(application,MyEntryPoint::class.java).carouselPort()
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    init{
        viewModelScope.launch {
            val carouselList = carouselPort?.getList() ?: Collections.emptyList()
            _uiState.value = HomeScreenState(carouselList)


        }
    }

}