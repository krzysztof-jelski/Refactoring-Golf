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
        float totalAmount = totalAmount();
        float tax = tax(totalAmount);
        int shipping = shipping();

        return totalAmount + tax + shipping;
    }

    private int shipping() {
        int shipping = 15;
        if (this.deliveryCountry.equals("USA")) {
            shipping = 0;
        }
        return shipping;
    }

    private float tax(float totalAmount) {
        return totalAmount * 5 / 100;
    }

    private float totalAmount() {
        float totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.total();
        }
        return totalAmount;
    }
}
