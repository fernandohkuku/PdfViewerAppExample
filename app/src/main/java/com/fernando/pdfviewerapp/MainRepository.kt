package com.fernando.pdfviewerapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.InputStream

class MainRepository {

    private val service = MainService.buildRetrofit()

    suspend fun downLoadPdf(pdfUrl: String): FileDownloaded {
        val file = withContext(Dispatchers.IO){
            service.downLoadFile(pdfUrl).toFileDownLoaded()
        }
        return file
    }


    data class FileDownloaded(
        val streamByte: InputStream,
        val contentLength: Long
    )

    private fun Response<ResponseBody>.toFileDownLoaded() = FileDownloaded(
        streamByte = body()?.byteStream()!!,
        contentLength = body()?.contentLength()!!
    )
}