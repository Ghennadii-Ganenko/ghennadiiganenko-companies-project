package com.ghennadiiganenko.android.companies.domain.mapper

import com.ghennadiiganenko.android.companies.domain.models.CompanyEntity
import com.ghennadiiganenko.android.companies.domain.network.ICompany

class CompanyMapper : IMapper<List<ICompany>, List<CompanyEntity>> {

    override fun map(input: List<ICompany>): List<CompanyEntity> = input.map { mapSingle(it) }

    private fun mapSingle(input: ICompany): CompanyEntity = CompanyEntity(
        id = input.id,
        img = input.img,
        name = input.name,
    )
}