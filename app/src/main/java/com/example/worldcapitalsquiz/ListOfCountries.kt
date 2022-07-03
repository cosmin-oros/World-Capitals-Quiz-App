package com.example.worldcapitalsquiz

object ListOfCountries {
    fun getData(): ArrayList<CountriesData>{
        return arrayListOf(
            CountriesData(
                country = "Afghanistan",
                capital = "Kabul",
                flagId = R.drawable.afghanistan,
                hint = "A landlocked country located at the crossroads of Central and South Asia"
            ),
            CountriesData(
                country = "Albania",
                capital = "Tirana",
                flagId = R.drawable.albania,
                hint = "The country has been inhabited by different civilisations over time, such as the Illyrians, Thracians, Greeks, Romans, Byzantines, Venetians, and Ottomans."
            ),
            CountriesData(
                country = "Algeria",
                capital = "Alger",
                flagId = R.drawable.algeria,
                hint = "It is considered to be a part of the Maghreb region of North Africa."
            ),
            CountriesData(
                country = "Andorra",
                capital = "Andorra la Vella",
                flagId = R.drawable.andorra,
                hint = "The official language is Catalan, but Spanish, Portuguese, and French are also commonly spoken."
            )
        )
    }
}