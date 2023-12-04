package com.diegomd.school.entities;

public class Student {

    private String registration;
    private final double[] GRADES = new double[4];

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void consolidateGrade(int unit, double grade) {
        // TODO implements
    }

    public double calculateFinalAverage() {
        // TODO implements
        return 0.0;
    }

}
