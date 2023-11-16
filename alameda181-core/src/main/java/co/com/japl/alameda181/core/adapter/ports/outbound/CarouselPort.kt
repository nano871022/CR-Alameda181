package co.com.japl.alameda181.core.adapter.ports.outbound

import android.content.Context
import android.util.Log
import androidx.annotation.RequiresApi
import co.com.japl.interfaces.dtos.CarouselDTO
import co.com.japl.interfaces.services.ICarouselHome
import co.com.japl.services.implement.CarouselDriveImpl
import co.com.japl.services.implement.CarouselImpl
import co.com.japl.services.implement.CarouselLocalImpl
import java.util.Collections
import javax.inject.Inject

@RequiresApi(34)
class CarouselPort @Inject constructor (var context: Context) {

    lateinit var carouselHome:ICarouselHome
    lateinit var carouselHomeLocal:ICarouselHome
    lateinit var carouselHomeDrive:ICarouselHome
   private fun init(){
        carouselHome = CarouselImpl(context!!)
        carouselHomeLocal = CarouselLocalImpl(context!!)
        carouselHomeDrive = CarouselDriveImpl(context!!)
    }
    fun getCarousel():List<CarouselDTO>{
        try {
            init()
            val list = carouselHomeDrive.getCarouselHome().toMutableList()
            list.addAll(carouselHome.getCarouselHome())
            list.addAll(carouselHomeLocal.getCarouselHome())
            return list
        } catch (e: Exception) {
            Log.e("CarouselPort#getCarousel",e.message.toString())
        }
        return Collections.emptyList()
    }

}