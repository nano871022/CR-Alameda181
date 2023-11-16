package co.com.alameda181.unidadresidencialalameda181.module

import android.app.Application
import android.content.Context
import androidx.annotation.RequiresApi
import co.com.alameda181.unidadresidencialalameda181.Aplication
import co.com.alameda181.unidadresidencialalameda181.model.HomeScreen.HomeScreenModel
import co.com.japl.alameda181.core.adapter.ports.inbound.CarouselPort
import co.com.japl.alameda181.core.adapter.ports.inbound.interfaces.ICarousel
import co.com.japl.alameda181.core.usercase.Carousel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import java.util.Collections
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleProvides {

   @Singleton
   @Provides
   fun provideContext(application:Application):Context{
       return application as Context
   }

    @RequiresApi(34)
    @Provides
    fun provideViewModelHome(application:Application):HomeScreenModel{
        return HomeScreenModel(application)
    }





}