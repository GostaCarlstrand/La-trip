package com.company;

public class Location {
    protected String name;                        //Name of the location
    protected String address;                     //An address to the location
    protected String description;                 //A description to the location
    protected int taxiCost;                       //What the taxi trip costs
    public String[] activities;
    String [] acceptedMarketPhrases = {"market", "fruit market", "fruits", "fruit", "the market"};
    String [] acceptedCasinoPhrases = {"casino", "ceasar", "ceasar palace", "the casino", "palace", "ceasar casino"};
    String [] acceptedBeachPhrases = {"long beach", "beach", "swim", "the beach"};
    String [] acceptedAirportPhrases = {"airport", "lax", "the airport", "home"};

    public String getName() {
        return name;
    }                  // A public function to get the name of the location
    public static void welcomeToLocation(String inName, String inDescription) {
        System.out.println("We have now arrived to " + inName);
        System.out.println(inDescription);
    }
}
