package com.ghennadiiganenko.android.companies.data.interfaces

import com.ghennadiiganenko.android.companies.data.CompanyCardData
import com.ghennadiiganenko.android.companies.data.CompanyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitService {
    @GET("test.php")
    fun getCompanies(): Call<List<CompanyData>>

    @GET("test.php")
    fun getCompanyCard(@Query("id") id: String): Call<List<CompanyCardData>>
}