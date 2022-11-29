package com.ghennadiiganenko.android.companies.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ghennadiiganenko.android.companies.data.CompanyData
import com.ghennadiiganenko.android.companies.data.common.Common
import com.ghennadiiganenko.android.companies.data.interfaces.IRetrofitService
import com.ghennadiiganenko.android.companies.domain.mapper.CompanyMapper
import com.ghennadiiganenko.android.companies.domain.models.CompanyEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyRepository {
    private lateinit var mService: IRetrofitService
    val companiesList = MutableLiveData<List<CompanyEntity>>()

    fun getCompaniesList() {
        mService = Common.retrofitService
        val companyMapper = CompanyMapper()
        mService.getCompanies().enqueue(object : Callback<List<CompanyData>> {
            override fun onFailure(call: Call<List<CompanyData>>, t: Throwable) {
                Log.e("IsFailResponse", t.message.toString())
            }

            override fun onResponse(call: Call<List<CompanyData>>, response: Response<List<CompanyData>>) {
                if (response.isSuccessful) {
                    companiesList.postValue(response.body()?.let { companyMapper.map(it) })
                } else {
                    Log.e("Critical", response.toString())
                }
            }
        })
    }
}