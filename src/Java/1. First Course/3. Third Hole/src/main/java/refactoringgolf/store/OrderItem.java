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
        float discount = 0;
        if (getProduct().getCategory() == ProductCategory.Accessories) {
            discount = calculateAccessoriesDiscount();
        }
        if (getProduct().getCategory() == ProductCategory.Bikes) {
            discount = calculateBikesDiscount();
        }
        if (getProduct().getCategory() == ProductCategory.Clothing) {
            discount = calculateClothingDiscount();
        }
        return unitPricePerQuantity() - discount;
    }

    private float calculateAccessoriesDiscount() {
        float discount = 0;
        float unitPricePerQuantity = unitPricePerQuantity();
        if (unitPricePerQuantity >= 100) {
            discount = unitPricePerQuantity * 10 / 100;
        }
        return discount;
    }

    private float calculateBikesDiscount() {
        return unitPricePerQuantity() * 20 / 100;
    }

    private float calculateClothingDiscount() {
        float discount = 0;
        if (getQuantity() > 2) {
            discount = getProduct().getUnitPrice();
        }
        return discount;
    }

    private float unitPricePerQuantity() {
        return getProduct().getUnitPrice() * getQuantity();
    }
}
