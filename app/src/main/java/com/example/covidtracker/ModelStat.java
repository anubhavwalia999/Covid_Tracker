package com.example.covidtracker;

public class ModelStat {

    /*"Country":"Afghanistan",
    "CountryCode":"AF",
    "Slug":"afghanistan",
    "NewConfirmed":10,
    "TotalConfirmed":39703,
    "NewDeaths":1,
    "TotalDeaths":1473,
    "TotalDeaths":6,
    "TotalRecovered":33064,
    "Date":"2020-10-11T09:51:46Z",
    "Premium":{}
     */
    String Country,CountryCode,Slug,TotalConfirmed,NewConfirmed,NewDeaths,TotalDeaths,NewRecovered,TotalRecovered,
    Data;
    public ModelStat(String country, String countryCode, String slug,String totalConfirmed, String newConfirmed, String newDeaths, String totalDeaths, String newRecovered, String totalRecovered, String data) {
        Country = country;
        CountryCode = countryCode;
        Slug = slug;
        TotalConfirmed=totalConfirmed;
        NewConfirmed = newConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
        Data = data;

    }
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public String getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        NewRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }


}
