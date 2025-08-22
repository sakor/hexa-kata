// infrastructure/payment/CashPaymentAdapter.java
package com.example.coffeemachine.infrastructure.payment;

import com.example.coffeemachine.domain.model.Payment;
import com.example.coffeemachine.domain.ports.out.PaymentPort;

public class CashPaymentAdapter implements PaymentPort {
    @Override
    public boolean pay(Payment payment, double amount) {
        return payment.amount() >= amount;
    }
}
