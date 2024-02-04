package org.example.bean;

public class Customer {
    private String name;

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(IWaiter iWaiter) {
        iWaiter.serve(name);
    }

    public String getName() {
        return this.name;
    }
}
