    package ru.netology

    fun main() {
        val amount = 10_000
        val paymentSystem = "vkPay"
        val amountMonth = 0
        val amountDay = 0

        if (validateCommission(paymentSystem, amountMonth, amount, amountDay))
            println("Комиссия составит " + test(paymentSystem, amountMonth, amount))
    }

    fun validateCommission(paymentSystem: String, amountMonth: Int, amount: Int, amountDay: Int): Boolean {
        val result = if (paymentSystem == "vkPay")
            vkPaymentValidation(amountMonth, amount)
        else
            cardPaymentValidation(amountMonth, amountDay, amount)
        return result
    }

    fun test(paymentSystem: String, amountMonth: Int, amount: Int) = when (paymentSystem) {
        "Visa", "Mir" -> visaPay(amount)
        "Mastercard", "Maestro" -> masterPay(amountMonth, amount)
        else -> 0
    }

    fun visaPay(amount: Int): Double {
        val commission = (amount / 100) * 0.75
        val minCommission = 3500.0
        val result = if (commission < minCommission) minCommission
        else commission
        return result
    }

    fun masterPay(amountMonth: Int, amount: Int): Double {
        val result = if (amount + amountMonth < 75_000) 0.0
        else (amount + amountMonth - 75_000) / 100 * 0.6 + 20

        return result
    }

    fun vkPaymentValidation(amountMonth: Int, amount: Int): Boolean {
        val transferOne = 15_000
        val transferMonth = 40_000

        val result = if (amount > transferOne) println("Вы превысили лимит переводов за раз") else
            if (amountMonth > transferMonth) println("Вы превысили лимит переводов за месяц") else 0

        return result == 0
    }

    fun cardPaymentValidation(amountMonth: Int, amountDay: Int, amount: Int): Boolean {
        val transferDayMaxCard = 150_000
        val transferMonthMaxCard = 600_000

        val result = if (amount > transferDayMaxCard) println("Вы превысили лимит переводов за раз") else
            if (amountMonth > transferMonthMaxCard) println("Вы превысили лимит переводов за месяц") else 0

        return result == 0
    }
