package org.sun.Library.Bean;

import java.io.Serializable;

public class PersonInfo implements Serializable {
    private transient Object id;
    private String name = "";
    private String email = "";
    private String address = "";
    private Phone phone;

    public PersonInfo() {
        this(null, null, null, null, null);
    }

    public void setId(Object id) {
        this.id = id;
    }

    public PersonInfo(Integer id, String name, String email, String address, Phone phone) {
        setAddress(address);
        setEmail(email);
        setId(id);
        setName(name);
        setPhone(phone);
    }

    public Object getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }


}
