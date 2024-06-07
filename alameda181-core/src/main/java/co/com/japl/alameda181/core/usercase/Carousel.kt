package co.com.japl.alameda181.core.usercase

import androidx.annotation.RequiresApi
import co.com.japl.alameda181.core.adapter.ports.outbound.CarouselPort
import co.com.japl.alameda181.core.mappers.CarouselPortMapper
import co.com.japl.alameda181.core.model.Carousel
import co.com.japl.alameda181.core.usercase.interfaces.ICarousel
import java.util.Collections
import javax.inject.Inject

class Carousel @Inject constructor(private var carouselOutBout: CarouselPort) : ICarousel{

    @RequiresApi(34)
    override suspend fun getCarousel():List<Carousel>{
        return carouselOutBout?.getCarousel()?.map ( CarouselPortMapper::mapper ) ?: Collections.emptyList()
    }

}