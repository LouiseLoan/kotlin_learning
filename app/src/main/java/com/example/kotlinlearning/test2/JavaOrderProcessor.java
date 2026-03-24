package com.example.kotlinlearning.test2;

import java.util.ArrayList;
import java.util.List;

// JAVA
public class JavaOrderProcessor {

    public List<String> getExpensiveItems(List<String> items, List<Double> prices) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (prices.get(i) > 50.0) {
                result.add(items.get(i).toUpperCase());
            }
        }
        return result;
    }

    public double getTotalPrice(List<Double> prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }
}
