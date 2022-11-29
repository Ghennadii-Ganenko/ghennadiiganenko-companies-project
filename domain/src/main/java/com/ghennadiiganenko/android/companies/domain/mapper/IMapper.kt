package com.ghennadiiganenko.android.companies.domain.mapper

interface IMapper<I, O> {
    fun map(input: I): O
}