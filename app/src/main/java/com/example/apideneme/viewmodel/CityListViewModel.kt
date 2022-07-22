package com.example.apideneme.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apideneme.model.CityResponse
import com.example.apideneme.service.CityAPIServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CityListViewModel : ViewModel() {

    val cities = MutableLiveData<CityResponse>()
    val cityErrorMessage = MutableLiveData<Boolean>()
    val cityLoading = MutableLiveData<Boolean>()

    private val cityApiServis = CityAPIServis()
    private val disposable = CompositeDisposable()

    fun refreshData () {
        getDataFromInternet()

    }

    private fun getDataFromInternet(){
        cityLoading.value = true

       disposable.add(
           cityApiServis.getData()
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(object : DisposableSingleObserver<CityResponse>() {
                   override fun onSuccess(t: CityResponse) {
                       //Başarılı olursa
                       cities.value = t
                       cityErrorMessage.value = false
                       cityLoading.value = false
                   }

                   override fun onError(e: Throwable) {
                       //Hata Verirse
                       cityErrorMessage.value = true
                       cityLoading.value = false
                       e.printStackTrace()


                   }


               }

               )
       )


    }
}