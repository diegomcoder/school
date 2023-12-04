package com.diegomd.school.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
    Student studentLawrence;
    Student studentPhillip;

    @BeforeEach
    void setUp() {
        studentLawrence = new Student("Lawrence Powell");

        studentPhillip = new Student("Phillip Raymond");
        studentPhillip.setRegistration("RE00290");
        studentPhillip.consolidateGrade(1, 5.0);
        studentPhillip.consolidateGrade(2, 6.9);
        studentPhillip.consolidateGrade(3, 9.8);
        studentPhillip.consolidateGrade(4, 7.5);
    }

    @Test
    void getRegistration() {
        Assertions.assertNull(studentLawrence.getRegistration());
        Assertions.assertNotNull(studentPhillip.getRegistration());
        Assertions.assertEquals("RE00290", studentPhillip.getRegistration());
    }

    @Test
    void setRegistration() {
        studentLawrence.setRegistration("RE00289");
        Assertions.assertEquals("RE00289", studentLawrence.getRegistration());

        studentPhillip.setRegistration("RE00512");
        Assertions.assertNotEquals("RE00290", studentPhillip.getRegistration());
    }

    @Test
    void getGRADES() {
        Assertions.assertEquals(0, studentLawrence.getGRADES()[0]);
        Assertions.assertEquals(0, studentLawrence.getGRADES()[1]);
        Assertions.assertEquals(0, studentLawrence.getGRADES()[2]);
        Assertions.assertEquals(0, studentLawrence.getGRADES()[3]);

        Assertions.assertEquals(5.0, studentPhillip.getGRADES()[0]);
        Assertions.assertEquals(6.9, studentPhillip.getGRADES()[1]);
        Assertions.assertEquals(9.8, studentPhillip.getGRADES()[2]);
        Assertions.assertEquals(7.5, studentPhillip.getGRADES()[3]);
    }

    @Test
    void consolidateGrade() {
        studentLawrence.consolidateGrade(1, 8.4);
        studentLawrence.consolidateGrade(2, 7.9);
        studentLawrence.consolidateGrade(3, 6.8);
        studentLawrence.consolidateGrade(4, 9.0);

        Assertions.assertEquals(8.4, studentLawrence.getGRADES()[0]);
        Assertions.assertEquals(7.9, studentLawrence.getGRADES()[1]);
        Assertions.assertEquals(6.8, studentLawrence.getGRADES()[2]);
        Assertions.assertEquals(9.0, studentLawrence.getGRADES()[3]);
    }

    @Test
    void calculateFinalAverage() {
        Assertions.assertEquals(0.0, studentLawrence.calculateFinalAverage());

        studentLawrence.consolidateGrade(1, 8.4);
        studentLawrence.consolidateGrade(2, 7.9);
        studentLawrence.consolidateGrade(3, 6.8);
        studentLawrence.consolidateGrade(4, 9.0);
        Assertions.assertEquals(8.0, studentLawrence.calculateFinalAverage());

        Assertions.assertEquals(7.0, studentPhillip.calculateFinalAverage());
    }

    @Test
    void seeState() {
        Assertions.assertTrue(studentLawrence.seeState(2).contains("FAILED the unit 1"));
        Assertions.assertTrue(studentPhillip.seeState(7).contains("PASSED the unit 3"));
        Assertions.assertTrue(studentPhillip.seeState(10).contains("PASSED the unit 4"));

        studentLawrence.consolidateGrade(1, 8.4);
        studentLawrence.consolidateGrade(2, 7.9);
        Assertions.assertTrue(studentLawrence.seeState(3).contains("PASSED the unit 1"));
        Assertions.assertTrue(studentLawrence.seeState(4).contains("PASSED the unit 2"));
    }

    @Test
    void getReport() {
        Assertions.assertTrue(studentLawrence.getReport().contains("obtained a final average equal to 0,00"));
        Assertions.assertTrue(studentPhillip.getReport().contains("obtained a final average equal to 7,00"));

        studentLawrence.consolidateGrade(1, 8.4);
        studentLawrence.consolidateGrade(2, 7.9);
        studentLawrence.consolidateGrade(3, 6.8);
        studentLawrence.consolidateGrade(4, 9.0);
        Assertions.assertTrue(studentLawrence.getReport().contains("obtained a final average equal to 8,00"));
    }

    @AfterEach
    void tearDown() {
        studentLawrence = null;
        studentPhillip = null;
    }
}