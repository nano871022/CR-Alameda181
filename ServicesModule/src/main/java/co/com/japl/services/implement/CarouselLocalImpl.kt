package co.com.japl.services.implement

import android.content.Context
import co.com.japl.interfaces.dtos.CarouselDTO
import co.com.japl.interfaces.services.ICarouselHome
import co.com.japl.model.R

class CarouselLocalImpl (val context:Context): ICarouselHome {
    override fun getCarouselHome(): List<CarouselDTO> {
        val resources = context.resources
        return R.drawable::class.java.fields.filter { it.name.startsWith("carousel") }
            .map{
                CarouselDTO( drawable=resources.getIdentifier(it.name,"drawable",context.packageName),
                    name=it.name,
                    id=it.name.replace("carousel","").toInt(),
                    url="",
                    order=it.name.replace("carousel","").toInt(),
                    active=true
                )
            }.sortedBy { value->value.order }
    }
}