package com.epam.tsylko.andrei;


public class RowsValue {
    private String login;
    private String password;
    private String email;
    private String name;
    private String remember;

    public RowsValue(String login, String password, String email, String name, String remember) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.remember = remember;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }
}
