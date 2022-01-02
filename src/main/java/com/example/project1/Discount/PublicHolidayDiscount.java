package com.example.project1.Discount;

public class PublicHolidayDiscount implements Discount {

    @Override
    public int discount(int price) {
        return (int) (price - price * 0.05);
    }
}
