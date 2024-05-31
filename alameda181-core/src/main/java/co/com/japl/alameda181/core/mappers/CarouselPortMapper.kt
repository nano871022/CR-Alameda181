package co.com.japl.alameda181.core.mappers

import co.com.japl.alameda181.core.model.Carousel
import co.com.japl.interfaces.dtos.CarouselDTO

object CarouselPortMapper {

    fun mapper(input:CarouselDTO):Carousel{
        return Carousel(input.id,input.name,input.description,input.url,input.order,input.drawable,input.active)
    }
}