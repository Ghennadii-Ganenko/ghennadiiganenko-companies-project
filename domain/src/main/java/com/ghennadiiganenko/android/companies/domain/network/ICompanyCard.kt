package com.ghennadiiganenko.android.companies.domain.network

interface ICompanyCard {
    val description: String
    val id: String
    val img: String
    val lat: Double
    val lon: Double
    val name: String
    val phone: String
    val www: String
}