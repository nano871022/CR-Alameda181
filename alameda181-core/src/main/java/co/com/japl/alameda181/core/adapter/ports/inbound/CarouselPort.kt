package co.com.japl.alameda181.core.adapter.ports.inbound

import androidx.annotation.RequiresApi
import co.com.japl.alameda181.core.adapter.ports.inbound.interfaces.ICarousel
import co.com.japl.alameda181.core.model.Carousel
import java.util.Collections
import javax.inject.Inject


class CarouselPort @Inject constructor(private var carouselUserCase:co.com.japl.alameda181.core.usercase.interfaces.ICarousel) : ICarousel{
    @RequiresApi(34)
    override suspend fun getList(): List<Carousel> {
        return carouselUserCase.getCarousel() ?: Collections.emptyList()
    }
}