package com.rd.manwoman;

public class Man extends Person {
    public Man(String firstName, String lastName, String gender, int age, String partner) {
        super(firstName, lastName, gender, age, partner);
        if(age >= 65) {
            setRetired(true);
        } else {
            setRetired(false);
        }
    }


}
