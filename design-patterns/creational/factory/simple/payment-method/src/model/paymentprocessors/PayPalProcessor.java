package src.model.paymentprocessors;

import src.model.PaymentProcessor;

public class PayPalProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of ₹" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding PayPal payment of ₹" + amount);
    }
}
