package com.fernando.pdfviewerapp.components

import android.net.Uri
import android.os.Environment
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.fernando.pdfviewerapp.MainRepository
import com.github.barteksc.pdfviewer.PDFView
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URLDecoder
import java.net.URLEncoder

object PdfViewBinding {
    @JvmStatic
    @BindingAdapter("app:setPdfUrl")
    fun setPdfUrl(pdfView: PDFView, pdfUrl: MainRepository.FileDownloaded?) {
        if (pdfUrl != null) {
            pdfView.fromStream(pdfUrl.streamByte).load()
        }
    }
}

fun String.decode(): String? {
    return URLDecoder.decode(this, "UTF-8")
}

fun String.encode(): String? {
    return URLEncoder.encode(this, "UTF-8")
}
