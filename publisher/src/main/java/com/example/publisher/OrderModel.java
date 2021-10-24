package com.example.publisher;

import java.math.BigDecimal;

public class OrderModel {
    public String code;
    public BigDecimal amount;
    public String deliveryServiceProvider;
    public String customerName;
    public Boolean prioritized;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDeliveryServiceProvider() {
        return deliveryServiceProvider;
    }

    public void setDeliveryServiceProvider(String deliveryServiceProvider) {
        this.deliveryServiceProvider = deliveryServiceProvider;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getPrioritized() {
        return prioritized;
    }

    public void setPrioritized(Boolean prioritized) {
        this.prioritized = prioritized;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "code='" + code + '\'' +
                ", amount=" + amount +
                ", deliveryServiceProvider='" + deliveryServiceProvider + '\'' +
                ", customerName='" + customerName + '\'' +
                ", prioritized=" + prioritized +
                '}';
    }
}
