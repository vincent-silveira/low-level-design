package src;

public class OrderDispatcher {

    public static void main(String[] args) {
        Order order = new OrderBuilder()
                .setCustomerId("CUST-101")
                .setShippingAddress("Mumbai, India")
                .addItem(new OrderItem("P-001", "Laptop", 60000, 2))
                .addItem(new OrderItem("P-012", "GPU", 1_00_000, 12))
                .build();

        System.out.println(order);
    }
}
