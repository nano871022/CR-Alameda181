package co.com.japl.interfaces.services

import co.com.japl.interfaces.dtos.CarouselDTO

interface CarouselHome {
    fun getCarouselHome():List<CarouselDTO>
}