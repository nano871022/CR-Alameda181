package co.com.japl.alameda181.core.usercase

import co.com.japl.alameda181.core.adapter.ports.outbound.GDrivePort
import co.com.japl.alameda181.core.model.Document
import co.com.japl.alameda181.core.usercase.interfaces.IDocument
import java.io.File
import javax.inject.Inject

class DocumentImpl @Inject constructor(private val gDrivePort: GDrivePort) : IDocument {
    override suspend fun getFiles(): List<Document> {
        return gDrivePort.getFiles().sortedByDescending { it.date }
    }

    override fun getFile(idFile: String): File? {
        return gDrivePort.downloadFile(idFile)
    }

}