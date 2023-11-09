package co.com.japl.services.implement

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import co.com.japl.interfaces.dtos.CarouselDTO
import co.com.japl.interfaces.services.CarouselHome
import co.com.japl.model.R
import java.net.URL
import java.util.Collections

class CarouselImpl(val context:Context) : CarouselHome{
    override fun getCarouselHome(): List<CarouselDTO> {

        Service {
            Log.d("getImagesformurl","$it")
        }.execute(context.resources.getString(R.string.url_carousel))
        return Collections.emptyList()
    }
}

class Service(val response:(String?)->Unit): AsyncTask<String, Void, String>(){
    override fun onPostExecute(result: String?) {
        response(result)
    }

    override fun doInBackground(vararg p0: String?): String {
        return URL(p0[0]).readText()
    }
}