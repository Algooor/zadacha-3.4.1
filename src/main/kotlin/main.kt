package ru.netology

const val MAX_LIMIT_WITHOUT_COMMISSION = 7500000
const val MIN_COMMISSION = 35_00
const val COMMISSION_MASTERCARD_MAESTRO = 0.006
const val FIX_PAY_MASTERCARD_MAESTRO = 2000
var SUM_OF_PREVIOUS_TRANSFERS = 0

enum class PaymentSystems {
    Mastercard, Maestro, Visa, Mir, VKPay
}

fun main() {
    while (true) {
        print("Введите сумму перевода или 0 чтобы закончить: ")
        val amount = readLine()?.toInt() ?: return
        if (0 == amount) {
            break
        }
        val result = calculate(
            amount,
            (amount * 0.0075).toInt(),
            paymentSystems = PaymentSystems.VKPay
        )
        SUM_OF_PREVIOUS_TRANSFERS += amount
        println("Сумма совершаемого перевода: $amount Комисcия: $result копеек")
    }
    println("Сумма предыдущих переводов в этом месяце: $SUM_OF_PREVIOUS_TRANSFERS копеек")
}

fun calculate(
    amount: Int,
    commissionVisaMir: Int,
    paymentSystems: PaymentSystems = PaymentSystems.VKPay
) = when (paymentSystems) {
    PaymentSystems.Mastercard -> if (amount > MAX_LIMIT_WITHOUT_COMMISSION) (amount * COMMISSION_MASTERCARD_MAESTRO + FIX_PAY_MASTERCARD_MAESTRO).toInt() else 0
    PaymentSystems.Maestro -> if (amount > MAX_LIMIT_WITHOUT_COMMISSION) (amount * COMMISSION_MASTERCARD_MAESTRO + FIX_PAY_MASTERCARD_MAESTRO).toInt() else 0
    PaymentSystems.Visa -> if (commissionVisaMir < MIN_COMMISSION) MIN_COMMISSION else commissionVisaMir
    PaymentSystems.Mir -> if (commissionVisaMir < MIN_COMMISSION) MIN_COMMISSION else commissionVisaMir
    PaymentSystems.VKPay -> 0
}