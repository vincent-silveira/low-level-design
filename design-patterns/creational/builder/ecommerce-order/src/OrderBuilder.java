package src;

import java.util.ArrayList;
import java.util.List;

public final class OrderBuilder {

    private String customerId = null;
    private String shippingAddress = null;
    private String billingAddress = null;

    private final List<OrderItem> items = new ArrayList<>();

    private String couponCode = null;
    private boolean giftWrapping = false;
    private String deliveryInstructions = null;
    private String paymentMethod = null;
    private boolean priorityShipping = false;

    private double subtotal;
    private double discount;
    private double shippingCharges;
    private double finalTotal;

    // Customer ID
    public OrderBuilder setCustomerId(String customerId){

        this.customerId = customerId;
        return this;
    }

    // Shipping Address
    public OrderBuilder setShippingAddress(String shippingAddress){

        this.shippingAddress = shippingAddress;
        return this;
    }

    // Billing Address
    public OrderBuilder setBillingAddress(String billingAddress){

        this.billingAddress = billingAddress;
        return this;
    }

    public OrderBuilder setItems(List<OrderItem> orderItems){
        items.addAll(orderItems);
        return this;
    }

    // Add Order-Item
    public OrderBuilder addItem(OrderItem orderItem){
        this.items.add(orderItem);
        return this;
    }

    // Cupon Code
    public OrderBuilder setCouponCode(String couponCode){

        this.couponCode = couponCode;
        return this;
    }

    // Gift Wrapping
    public OrderBuilder setGiftWrapping(boolean giftWrapping){

        this.giftWrapping = giftWrapping;
        return this;
    }


    // Delivery Instructions
    public OrderBuilder setDeliveryInstructions(String deliveryInstructions){

        this.deliveryInstructions = deliveryInstructions;
        return this;
    }

    // Payment Method
    public OrderBuilder setPaymentMethod(String paymentMethod){

        this.paymentMethod = paymentMethod;
        return this;
    }

    // Priority Shipping
    public OrderBuilder setPriorityShipping(boolean priorityShipping){

        this.priorityShipping = priorityShipping;
        return  this;
    }


    // Validations

    // Validate customer id
    private void validateCustomerId(){
        if(customerId == null || customerId.isBlank()){
            throw new IllegalArgumentException("Customer ID is required");
        }
    }

    // Validate shipping address
    private void validateShippingAddress(){
        if(shippingAddress == null || shippingAddress.isBlank()){
            throw new IllegalArgumentException("Shipping address is required");
        }
    }

    // Validate order list is not empty
    private void validateOrderList(){
        if(items.isEmpty())
            throw new IllegalArgumentException("Order must contain at least one item");
    }

    // Set Billing Address
    private void setBillingAddress(){
        if(billingAddress == null || billingAddress.isBlank()){
            billingAddress = shippingAddress;
        }
    }

    // Sub total
    private double calculateSubTotal(){
        double total = 0;

        for(OrderItem item : items){
            total += item.getItemTotal();
        }

        return total;
    }

    // Discount
    private double calculateDiscount() {
        if (couponCode != null && !couponCode.isBlank()) {
            return subtotal * 0.10;
        }

        return 0;
    }

    // Shipping Charges
    private double calculateShippingCharges() {
        return priorityShipping ? 100 : 50;
    }

    // Final Total
    private double calculateFinalTotal(){
        double total = subtotal - discount + shippingCharges;

        if(total < 0){
            throw new ArithmeticException("Something went wrong while calculating!");
        }

        return total;
    }

    // Builder
    public Order build(){
        validateCustomerId();
        validateShippingAddress();

        validateOrderList();
        setBillingAddress();

        this.subtotal = calculateSubTotal();
        this.discount = calculateDiscount();
        this.shippingCharges = calculateShippingCharges();
        this.finalTotal = calculateFinalTotal();

        return new Order(this);

    }


    // Getters
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
}
