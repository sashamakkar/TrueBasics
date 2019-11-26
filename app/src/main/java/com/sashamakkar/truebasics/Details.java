package com.sashamakkar.truebasics;

public class Details {

    private String name, age, gender, contact, email, subscribe;

    public String getGender() {
        return gender;
    }

    public Details(String name, String age, String gender, String contact, String email, String subscribe) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.subscribe = subscribe;
    }


    public Details() {
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
