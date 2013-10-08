package refactoringgolf.store;

public class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float total() {
        return unitPricePerQuantity() - product.getDiscount().calculateDiscount(this);
    }

    float unitPricePerQuantity() {
        return getProduct().getUnitPrice() * getQuantity();
    }
}
