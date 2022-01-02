package com.example.project1.Discount;

public class FirstRideDiscount implements Discount {

    @Override
    public int discount(int price) {
        return (int) (price - price * 0.1);
    }
}
