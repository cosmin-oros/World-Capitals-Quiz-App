package com.example.worldcapitalsquiz

object ListOfCountries {
    fun getData(): ArrayList<CountriesData>{
        return arrayListOf(
            CountriesData(
                country = "Afghanistan",
                capital = "Kabul",
                flagId = R.drawable.afghanistan
            ),
            CountriesData(
                country = "Albania",
                capital = "Tirana",
                flagId = R.drawable.albania
            ),
            CountriesData(
                country = "Algeria",
                capital = "Alger",
                flagId = R.drawable.algeria
            )
        )
    }
}