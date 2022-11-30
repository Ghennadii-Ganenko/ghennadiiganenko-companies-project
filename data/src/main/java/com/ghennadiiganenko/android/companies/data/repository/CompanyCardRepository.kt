package com.ghennadiiganenko.android.companies.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ghennadiiganenko.android.companies.data.CompanyCardData
import com.ghennadiiganenko.android.companies.data.common.Common
import com.ghennadiiganenko.android.companies.data.interfaces.IRetrofitService
import com.ghennadiiganenko.android.companies.domain.mapper.CompanyCardMapper
import com.ghennadiiganenko.android.companies.domain.models.CompanyCardEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyCardRepository {
    private lateinit var mService: IRetrofitService
    val companyCard = MutableLiveData<CompanyCardEntity>()

    fun getCompanyCard(id: String) {
        mService = Common.retrofitService
        val companyCardMapper = CompanyCardMapper()
        mService.getCompanyCard(id).enqueue(object : Callback<List<CompanyCardData>> {
            override fun onFailure(call: Call<List<CompanyCardData>>, t: Throwable) {
                Log.e("IsFailResponse", t.message.toString())
            }

            override fun onResponse(call: Call<List<CompanyCardData>>, response: Response<List<CompanyCardData>>) {
                if (response.isSuccessful) {
                    companyCard.postValue(response.body()?.let { companyCardMapper.map(it) })
                } else {
                    Log.e("Critical", response.toString())
                }
            }
        })
    }
}