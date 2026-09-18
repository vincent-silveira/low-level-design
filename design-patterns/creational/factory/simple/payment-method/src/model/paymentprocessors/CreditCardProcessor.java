package src.model.paymentprocessors;

import src.model.PaymentProcessor;

public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding Credit Card payment of ₹" + amount);
    }
}
