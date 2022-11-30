package com.ghennadiiganenko.android.companies.fragments.card.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.companies.data.repository.CompanyCardRepository
import com.ghennadiiganenko.android.companies.domain.models.CompanyCardEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel(
    private val companyCardRepository: CompanyCardRepository
) : ViewModel() {

    val companyCard: MutableLiveData<CompanyCardEntity> = companyCardRepository.companyCard

    fun getCompanyCard(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            companyCardRepository.getCompanyCard(id)
        }
    }
}