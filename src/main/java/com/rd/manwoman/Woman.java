package com.rd.manwoman;

public class Woman extends Person {
    String previosLastName;
    public Woman(String firstName, String lastName, String gender, int age, String partner) {
        super(firstName, lastName, gender, age, partner);
        if(age >= 60) {
            setRetired(true);
        } else {
            setRetired(false);
        }
    }
    public void registerPartnership (Man partner) {
        this.previosLastName = getLastName();
        setLastName(partner.getLastName());
    }
    public void deregisterPartnership (){
        if (previosLastName != null) {
            setLastName(previosLastName);
        } else {
            System.out.println("Вона не заміжня");
        }
    }
}
