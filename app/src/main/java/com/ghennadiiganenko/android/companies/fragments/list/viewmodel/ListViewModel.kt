package com.ghennadiiganenko.android.companies.fragments.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.companies.data.repository.CompanyRepository
import com.ghennadiiganenko.android.companies.domain.models.CompanyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val companyRepository: CompanyRepository
) : ViewModel() {

    val companyList: MutableLiveData<List<CompanyEntity>> = companyRepository.companiesList

    fun getCompaniesList() {
        viewModelScope.launch(Dispatchers.IO) {
            companyRepository.getCompaniesList()
        }
    }
}