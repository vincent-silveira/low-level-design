package src;

import src.factory.PaymentProcessorSimpleFactory;
import src.model.PaymentProcessor;

public class Main {
    public static void main(String[] args) {

        String paymentType = "UPI";
        double amount = 4500.00;

        PaymentProcessor processor = new PaymentProcessorSimpleFactory()
                .getPaymentProcessor(paymentType);

        processor.pay(amount);
        processor.refund(amount);
    }
}
