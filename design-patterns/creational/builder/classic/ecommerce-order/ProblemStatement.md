# Problem Statement: E-Commerce Order Builder

## Scenario

Build an order creation system for an e-commerce platform.

An order can contain customer information, shipping and billing details, one or more order items, and several optional checkout preferences.

The system should use the **Builder Pattern** to construct valid order objects without requiring a large or confusing constructor.

## Order Fields

### Required Fields

The following fields must be provided when creating an order:

- Customer ID
- Shipping Address

### Optional Fields

The order may also contain:

- Multiple order items
- Billing Address
- Coupon Code
- Gift Wrapping
- Delivery Instructions
- Payment Method
- Priority Shipping

## Requirements

Implement the order creation system using the **Builder Pattern**.

Your implementation must satisfy the following requirements:

1. Create an `Order` class representing the final order.
2. The `Order` class must have the required fields:
   - Customer ID
   - Shipping Address
3. The `Order` class must support the optional fields:
   - Multiple order items
   - Billing Address
   - Coupon Code
   - Gift Wrapping
   - Delivery Instructions
   - Payment Method
   - Priority Shipping
4. Provide an `Order.Builder` (or an equivalent dedicated builder) that allows the client to construct an order step by step.
5. The builder should allow optional fields to be configured without requiring a constructor containing every possible field.
6. An order must contain **at least one order item**.
7. Order-item quantity must be **greater than zero**.
8. Product prices must **not be negative**.
9. If a billing address is not provided, the billing address should default to the shipping address.
10. The final `Order` object must be **immutable** after it has been built.
11. The builder should validate the required fields and order constraints before creating the final `Order`.
12. The builder should provide a clear `build()` operation that returns the completed `Order`.
13. Calculate and expose:
    - Subtotal
    - Discount
    - Shipping charges
    - Final total
14. The client application should construct the order through the builder rather than directly assembling or mutating the final `Order` object.

## Order Item

Each order item should contain at least:

- Product ID
- Product name
- Product price
- Quantity

The item total should be calculated as:

```text
Product Price × Quantity
```

The order subtotal should be the sum of all item totals.

## Pricing Rules

Use the following rules for the calculated values:

### Subtotal

```text
subtotal = sum of all order item totals
```

### Discount

If a coupon code is provided, apply a **10% discount** to the subtotal.

Otherwise:

```text
discount = 0
```

### Shipping Charges

Use the following shipping rule:

- Priority shipping: ₹100
- Normal shipping: ₹50

### Final Total

```text
finalTotal = subtotal - discount + shippingCharges
```

The final total must never be negative.

## Expected Usage

The client should be able to construct an order in a readable sequence similar to:

```java
Order order = new Order.Builder("CUST-101", "Mumbai, India")
        .addItem(new OrderItem("P101", "Laptop", 75000, 1))
        .addItem(new OrderItem("P102", "Mouse", 1500, 2))
        .billingAddress("Pune, India")
        .couponCode("SAVE10")
        .giftWrapping(true)
        .deliveryInstructions("Leave at the front desk")
        .paymentMethod("UPI")
        .priorityShipping(true)
        .build();
```

The exact API design is up to you, but the implementation must clearly demonstrate the Builder Pattern.

## Validation Expectations

The builder should reject invalid orders.

Examples:

### Missing Customer ID

```text
IllegalArgumentException: Customer ID is required
```

### Missing Shipping Address

```text
IllegalArgumentException: Shipping address is required
```

### No Items

```text
IllegalArgumentException: Order must contain at least one item
```

### Invalid Quantity

```text
IllegalArgumentException: Quantity must be greater than zero
```

### Negative Product Price

```text
IllegalArgumentException: Product price cannot be negative
```

## Immutability Requirements

Once `build()` returns an `Order`:

- The order's fields must not be directly modifiable.
- The collection of order items must not be externally modifiable.
- The builder may continue to exist independently of the completed order.
- Changes made to the builder after `build()` must not modify an already-created order.

## Design Expectations

The implementation should demonstrate the purpose of the Builder Pattern:

- Separate the construction of a complex object from its final representation.
- Make object construction readable.
- Avoid a telescoping constructor with many parameters.
- Keep validation associated with the construction process.
- Allow optional fields to be configured only when needed.
- Produce an immutable final object.

Do not use a Simple Factory or Factory Method as the primary construction mechanism. The focus of this exercise is the **Builder Pattern**.

## Deliverables

Implement the following classes:

- `Order`
- `Order.Builder` or `OrderBuilder`
- `OrderItem`
- `Main` or another client class demonstrating order construction

You may introduce additional supporting classes if they improve the design.

## Learning Objective

This exercise demonstrates how the **Builder Pattern** can be used to construct a complex, immutable e-commerce order while keeping required fields, optional fields, validation, default values, and calculated totals manageable.

## Difficulty

Intermediate
