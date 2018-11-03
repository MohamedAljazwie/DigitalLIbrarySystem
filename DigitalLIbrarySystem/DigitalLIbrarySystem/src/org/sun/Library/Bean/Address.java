package org.sun.Library.Bean;

import java.io.Serializable;

public class Address  implements Serializable{
    private String city;
    private String Countury;
    public Address() {
        this("",  "");
    }
    public Address(String city, String countury ) {
        setCity(city);
        setCountury(countury);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountury(String Countury) {
        this.Countury = Countury;
    }

    public String getCountury() {
        return Countury;
    }
}
