package com.example.project1.Discount;

public class SpecialDestinationAreaDiscount implements Discount {

    @Override
    public int discount(int price) {
        return (int) (price - price * 0.1);
    }
}
