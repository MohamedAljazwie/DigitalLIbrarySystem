package org.sun.Library.Bean;

import java.io.Serializable;

public class Access implements Serializable {
    private String userName;
    private String password;
    public Access() {
        this("", "");
    }
    public Access(String userName,String password) {
        setPassword(password);
        setUserNmae(userName);
    }

    public void setUserNmae(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
