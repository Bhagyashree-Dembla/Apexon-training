package com.acme;

public class Country {
    private String countryId;
    private String countryName;

    public Country() {}

    public String getCountryId() {
        return countryId;
    }
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void display() {
        System.out.println("  Country Id   : " + countryId);
        System.out.println("  Country Name : " + countryName);
    }
}
