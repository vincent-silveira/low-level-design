package src;

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


    public Order(OrderBuilder builder){
        this.customerId = builder.getCustomerId();
        this.shippingAddress = builder.getShippingAddress();
        this.billingAddress = builder.getBillingAddress();

        this.items = List.copyOf(builder.getItems());

        this.couponCode = builder.getCouponCode();
        this.giftWrapping = builder.isGiftWrapping();
        this.deliveryInstructions = builder.getDeliveryInstructions();
        this.paymentMethod = builder.getPaymentMethod();
        this.priorityShipping = builder.isPriorityShipping();

        this.subtotal = builder.getSubtotal();
        this.discount = builder.getDiscount();
        this.shippingCharges = builder.getShippingCharges();
        this.finalTotal = builder.getFinalTotal();
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


    @Override
    public String toString() {
        StringBuilder orderString = new StringBuilder("Order {");

        orderString.append("\n\tCustomer Id: ").append(customerId);
        orderString.append("\n\tShipping Address: ").append(shippingAddress);
        orderString.append("\n\tBilling Address: " ).append(billingAddress);
        orderString.append("\n\tOrder Items: [");
        for(OrderItem item : items)
            orderString.append(item);
        orderString.append("\n\t]");
        orderString.append("\n\tCoupon Code: ")
                .append(checkStringValueNotNull(couponCode) ? couponCode : " - ");
        orderString.append("\n\tGift Wrapping: " ).append(giftWrapping ? "Yes" : "No");
        orderString.append("\n\tDelivery Instructions: " )
                .append(checkStringValueNotNull(deliveryInstructions) ? deliveryInstructions : " - ");
        orderString.append("\n\tPayment Method: " )
                .append(checkStringValueNotNull(paymentMethod) ? paymentMethod : " - ");
        orderString.append("\n\tPriority Shipping: " ).append(priorityShipping ? "Yes" : "No");
        orderString.append("\n\tSub Total: ₹" ).append(subtotal);
        orderString.append("\n\tDiscount: ₹" ).append(discount);
        orderString.append("\n\tShipping Charges: ₹" ).append(shippingCharges);
        orderString.append("\n\tFinal Total: ₹" ).append(finalTotal);
        orderString.append("\n}");


        return orderString.toString();
    }

    private boolean checkStringValueNotNull(String value){
        return value != null && !value.isBlank();
    }
}
