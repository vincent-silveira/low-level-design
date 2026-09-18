package src.model;

public interface PaymentProcessor {

    void pay(double amount);
    void refund(double amount);
}
