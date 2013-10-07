package refactoringgolf.store;

public class Product {

    public static final String CLOTHING = "Clothing";
    public static final String ACCESSORIES = "Accessories";
    public static final String BIKES = "Bikes";

	public String name;
	public float unitPrice;
	public String category;
	public ImageInfo image;
	public int unitsInStock;

	public Product(String name, float unitPrice, String category, ImageInfo image) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.category = category;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public String getCategory() {
		return category;
	}

	public ImageInfo getImage() {
		return image;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String toXml() {
		return "<product>" + "<name>" + name + "</name>" + "<category>"
				+ category + "</category>" + "</product>";
	}
}
