package org.progmatic.nov5;

public class Wine {
    private double portion = 0.2;
    private int price = 690;
    private int purchasePrice = 200;
    private final double alcoholRate = 0.12;

    public Wine() {
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
