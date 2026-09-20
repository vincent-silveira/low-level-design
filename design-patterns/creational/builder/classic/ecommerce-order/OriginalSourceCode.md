# Original Source Code: E-Commerce Order Builder Without Design Patterns

This is the **starting implementation** for the e-commerce order system.

The implementation does **not** use the Builder Pattern. The `Order` object is created using a constructor that requires many parameters, including optional fields.

The purpose of the exercise is to refactor this implementation using the **Builder Pattern**.

---

## OrderItem.java

```java
public final class OrderItem {

    private final String productId;
    private final String productName;
    private final double productPrice;
    private final int quantity;

    public OrderItem(
            String productId,
            String productName,
            double productPrice,
            int quantity) {

        if (productId == null || productId.isBlank()) {
            throw new IllegalArgumentException("Product ID is required");
        }

        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name is required");
        }

        if (productPrice < 0) {
            throw new IllegalArgumentException(
                    "Product price cannot be negative"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemTotal() {
        return productPrice * quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", itemTotal=" + getItemTotal() +
                '}';
    }
}
```

`OrderItem` is immutable. Its constructor validates the item-level constraints before an item can be created.

`OrderItem` does not need to be refactored using the Builder Pattern. The focus of the exercise is the construction of the `Order` object.

---

## Order.java

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Order {

    private final String customerId;
    private final String shippingAddress;
    private final String billingAddress;

    private final List<OrderItem> items;

    private final String couponCode;
    private final boolean giftWrapping;
    private final String deliveryInstructions;
    private final String paymentMethod;
    private final boolean priorityShipping;

    private final double subtotal;
    private final double discount;
    private final double shippingCharges;
    private final double finalTotal;

    public Order(
            String customerId,
            String shippingAddress,
            String billingAddress,
            List<OrderItem> items,
            String couponCode,
            boolean giftWrapping,
            String deliveryInstructions,
            String paymentMethod,
            boolean priorityShipping) {

        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer ID is required"
            );
        }

        if (shippingAddress == null || shippingAddress.isBlank()) {
            throw new IllegalArgumentException(
                    "Shipping address is required"
            );
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one item"
            );
        }

        this.customerId = customerId;
        this.shippingAddress = shippingAddress;

        this.billingAddress = billingAddress != null
                ? billingAddress
                : shippingAddress;

        this.items = Collections.unmodifiableList(
                new ArrayList<>(items)
        );

        this.couponCode = couponCode;
        this.giftWrapping = giftWrapping;
        this.deliveryInstructions = deliveryInstructions;
        this.paymentMethod = paymentMethod;
        this.priorityShipping = priorityShipping;

        this.subtotal = calculateSubtotal();
        this.discount = calculateDiscount();
        this.shippingCharges = calculateShippingCharges();

        this.finalTotal = Math.max(
                0,
                subtotal - discount + shippingCharges
        );
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public boolean isGiftWrapping() {
        return giftWrapping;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPriorityShipping() {
        return priorityShipping;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getShippingCharges() {
        return shippingCharges;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    private double calculateSubtotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getItemTotal();
        }

        return total;
    }

    private double calculateDiscount() {
        if (couponCode != null && !couponCode.isBlank()) {
            return subtotal * 0.10;
        }

        return 0;
    }

    private double calculateShippingCharges() {
        return priorityShipping ? 100 : 50;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerId='" + customerId + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", items=" + items +
                ", couponCode='" + couponCode + '\'' +
                ", giftWrapping=" + giftWrapping +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", priorityShipping=" + priorityShipping +
                ", subtotal=" + subtotal +
                ", discount=" + discount +
                ", shippingCharges=" + shippingCharges +
                ", finalTotal=" + finalTotal +
                '}';
    }
}
```

The `Order` class currently has a large constructor containing both required and optional fields.

This constructor-based approach works, but it becomes difficult to read and maintain as more optional fields are added.

The `Order` class already contains:

- Required-field validation.
- Order-item validation.
- Billing-address defaulting.
- Defensive copying of the item collection.
- Subtotal calculation.
- Discount calculation.
- Shipping-charge calculation.
- Final-total calculation.
- Immutable fields and no setters.

These existing behaviors should continue to work after applying the Builder Pattern.

---

## Main.java

```java
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<OrderItem> items = Arrays.asList(
                new OrderItem(
                        "P101",
                        "Laptop",
                        75000,
                        1
                ),
                new OrderItem(
                        "P102",
                        "Mouse",
                        1500,
                        2
                )
        );

        Order order = new Order(
                "CUST-101",
                "Mumbai, India",
                "Pune, India",
                items,
                "SAVE10",
                true,
                "Leave at the front desk",
                "UPI",
                true
        );

        System.out.println("Customer ID: "
                + order.getCustomerId());

        System.out.println("Shipping Address: "
                + order.getShippingAddress());

        System.out.println("Billing Address: "
                + order.getBillingAddress());

        System.out.println("Items: "
                + order.getItems());

        System.out.println("Subtotal: ₹"
                + order.getSubtotal());

        System.out.println("Discount: ₹"
                + order.getDiscount());

        System.out.println("Shipping Charges: ₹"
                + order.getShippingCharges());

        System.out.println("Final Total: ₹"
                + order.getFinalTotal());
    }
}
```

---

## Example Output

```text
Customer ID: CUST-101
Shipping Address: Mumbai, India
Billing Address: Pune, India
Items: [
    OrderItem{
        productId='P101',
        productName='Laptop',
        productPrice=75000.0,
        quantity=1,
        itemTotal=75000.0
    },
    OrderItem{
        productId='P102',
        productName='Mouse',
        productPrice=1500.0,
        quantity=2,
        itemTotal=3000.0
    }
]
Subtotal: ₹78000.0
Discount: ₹7800.0
Shipping Charges: ₹100.0
Final Total: ₹70300.0
```

---

## Current Design

The current client creates an `Order` using a constructor with many parameters:

```java
Order order = new Order(
        "CUST-101",
        "Mumbai, India",
        "Pune, India",
        items,
        "SAVE10",
        true,
        "Leave at the front desk",
        "UPI",
        true
);
```

The meaning of each argument is not immediately obvious from the call site.

For example:

```java
"Pune, India",
items,
"SAVE10",
true,
"Leave at the front desk",
"UPI",
true
```

represent different optional order properties, but the constructor call does not make those relationships explicit.

---

## Refactoring Goal

Refactor the order construction mechanism using the **Builder Pattern**.

The existing business behavior should remain unchanged.

In particular, preserve:

- Order-item validation.
- Required-field validation.
- Billing-address defaulting.
- Subtotal calculation.
- Discount calculation.
- Shipping-charge calculation.
- Final-total calculation.
- Immutability of the completed `Order`.
- Defensive copying of order items.

The main change should be **how an `Order` is constructed**.

The final client code should no longer need to pass all order properties through one large constructor.
