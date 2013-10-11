package refactoringgolf.store;

public enum ProductCategory {
    Accessories {
        @Override
        public CategoryDiscount getDiscount() {
            return new AccessoriesDiscount();
        }
    },
    Bikes {
        @Override
        public CategoryDiscount getDiscount() {
            return new BikesDiscount();
        }
    },
    Clothing {
        @Override
        public CategoryDiscount getDiscount() {
            return new ClothingDiscount();
        }
    };

    public abstract CategoryDiscount getDiscount();
}
