package edu.harvard.cs50.travelexplorer;

public class Country {
    private String name;
    private String code;
    private String capital;
    private String population;
    private String flag_url;

    public Country(String name, String code, String capital, String population, String flag_url) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.population = population;
        this.flag_url = flag_url;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getFlag_url() {
        return flag_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setFlag_url(String flag_url) {
        this.flag_url = flag_url;
    }
}
