package com.fernando.pdfviewerapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernando.pdfviewerapp.components.decode
import com.fernando.pdfviewerapp.components.encode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    private val mLiveFileDownloaded = MutableLiveData<MainRepository.FileDownloaded>()
    val liveFileDownloaded get() = mLiveFileDownloaded

    init {
        onGetPdfUrl("https://ctep.cancer.gov/protocoldevelopment/electronic_applications/docs/ctcaev3.pdf")
    }

    private fun onGetPdfUrl(pdfUrl:String) = viewModelScope.launch(Main){
        val result = repository.downLoadPdf(pdfUrl)
        mLiveFileDownloaded.setValue(result)
    }

}