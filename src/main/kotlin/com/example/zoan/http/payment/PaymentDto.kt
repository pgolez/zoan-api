package com.example.zoan.http.payment

import com.example.zoan.domain.payment.Payment
import com.example.zoan.domain.payment.PaymentAllotment
import com.example.zoan.http.loan.PaymentScheduleDto

class PaymentDto(payment: Payment) {
    val id = payment.id
    val payer = payment.payer
    val amount = payment.amount
    val transactionDate = payment.transactionDate
    val allotments = payment.allotments.map { PaymentAllotmentDto(it) }

    class PaymentAllotmentDto(allotment: PaymentAllotment) {
        val schedule = PaymentScheduleDto(allotment.schedule)
        val amount = allotment.amount
    }
}