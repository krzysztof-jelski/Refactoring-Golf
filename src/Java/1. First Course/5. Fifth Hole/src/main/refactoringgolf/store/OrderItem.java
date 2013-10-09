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

    float total() {
        return unitPricePerQuantity() - product.getDiscount().calculateDiscount(this);
    }

    float unitPricePerQuantity() {
        return getProduct().getUnitPrice() * getQuantity();
    }
}
