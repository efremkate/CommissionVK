package ru.netology

fun main() {
        val amount = 1000000
        println("Комиссия составит " + result)
    }

    fun test(paymentSystem: String, amontMonth: double, amount: double) = when(paymentSystem){
        if (paymentSystem == "vkPay")
            vpP(amontMonth, amount) rerurn 0
            if (paymentSystem == "Visa", "Mir")
        visaPay(amontMonth, amount)
            if (paymentSystem == "Master")
        masterPay (amontMonth, amount)
    }

    fun visaPay (amount): double {
        val commission = (amount / 100) * 0.75
        val minCommission = 3500.0
        val result = if (commission < minCommission) minCommission else commission
        return result
    }
}