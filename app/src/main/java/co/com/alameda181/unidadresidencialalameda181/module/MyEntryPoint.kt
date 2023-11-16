package co.com.alameda181.unidadresidencialalameda181.module

import co.com.japl.alameda181.core.adapter.ports.inbound.CarouselPort
import co.com.japl.alameda181.core.usercase.Carousel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MyEntryPoint {

    fun carouselPort():CarouselPort
}