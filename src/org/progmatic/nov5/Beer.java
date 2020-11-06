package org.progmatic.nov5;

public class Beer {
    private double portion = 0.5;
    private int price = 490;
    private int purchasePrice = 100;
    private final double alcoholRate = 0.05;

    public Beer() {
    }

    public double totalAlcohol() {
        return portion * alcoholRate;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getAlcoholRate() {
        return alcoholRate;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
