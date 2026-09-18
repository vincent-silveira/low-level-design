# Problem Statement: Payment Method Processing Module

## Scenario

You are developing a payment processing module for an e-commerce application.

The application supports multiple payment methods:

* Credit Card
* PayPal
* UPI

Each payment method has its own implementation for processing payments and refunds.

## Objective

Build a payment processing system where the client can process payments using different payment methods.

Each payment processor must support the following operations:

```java
void pay(double amount);
void refund(double amount);
```

## Requirements

1. Create separate classes for Credit Card, PayPal, and UPI payment processing.
2. Each payment processor should implement the `pay(double amount)` and `refund(double amount)` methods.
3. The client application should be able to select a payment method based on a payment type.
4. The client should not directly instantiate payment processor classes.
5. Adding a new payment type in the future should require minimal changes to the existing code.
6. Invalid or unsupported payment types should be handled properly.

## Expected Behavior

For example:

* Selecting `"CREDIT_CARD"` should return a Credit Card payment processor.
* Selecting `"PAYPAL"` should return a PayPal payment processor.
* Selecting `"UPI"` should return a UPI payment processor.
* Selecting an invalid payment type should display an appropriate error message or throw an exception.

## Learning Objective

This exercise demonstrates how the **Simple Factory Pattern** can centralize object creation and reduce direct dependencies between the client and concrete payment processor classes.

## Difficulty

Beginner
