package com.example.project360fx;

public class Pizza_Order {
    private String type;

    private boolean mush;

    private boolean onion;

    private boolean olive;

    private boolean extraChz;

    private String number;

    private double price;

    private String status;




    public Pizza_Order() {
        type = "";
        mush = false;
        onion = false;
        olive = false;
        extraChz = false;
        number = "";
        price = 0;
        status = "";
    }

    public Pizza_Order(String pizzaType, boolean m, boolean hasOnion, boolean hasOlive, boolean ex, String num) {
        type = pizzaType;
        mush = m;
        onion = hasOnion;
        olive = hasOlive;
        extraChz = ex;
        number = num;
        status = "New Order";
        price = get_Price();


    }

    public String get_Type() {
        return type;
    }

    public void set_Type(String s) {
        type = s;
    }

    public boolean get_Mush() {

        return mush;
    }

    public void set_Mush(boolean b) {
        mush = b;
    }

    public boolean get_Onion() {
        return onion;
    }

    public void set_Onion(boolean b) {
        onion = b;
    }

    public boolean get_Olive() {
        return olive;
    }

    public void set_Olive(boolean b) {
        olive = b;
    }

    public boolean get_Exchz() {
        return extraChz;
    }

    public void set_Exchz(boolean b) {
        extraChz = b;
    }

    public String get_Num() {
        return number;
    }

    public void set_Num(String i) {
        number = i;
    }

    public double get_Price() {

        int toppings = 0;

        if (type.equals("Pepperoni")) {
            price = 12.00;
        } else if (type.equals("Vegetable")) {
            price = 15.00;
        } else {
            price = 10.00;
        }

        if (mush) {
            price = price + 1.50;
        }
        if (olive) {
            price = price + 1.50;
        }
        if (onion) {
            price = price + 1.50;
        }
        if (extraChz) {
            price = price + 1.50;
        }

        return price;
    }

    public void set_Price(double i) {
        price = i;
    }

    public String get_Status() {
        return status;
    }

    public void set_Status(String s) {
        status = s;
    }

    public String print_order(){
        String s;

        s = "Order Number: " + number + "\n" + type + "\n";
        if (mush) {
            s = s + "+ Mushroom\n";
        }
        if (olive) {
            s = s + "+ Olive\n";
        }
        if (onion) {
            s = s + "+ Onion\n";
        }
        if (extraChz) {
            s = s + "+ Extra Cheese\n";
        }
        s = s + "Status: " + status;

        return s;

    }
}
