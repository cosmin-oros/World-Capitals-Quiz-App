package com.example.worldcapitalsquiz

object ListOfCountries {
    fun getData(): ArrayList<CountriesData>{
        return arrayListOf(
            CountriesData(
                country = "Afghanistan",
                capital = "Kabul",
                flagId = R.drawable.afghanistan,
                hint = "A landlocked country located at the crossroads of Central and South Asia",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Albania",
                capital = "Tirana",
                flagId = R.drawable.albania,
                hint = "The country has been inhabited by different civilisations over time, such as the Illyrians, Thracians, Greeks, Romans, Byzantines, Venetians, and Ottomans.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Algeria",
                capital = "Alger",
                flagId = R.drawable.algeria,
                hint = "It is considered to be a part of the Maghreb region of North Africa.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Andorra",
                capital = "Andorra la Vella",
                flagId = R.drawable.andorra,
                hint = "The official language is Catalan, but Spanish, Portuguese, and French are also commonly spoken.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Angola",
                capital = "Luanda",
                flagId = R.drawable.angola,
                hint = "It is the second-largest Portuguese-speaking country in both total area and population, and is the seventh-largest country in Africa.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Antigua and Barbuda",
                capital = "Saint John's",
                flagId = R.drawable.antiguaandbarbuda,
                hint = "It is a sovereign island country in the West Indies in the Americas, lying between the Caribbean Sea and the Atlantic Ocean.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Argentina",
                capital = "Buenos Aires",
                flagId = R.drawable.argentina,
                hint = "It is the largest Spanish-speaking nation in the world by area.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Armenia",
                capital = "Erevan",
                flagId = R.drawable.armenia,
                hint = "It is a part of the Caucasus region.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Australia",
                capital = "Canberra",
                flagId = R.drawable.australia,
                hint = "It is the largest country by area in Oceania and the world's sixth-largest country.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Austria",
                capital = "Vienna",
                flagId = R.drawable.austria,
                hint = "It is a landlocked country in the southern part of Central Europe, situated at Eastern Alps.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Azerbaijan",
                capital = "Baku",
                flagId = R.drawable.azerbaijan,
                hint = "It is a transcontinental country located at the boundary of Eastern Europe and Western Asia.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Bahamas",
                capital = "Nassau",
                flagId = R.drawable.bahamas,
                hint = "It is a country within the Lucayan Archipelago of the West Indies in the Atlantic.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Bahrain",
                capital = "Manama",
                flagId = R.drawable.bahrain,
                hint = "It is an island country in Western Asia.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Bangladesh",
                capital = "Dacca",
                flagId = R.drawable.bangladesh,
                hint = "It forms the sovereign part of the historic and ethnolinguistic region of Bengal.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Barbados",
                capital = "Bridgetown",
                flagId = R.drawable.barbados,
                hint = "It is an island country in the Lesser Antilles of the West Indies, in the Caribbean region of the Americas.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Belarus",
                capital = "Minsk",
                flagId = R.drawable.belarus,
                hint = "During the dissolution of the Soviet Union, they declared independence on 25 August 1991.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Belgium",
                capital = "Brussels",
                flagId = R.drawable.belgium,
                hint = "It is home to two main linguistic communities: the Dutch-speaking Flemish Community and the French-speaking Community",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Belize",
                capital = "Belmopan",
                flagId = R.drawable.belize,
                hint = "It is a country on the northeastern coast of Central America.",
                order = (1..193).random()
            ),
            CountriesData(
                country = "Benin",
                capital = "Porto Novo",
                flagId = R.drawable.benin,
                hint = "The majority of its population lives on the small southern coastline",
                order = (1..193).random()
            )
        )
    }
}