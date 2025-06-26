package com.pedroviena.cliusuarios.model;

public class user {
    private int id;
    private String name;
    private String email;

    public user() {}
    public user(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

public int getId() {
    return this.id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return this.email;
}

public void setEmail(String email) {
    this.email = email;
}


}
