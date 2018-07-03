package com.exam;

public class MenuItem {
    int number;
    String name;
    int price;
    int heat;

    public MenuItem(int number, String name, int price, int heat) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.heat = heat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }
}
