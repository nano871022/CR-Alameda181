package co.com.japl.alameda181.core.usercase.interfaces

import co.com.japl.alameda181.core.model.Document
import java.io.File

interface IDocument {

    suspend fun getFiles():List<Document>

    fun getFile(idFile:String):File?
}