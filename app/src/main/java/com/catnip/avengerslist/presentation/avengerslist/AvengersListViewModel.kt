package com.catnip.avengerslist.presentation.avengerslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.avengerslist.data.datasource.AvengersDataSource
import com.catnip.avengerslist.data.datasource.AvengersDataSourceImpl

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AvengersListViewModel : ViewModel() {
    private val dataSource: AvengersDataSource by lazy { AvengersDataSourceImpl() }

    private val _isUsingGridMode = MutableLiveData(false)
    val isUsingGridMode: LiveData<Boolean>
        get() = _isUsingGridMode

    fun changeListMode() {
        val currentValue = _isUsingGridMode.value ?: false
        _isUsingGridMode.postValue(!currentValue)
    }

    fun getAvengersList() = dataSource.getAvengerMembers()
}