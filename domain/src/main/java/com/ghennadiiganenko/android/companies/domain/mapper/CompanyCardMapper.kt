package com.ghennadiiganenko.android.companies.domain.mapper

import com.ghennadiiganenko.android.companies.domain.models.CompanyCardEntity
import com.ghennadiiganenko.android.companies.domain.network.ICompanyCard

class CompanyCardMapper : IMapper<List<ICompanyCard>, CompanyCardEntity> {

    override fun map(input: List<ICompanyCard>): CompanyCardEntity = input.map { mapSingle(it) }.first()

    private fun mapSingle(input: ICompanyCard): CompanyCardEntity = CompanyCardEntity(
        description = input.description,
        id = input.id,
        img = input.img,
        lat = input.lat,
        lon = input.lon,
        name = input.name,
        phone = input.phone,
        www = input.www,
    )
}