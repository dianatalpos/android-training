package com.example.homework1


object BankPercentage{
    const val value = 0.05
}

abstract class Card(var balance: Double, val name: String){
    abstract fun pay(amount : Double)
    abstract fun withdraw(amount : Double)
    fun deposit(amount : Int) {
        balance += amount
    }

}

class DebitCard(balance: Double, name: String) : Card(balance, name){
    override fun pay(amount: Double) {
        if(balance - amount < 0){
            println("FAILURE! You don't have enough money.")
            return
        }
        balance -= amount
        println("SUCCESS")
    }

    override fun withdraw(amount: Double) {
        pay(amount)
    }
}

class CreditCard (balance: Double, name: String, val limit: Double) : Card(balance, name){
    override fun pay(amount: Double) {
        withdraw(amount)
        balance += BankPercentage.value * amount
    }

    override fun withdraw(amount: Double) {
        if(amount > limit){
            println("FAILURE! The amount is too big.")
            return
        }
        balance -= amount
        println("SUCCESS")
    }
}