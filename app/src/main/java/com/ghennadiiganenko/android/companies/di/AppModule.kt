package com.ghennadiiganenko.android.companies.di

import com.ghennadiiganenko.android.companies.fragments.card.viewmodel.CardViewModel
import com.ghennadiiganenko.android.companies.fragments.list.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<ListViewModel> {
        ListViewModel(
            companyRepository = get(),
        )
    }

    viewModel<CardViewModel> {
        CardViewModel(
            companyCardRepository = get(),
        )
    }
}