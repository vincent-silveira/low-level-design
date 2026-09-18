# Original Source Code: Payment Processing Without Design Patterns

## Overview

This implementation creates payment processor objects directly in the client code.

It does not use the Simple Factory Pattern.

---

## PaymentProcessor.java

```java
public interface PaymentProcessor {

    void pay(double amount);

    void refund(double amount);
}
```

---

## CreditCardProcessor.java

```java
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
```

---

## PayPalProcessor.java

```java
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
```

---

## UPIProcessor.java

```java
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
```

---

## PaymentClient.java

```java
public class PaymentClient {

    public static void main(String[] args) {

        String paymentType = "UPI";
        double amount = 1500.00;

        PaymentProcessor processor;

        if (paymentType.equalsIgnoreCase("CREDIT_CARD")) {
            processor = new CreditCardProcessor();

        } else if (paymentType.equalsIgnoreCase("PAYPAL")) {
            processor = new PayPalProcessor();

        } else if (paymentType.equalsIgnoreCase("UPI")) {
            processor = new UPIProcessor();

        } else {
            throw new IllegalArgumentException(
                "Invalid payment type: " + paymentType
            );
        }

        processor.pay(amount);
        processor.refund(500.00);
    }
}
```

---

## Sample Output

```text
Processing UPI payment of ₹1500.0
Refunding UPI payment of ₹500.0
```

---

## Problems With This Approach

### 1. Direct Object Creation

The client directly creates concrete classes:

```java
new CreditCardProcessor();
new PayPalProcessor();
new UPIProcessor();
```

This creates tight coupling between the client and payment processor implementations.

### 2. Conditional Logic in Client

The client contains multiple `if-else` statements to decide which object to create.

As more payment methods are added, this logic becomes increasingly difficult to maintain.

### 3. Violates Single Responsibility Principle

The client is responsible for:

* Selecting the payment method.
* Creating payment processor objects.
* Processing payments.

Object creation should ideally be separated from business logic.

### 4. Difficult to Extend

Adding a new payment method requires modifying the client class.

For example, adding Bitcoin payments would require another `else-if` block.

---

## Conclusion

This implementation works correctly but creates unnecessary dependencies between the client and concrete payment classes.

The Simple Factory Pattern can improve this design by centralizing object creation in a separate factory class.
