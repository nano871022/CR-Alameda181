package co.com.japl.alameda181.core.adapter.ports.inbound.interfaces

import co.com.japl.alameda181.core.model.Carousel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent



interface ICarousel {

    suspend fun getList():List<Carousel>
}