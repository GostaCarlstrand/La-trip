package com.company;

public class Beach extends Location{
    public int temperature;
    public Beach(int inTemperature,String inName,String inAddress,String inDescription,int inTaxiCost) {
        super(inName,inAddress,inDescription,inTaxiCost);

        temperature = inTemperature;

    }

}
