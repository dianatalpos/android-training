package com.example.homework1

import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random

fun main(){

    println("Hello! This program interprets random generated pairs of systolic and diastolic blood pressure")

    val reader = Scanner(System.`in`)

    do {
        var bloodPressure =
            BloodPressure(Random.nextInt(300).absoluteValue, Random.nextInt(300).absoluteValue)

        bloodPressure.makeInterpretation()

        println("Write exit  for quiting the program")
        val response = reader.next()
    } while (response != "exit")
}

data class BloodPressure(
    val systolicValue: Int,
    val diastolicValue: Int
){

    fun makeInterpretation(){
        println("Systolic value: $systolicValue,  Diastolic value: $diastolicValue")
        println( when{
            systolicValue < 120 && diastolicValue < 80 -> "Normal"
            systolicValue in 120..129 && diastolicValue < 80 -> "Elevated"
            systolicValue in 130..139 || diastolicValue in 80..89 ->"High Blood Pressure(STAGE 1): HYPERTENSION"
            systolicValue > 180 || diastolicValue > 120 -> "Hypertensive crisis: consult your doctor immediately"
            systolicValue > 140 || diastolicValue > 90 -> "High Blood Pressure(STAGE 2): HYPERTENSION"
            else -> "Invalid values"
        })
    }
}