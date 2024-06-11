package com.application.livrago.ui.payment;


import java.io.Serializable;

public class Livreur implements Serializable {
    private String name;
    private int age;
    private String vehicle;
    private String gender;

    public Livreur(String name, int age, String vehicle, String gender) {
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name;
    }
}
