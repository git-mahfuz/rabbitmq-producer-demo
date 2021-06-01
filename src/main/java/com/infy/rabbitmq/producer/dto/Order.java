package com.infy.rabbitmq.producer.dto;

import com.infy.rabbitmq.producer.enums.Status;

public class Order {

    private String orderId;

    private String customerName;

    private int quantity;

    private double price;

    private Status status;

    public Order() {}

    public Order(String orderId, String customerName, int quantity, double price, Status status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
