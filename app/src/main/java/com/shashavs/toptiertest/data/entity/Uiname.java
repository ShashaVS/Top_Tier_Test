package com.shashavs.toptiertest.data.entity;

public class Uiname {

    private String name;
    private String surname;
    private String gender;
    private String region;
    private int age;

    public Uiname(String name, String surname, String gender, String region) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    public int getAge() {
        return age;
    }
}
