package com.ghennadiiganenko.android.companies.di

import com.ghennadiiganenko.android.companies.data.repository.CompanyCardRepository
import com.ghennadiiganenko.android.companies.data.repository.CompanyRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        CompanyRepository()
    }

    single {
        CompanyCardRepository()
    }
}