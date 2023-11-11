package co.com.alameda181.unidadresidencialalameda181.model.HomeScreen

import co.com.japl.interfaces.dtos.CarouselDTO

data class HomeScreenState(
    val carouselList:List<CarouselDTO> = emptyList()
)
