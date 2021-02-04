package com.example.homework1

val factorial: (Long) -> Long = { (2..it).fold( 1, Long::times)}


fun main(){
    println(factorial(5))
}