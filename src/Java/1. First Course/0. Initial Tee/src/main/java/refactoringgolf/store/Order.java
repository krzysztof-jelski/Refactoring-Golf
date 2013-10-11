package refactoringgolf.store;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private Customer customer;
    private Salesman salesman;
    private Date orderedOn;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryCountry;
    private Set<OrderItem> items;

    public Order(Customer customer, Salesman salesman, String deliveryStreet, String deliveryCity, String deliveryCountry, Date orderedOn) {
        this.customer = customer;
        this.salesman = salesman;
        this.deliveryStreet = deliveryStreet;
        this.deliveryCity = deliveryCity;
        this.deliveryCountry = deliveryCountry;
        this.orderedOn = orderedOn;
        this.items = new HashSet<OrderItem>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public float total() {
        float totalAmount = 0;
        for (OrderItem item : items) {
            float discount = 0;
            float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
            if (item.getProduct().getCategory().equals(Product.ACCESSORIES)) {
                discount = 0;
                if (itemAmount >= 100) {
                    discount = itemAmount * 10 / 100;
                }
            }
            if (item.getProduct().getCategory().equals(Product.BIKES)) {
                discount = itemAmount * 20 / 100;
            }
            if (item.getProduct().getCategory().equals(Product.CLOTHING)) {
                discount = 0;
                if (item.getQuantity() > 2) {
                    discount = item.getProduct().getUnitPrice();
                }
            }
            itemAmount = itemAmount - discount;
            totalAmount += itemAmount;
        }

        if (this.deliveryCountry.equals("USA"))
            // totalAmount=totalItemAmount + tax + 0 shipping
            return totalAmount + totalAmount * 5 / 100;

        // totalAmount=totalItemAmount + tax + 15 shipping
        return totalAmount + totalAmount * 5 / 100 + 15;
    }
}
