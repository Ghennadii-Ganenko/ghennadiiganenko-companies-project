package com.ghennadiiganenko.android.companies.data.common

import com.ghennadiiganenko.android.companies.data.client.RetrofitClient
import com.ghennadiiganenko.android.companies.data.interfaces.IRetrofitService

object Common {
    const val BASE_URL = "https://lifehack.studio/test_task/"
    val retrofitService: IRetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(IRetrofitService::class.java)
}