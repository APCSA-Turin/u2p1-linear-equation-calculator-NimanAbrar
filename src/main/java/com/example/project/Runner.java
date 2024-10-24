package com.example.project;
public class Runner {
    public static void main(String [] args) {
        LinearCalculator c = new LinearCalculator("(-5,1)","(1,1)");
        System.out.println(c.distance());
        System.out.println(c.equation());
        System.out.println(c.printInfo());
    }
}