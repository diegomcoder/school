package com.diegomd.school.entities;

public class Student extends Person {

    private final int UNITS = 4;
    private String registration;
    private final double[] GRADES = new double[UNITS];

    public Student(String name) {
        super(name);
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public double[] getGRADES() {
        return GRADES;
    }

    public void consolidateGrade(int unit, double grade) {
        this.GRADES[unit -1] = grade;
    }

    public double calculateFinalAverage() {
        double gradesSum = 0.0;
        for (double grade : GRADES)
            gradesSum+= grade;
        return gradesSum / UNITS;
    }

    private int getUnitByMonth(int month) {
        return switch (month) {
            case 1, 2, 3 -> 1;
            case 4, 5, 6 -> 2;
            case 7, 8, 9 -> 3;
            case 10, 11, 12 -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }

    @Override
    public String seeState(int month) {
        int unit = getUnitByMonth(month);
        if (getGRADES()[unit -1] >= 7.0)
            return String.format("The student PASSED the unit %d with an average grade equal to %.2f.", unit, getGRADES()[unit -1]);
        return String.format("The student FAILED the unit %d with an average grade equal to %.2f.", unit, getGRADES()[unit -1]);
    }

    @Override
    public String getReport() {
        return String.format("The student %s, obtained a final average equal to %.2f.", getName(), calculateFinalAverage());
    }
}
