package com.lab3.universitycoins.model.user;

public class AccontBank {

    private Float coins;

    public AccontBank() {
        this.coins = 0F;
    }

    public AccontBank(Float coins) {
        this.coins = coins;
    }

    public Float getCoins() {
        return coins;
    }

    public boolean spend(Float howMuch) {
        if (!hasCoins(howMuch))
            return false;
        this.coins -= howMuch;
        return true;
    }

    public void recive(Float howMuch) {
        this.coins += howMuch;
    }

    public boolean hasCoins(Float howMuch) {
        return (this.coins.compareTo(howMuch) >= 0) ? true : false;
    }

    @Override
    public String toString() {
        String string = new String() + this.coins;
        string = string.replace('.', ';');
        String[] strings;
        try {
            strings = string.split(";");
            while (strings[1].length() < 2) {
                strings[1] += "0";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return this.coins.toString() + " coins";
        }
        return strings[0] + "," + strings[1] + " coins";
    }
}
