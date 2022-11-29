package com.ghennadiiganenko.android.companies.data.interfaces

import com.ghennadiiganenko.android.companies.data.CompanyData
import retrofit2.Call
import retrofit2.http.GET

interface IRetrofitService {
    @GET("test.php")
    fun getCompanies(): Call<List<CompanyData>>
}