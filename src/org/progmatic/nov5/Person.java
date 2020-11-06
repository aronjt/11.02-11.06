package org.progmatic.nov5;

public class Person {
    private int favoriteDrink;
    private boolean isFavoriteDrink;
    private boolean isThirsty;
    private int timeSpend;
    private int failOrder;
    private boolean angry;
    private boolean isAngryType;
    private double alcoholLevel;
    private double breakPoint;

    public Person() {
        int r1 = (int) (Math.random()*2);
        if (r1 < 1) {
            isFavoriteDrink = true;
        }
        favoriteDrink = (int)(Math.random()*3+1);
        isThirsty = true;
        timeSpend = (int) (Math.random()*20+1);
        int r2 = (int) (Math.random()*2);
        if (r2 < 1) {
            isAngryType = true;
        }
        breakPoint = Math.random();
    }

    public void thirstiness() {
        int r1 = (int) (Math.random()*2);
        if (r1 < 1) {
            isThirsty = false;
        } else {
            isThirsty = true;
        }
    }

    public void drink(double alcohol) {
        alcoholLevel += alcohol;
    }

    public void cantOrder() {
        failOrder++;
        double angryD = failOrder * alcoholLevel;
        if (isAngryType && angryD > breakPoint) {
            angry = true;
        }
    }

    public int getFavoriteDrink() {
        return favoriteDrink;
    }

    public boolean isFavoriteDrink() {
        return isFavoriteDrink;
    }

    public boolean isThirsty() {
        return isThirsty;
    }

    public int getTimeSpend() {
        return timeSpend;
    }

    public int getFailOrder() {
        return failOrder;
    }

    public boolean isAngry() {
        return angry;
    }

    public boolean isAngryType() {
        return isAngryType;
    }

    public double getAlcoholLevel() {
        return alcoholLevel;
    }

    public double getBreakPoint() {
        return breakPoint;
    }

    public void setFavoriteDrink(int favoriteDrink) {
        this.favoriteDrink = favoriteDrink;
    }

    public void setTimeSpendMinus() {
        timeSpend--;
    }

    public void setFavoriteDrink(boolean favoriteDrink) {
        isFavoriteDrink = favoriteDrink;
    }

    public void setThirsty(boolean thirsty) {
        isThirsty = thirsty;
    }

    public void setFailOrder(int failOrder) {
        this.failOrder = failOrder;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    public void setAngryType(boolean angryType) {
        isAngryType = angryType;
    }

    public void setAlcoholLevel(double alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public void setBreakPoint(double breakPoint) {
        this.breakPoint = breakPoint;
    }
}
