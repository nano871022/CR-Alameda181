package co.com.alameda181.unidadresidencialalameda181.adapter.port

import android.app.Application
import android.content.Context
import android.util.Log
import co.com.japl.interfaces.dtos.CarouselDTO
import co.com.japl.interfaces.services.ICarouselHome
import co.com.japl.services.implement.CarouselImpl
import co.com.japl.services.implement.CarouselLocalImpl
import java.util.Collections
import javax.inject.Inject

class CarouselPort @Inject constructor (context: Context) {

    lateinit var carouselHome:ICarouselHome
    lateinit var carouselHomeLocal:ICarouselHome
    init{
        carouselHome = CarouselImpl(context)
        carouselHomeLocal = CarouselLocalImpl(context)
    }
    fun getCarousel():List<CarouselDTO>{
        try {
            val list = carouselHome.getCarouselHome().toMutableList()
            list.addAll(carouselHomeLocal.getCarouselHome())
            return list
        }catch(e:Exception){
            Log.e("CarouselPort#getCarousel",e.message.toString())
        }
        return Collections.emptyList()
    }

}