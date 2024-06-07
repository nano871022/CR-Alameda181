package co.com.japl.alameda181.core.adapter.ports.outbound

import android.util.Log
import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.com.japl.alameda181.core.BuildConfig
import co.com.japl.alameda181.core.R
import co.com.japl.alameda181.core.enums.RealtimeDBKeys
import co.com.japl.alameda181.core.model.Carousel
import co.com.japl.alameda181.core.model.Document
import java.io.File
import javax.inject.Inject

class GDrivePort @Inject constructor(private val getFilesFromFolderShared:GetFilesFromFolderShared, val realtimeSvc:Realtime) {
    private val FOLDER_ID = co.com.japl.connect.gdrive.BuildConfig.FOLDER_ID
    private val FOLDER_ID_DOC = co.com.japl.connect.gdrive.BuildConfig.FOLDER_ID_DOC

    suspend fun getFiles():List<Document>{
        var folder = FOLDER_ID_DOC
        realtimeSvc.connect(RealtimeDBKeys.FOLDER_DOCS.toString().lowercase()).collect{
            it?.let {
                folder = it
                Log.d("GDrivePort", "==Get Value  $it")
            }
        }
        val files =  getFilesFromFolderShared.execute(resId = co.com.japl.connect.gdrive.R.raw.cralameda181_34c486bb5b56, folder)
        return files?.takeIf { it.isNotEmpty() }?.map{
            Document(
                id=it.id,
                name = it.name,
                url = it.url,
                date = it.date,
                version = it.version,
                mimeType = it.mimeType,
                description = it.description
            )
        }?:emptyList()
    }

    suspend fun getImg():List<Carousel>{
        var folder = FOLDER_ID
        realtimeSvc.connect(RealtimeDBKeys.FOLDER_IMG.toString().lowercase()).collect{
            it?.let {
                folder = it
                Log.d("GDrivePort", "==Get Value  $it")
            }
        }
        val files =  getFilesFromFolderShared.execute(resId = co.com.japl.connect.gdrive.R.raw.cralameda181_34c486bb5b56, folder)
        var id = 0
        return files?.takeIf { it.isNotEmpty() }?.map{
            Carousel(
                id=id++,
                name = it.name,
                url = it.url,
                description = it.description?:it.name,
                active = true,
                drawable = -1,
                order = id
            )
        }?:emptyList()
    }

    fun downloadFile(idFile:String): File?{
        return getFilesFromFolderShared.downloadFile(idFile, co.com.japl.connect.gdrive.R.raw.cralameda181_34c486bb5b56)

    }

}