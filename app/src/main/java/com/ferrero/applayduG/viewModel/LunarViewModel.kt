package com.ferrero.applayduG.viewModel
import androidx.lifecycle.*
import com.ferrero.applayduG.data.CountryJs
import com.ferrero.applayduG.data.GeoDev
import com.ferrero.applayduG.db.Dao
import com.ferrero.applayduG.entities.AppsEntity
import com.ferrero.applayduG.repository.Repository
import kotlinx.coroutines.launch

class LunarViewModel(val dao: Dao) : ViewModel() {

    val countryCodeJS : MutableLiveData<CountryJs> = MutableLiveData()
    val geoDev : MutableLiveData<GeoDev> = MutableLiveData()


    fun getData(){
        viewModelScope.launch {
            countryCodeJS.value = Repository.getData()

        }
    }

    fun getDataDev(){
        viewModelScope.launch {
            geoDev.value = Repository.getDataDev()

        }
    }



    fun insertApps(appsEntity: AppsEntity){
        viewModelScope.launch {
            dao.insertData(appsEntity)
        }

    }




}