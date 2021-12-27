package com.internetpackageapp;

public class Users {

    private Integer user_id;
    private String phone_number;
    private String password;
    private Integer kuota;
    private String full_name;
    private String address;

    public Users(Integer user_id, String phone_number, String password, Integer kuota, String full_name, String address) {
        this.user_id = user_id;
        this.phone_number = phone_number;
        this.password = password;
        this.kuota = kuota;
        this.full_name = full_name;
        this.address = address;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public Integer getKuota() {
        return kuota;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getAddress() {
        return address;
    }
}
