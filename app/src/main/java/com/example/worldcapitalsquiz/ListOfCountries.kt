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
            ),
            CountriesData(
                country = "Angola",
                capital = "Luanda",
                flagId = R.drawable.angola,
                hint = "It is the second-largest Portuguese-speaking country in both total area and population, and is the seventh-largest country in Africa."
            ),
            CountriesData(
                country = "Antigua and Barbuda",
                capital = "Saint John's",
                flagId = R.drawable.antiguaandbarbuda,
                hint = "It is a sovereign island country in the West Indies in the Americas, lying between the Caribbean Sea and the Atlantic Ocean."
            ),
            CountriesData(
                country = "Argentina",
                capital = "Buenos Aires",
                flagId = R.drawable.argentina,
                hint = "It is the largest Spanish-speaking nation in the world by area."
            ),
            CountriesData(
                country = "Armenia",
                capital = "Erevan",
                flagId = R.drawable.armenia,
                hint = "It is a part of the Caucasus region."
            ),
            CountriesData(
                country = "Australia",
                capital = "Canberra",
                flagId = R.drawable.australia,
                hint = "It is the largest country by area in Oceania and the world's sixth-largest country."
            ),
            CountriesData(
                country = "Austria",
                capital = "Vienna",
                flagId = R.drawable.austria,
                hint = "It is a landlocked country in the southern part of Central Europe, situated at Eastern Alps."
            ),
            CountriesData(
                country = "Azerbaijan",
                capital = "Baku",
                flagId = R.drawable.azerbaijan,
                hint = "It is a transcontinental country located at the boundary of Eastern Europe and Western Asia."
            )
        )
    }
}