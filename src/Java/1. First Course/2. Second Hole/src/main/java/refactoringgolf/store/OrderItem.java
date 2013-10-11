package refactoringgolf.store;

class OrderItem {

    private Product product;
    private int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    Product getProduct() {
        return product;
    }

    int getQuantity() {
        return quantity;
    }
}
