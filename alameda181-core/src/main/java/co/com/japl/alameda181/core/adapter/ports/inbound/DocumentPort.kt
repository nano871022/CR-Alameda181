package co.com.japl.alameda181.core.adapter.ports.inbound

import co.com.japl.alameda181.core.model.Document
import co.com.japl.alameda181.core.usercase.interfaces.IDocument
import java.io.File
import javax.inject.Inject

class DocumentPort @Inject constructor(private val gdriveSvc: IDocument) {

    suspend fun getDocuments(): List<Document> {
        return gdriveSvc.getFiles()
    }

    fun getFile(idFile: String): File?{
        return gdriveSvc.getFile(idFile)
    }

}