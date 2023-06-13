package com.rd.manwoman;

public class Main {
    public static void main(String[] args) {
        Man man1 = new Man("Oleksandr", "Pinkovich", "male",66, "Pravoberegna");
        Woman woman1 = new Woman("Vicrotia", "Pravoberegna", "woman", 62, "Pinkovich");
//        woman1.registerPartnership(man1);
        woman1.deregisterPartnership();
    }
}