package co.com.alameda181.unidadresidencialalameda181.module

import android.app.Application
import android.content.Context
import co.com.japl.alameda181.core.adapter.ports.inbound.CarouselPort
import co.com.japl.alameda181.core.usercase.Carousel
import co.com.japl.alameda181.core.usercase.interfaces.ICarousel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface Module {

        @Binds
    fun provideInboundICarouselByImpl(inboundCarouselPort:co.com.japl.alameda181.core.adapter.ports.inbound.CarouselPort):co.com.japl.alameda181.core.adapter.ports.inbound.interfaces.ICarousel

    @Binds
    fun provideUserCaseICarouselImpl(userCaseCarousel:Carousel):ICarousel



}