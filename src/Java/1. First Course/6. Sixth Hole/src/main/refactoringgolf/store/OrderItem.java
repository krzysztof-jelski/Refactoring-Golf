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
        return unitPricePerQuantity() - createCategoryDiscount().calculateDiscount(this);
    }

    private CategoryDiscount createCategoryDiscount() {
        CategoryDiscount categoryDiscount = null;
        if (getProduct().getCategory() == ProductCategory.Accessories) {
            categoryDiscount = new AccessoriesDiscount();
        }
        if (getProduct().getCategory() == ProductCategory.Bikes) {
            categoryDiscount = new BikesDiscount();
        }
        if (getProduct().getCategory() == ProductCategory.Clothing) {
            categoryDiscount = new ClothingDiscount();
        }
        return categoryDiscount;
    }

    float unitPricePerQuantity() {
        return getProduct().getUnitPrice() * getQuantity();
    }
}
