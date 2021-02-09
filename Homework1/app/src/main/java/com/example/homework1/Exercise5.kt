package com.example.homework1

data class HeartRateEntry(val date: Long, val value: Int)

fun populateData(vararg dataPair: Pair<Long, Int>): List<HeartRateEntry> =
    dataPair.map { HeartRateEntry(it.first, it.second) }

val data = populateData(
    1612310400L to 76,
    1612310400L to 89,
    1612310400L to 44,
    1612224000L to 47,
    1612224000L to 115,
    1612224000L to 76,
    1612224000L to 87,
    1612137600L to 90,
    1612137600L to 167)

fun main(){
    val minimHeartRate = data.minByOrNull { it.value }?.value
    println("Minimum heart rate is $minimHeartRate")

    val averageHeartRate = data.map {it.value}.average()
    println("Average heart rate is ${String.format("%.2f", averageHeartRate)}")

    val valuesGreaterThan100 = data.filter { it.value > 100 }.map { it.value }
    println("Heart Rate values greater than 100 are:")
    valuesGreaterThan100.forEach(::println)

    val valuesGroupedByDate = data.groupBy { it.date }
    println("Heart rate values grouped by dates:")
    valuesGroupedByDate.forEach(::println)

    val maxValuesForDate = valuesGroupedByDate.map { it.value.maxByOrNull { p -> p.value } }
    println("Maximum heart rate per each date:")
    maxValuesForDate.forEach(::println)
}