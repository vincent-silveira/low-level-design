package src;

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

        return  "\n\t\t\t{" +
                "\n\t\t\t\tProduct ID: " + productId +
                "\n\t\t\t\tProduct Name: " + productName +
                "\n\t\t\t\tProduct Price: " + productPrice +
                "\n\t\t\t\tQuantity : " + quantity +
                "\n\t\t\t\tItem Total: " + getItemTotal() +
                "\n\t\t\t}\n";

    }
}
