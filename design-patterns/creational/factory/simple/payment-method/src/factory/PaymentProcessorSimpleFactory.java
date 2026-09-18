package src.factory;

import src.model.PaymentProcessor;
import src.model.PaymentType;
import src.model.paymentprocessors.CreditCardProcessor;
import src.model.paymentprocessors.PayPalProcessor;
import src.model.paymentprocessors.UPIProcessor;

public class PaymentProcessorSimpleFactory {

    public PaymentProcessor getPaymentProcessor(String type){
        PaymentType paymentType;

        try{
            paymentType = PaymentType.valueOf(type);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid payment type: " + type);
        }

        return switch (paymentType){
            case CREDIT_CARD -> new CreditCardProcessor();
            case PAYPAL -> new PayPalProcessor();
            case UPI -> new UPIProcessor();
        };
    }
}
