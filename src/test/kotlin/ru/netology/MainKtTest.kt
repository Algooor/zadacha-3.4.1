package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main(){
    }

    @Test
    fun calculateTest_Mir() {
        // arrange
        val amount = 10000
        val commissionVisaMir = 75
        val paymentSystems = PaymentSystems.Mir
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
            paymentSystems = paymentSystems
        )
        // assert
        assertEquals(3500, result)
    }
    @Test
    fun calculateTest_Visa() {
        // arrange
        val amount = 10000
        val commissionVisaMir = 75
        val paymentSystems = PaymentSystems.Visa
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
            paymentSystems = paymentSystems
        )
        // assert
        assertEquals(3500, result)
    }

    @Test
    fun calculateTest_Without_A_Card() {
        // arrange
        val amount = 10000
        val commissionVisaMir = 75
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
        )
        // assert
        assertEquals(0, result)
    }


    @Test
    fun calculateTest_Maestro() {
        // arrange
        val amount = 7600000
        val commissionVisaMir = 0
        val paymentSystems = PaymentSystems.Maestro
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
            paymentSystems = paymentSystems
        )
        // assert
        assertEquals(47600, result)
    }
    @Test
    fun calculateTest_Mastercard() {
        // arrange
        val amount = 7600000
        val commissionVisaMir = 0
        val paymentSystems = PaymentSystems.Mastercard
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
            paymentSystems = paymentSystems
        )
        // assert
        assertEquals(47600, result)
    }
    @Test
    fun calculateTest_VK_pay() {
        // arrange
        val amount = 10000
        val commissionVisaMir = 0
        val paymentSystems = PaymentSystems.VKPay
        // act
        val result = calculate(
            amount = amount,
            commissionVisaMir = commissionVisaMir,
            paymentSystems = paymentSystems
        )
        // assert
        assertEquals(0, result)
    }

}