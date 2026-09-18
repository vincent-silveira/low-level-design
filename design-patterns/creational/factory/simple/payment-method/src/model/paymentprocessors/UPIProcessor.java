package src.model.paymentprocessors;

import src.model.PaymentProcessor;

public class UPIProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding UPI payment of ₹" + amount);
    }
}
