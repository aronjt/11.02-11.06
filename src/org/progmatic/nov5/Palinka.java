package org.progmatic.nov5;

public class Palinka {
    private double portion = 0.05;
    private int price = 890;
    private int purchasePrice = 300;
    private final double alcoholRate = 0.5;

    public Palinka() {
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
