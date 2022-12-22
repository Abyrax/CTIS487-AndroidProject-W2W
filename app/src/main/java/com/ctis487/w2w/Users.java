package com.ctis487.w2w;

public class Users {
    private String name;
    private String username;
    private String psw;

    public Users(String name, String username, String psw) {
        this.name = name;
        this.username = username;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }
    public String getPsw() {
        return psw;
    }
    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
