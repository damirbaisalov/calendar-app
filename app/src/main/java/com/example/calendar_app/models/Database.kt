package com.example.calendar_app.models

object Database {

    //DATABASE FOR LIST OF Days
    val dayDatabase : MutableList<DayData> = mutableListOf()

    init {

        val dayDataId = arrayListOf<String>()
        val dayDataDate = arrayListOf<String>()
        val dayDataDescription = arrayListOf<String>()

        dayDataId.add("1")
        dayDataDate.add("4 1")
        dayDataDescription.add("4 қаңтар - Исаак Ньютонның дүниеге келуі (1643-1727), ағылшын физигі, математик, астроном")

        dayDataId.add("2")
        dayDataDate.add("6 1")
        dayDataDescription.add("6 қаңтарда - 1938 жылы Морристаун қаласында (Нью-Джерси) Спидуэллдің шойын құю зауытының шеберханаларында Сэмюэл МОРЗЕ Альфред ВАЙЛМЕН бірге өзінің телеграф аппаратын алғаш рет көрсетті.")

        dayDataId.add("3")
        dayDataDate.add("12 1")
        dayDataDescription.add("12 қаңтар физик Игорь Васильевич Курчатовтың туған күні (1903-1960)")

        dayDataId.add("4")
        dayDataDate.add("10 1")
        dayDataDescription.add("10 қаңтарда - 1863 жылы  Лондонда бірінші метро желісі (метро) ашылды.")

        dayDataId.add("5")
        dayDataDate.add("13 1")
        dayDataDescription.add("13 қаңтарда- 1958 жылы көрнекті американдық ғалым Лайнус ПОЛИНГ БҰҰ-ға ядролық сынақтарға тыйым салуды талап етіп, 43 елдің 9000 ғалымы қол қойған петицияны тапсырды ")

        dayDataId.add("6")
        dayDataDate.add("16 1")
        dayDataDescription.add("16 қаңтар-  1963 жылы  Қаңтарда Никита Сергеевич ХРУЩЕВ КСРО-да 100 мегатонды сутегі бомбасы бар екенін жариялады.")

        dayDataId.add("7")
        dayDataDate.add("18 1")
        dayDataDescription.add("18 қаңтарда Лев Петрович ПИТАЕВСКИЙ дүниеге келді (1933), теориялық физик")

        dayDataId.add("8")
        dayDataDate.add("20 1")
        dayDataDescription.add("20 қаңтарда - 1958 жылы  Лондонда жолдардағы жылдамдықты бұзушыларды анықтау үшін радарлары бар алғашқы полиция қызметкерлері пайда болды.")

        dayDataId.add("9")
        dayDataDate.add("22 1")
        dayDataDescription.add("22 қаңтар физик Лев Давидович Ландаудың туған күні  (1908-1968)")

        dayDataId.add("10")
        dayDataDate.add("23 1")
        dayDataDescription.add("23 қаңтар - 1963Новосібірде Новосібір мемлекеттік университеті жанындағы еліміздегі алғашқы физика-математика мектеп-интернаты ашылды.")


        for (i in 0 until dayDataId.size){

            val dayData =  DayData(
                id = dayDataId[i],
                date = dayDataDate[i],
                description = dayDataDescription[i]
            )

            dayDatabase.add(dayData)
        }
    }
}