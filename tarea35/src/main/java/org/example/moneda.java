package org.example;

public class moneda {

    private String name;
    private String symbol;
    private double price_usd;
    private int rank;
    private double percent_change_24h;

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public int getRank() {
        return rank;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }
}
