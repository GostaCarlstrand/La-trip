package com.company;

public class Market extends Location {
    public Market(String inName, String inAddress) {
        super();

        name = inName;
        address = inAddress;
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;

    }

    public void marketActivity() {
     welcomeToLocation(name,description);

    }



}


