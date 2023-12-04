package com.diegomd.school.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentResponsibleTest {

    StudentResponsible sr1;

    @BeforeEach
    void setUp() {
        sr1 = new StudentResponsible("Lawrence Mendoza");
    }

    @Test
    void getMonthsWithEffectivePayments() {
        Assertions.assertEquals(0, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(1, true);
        Assertions.assertEquals(1, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(2, false);
        Assertions.assertEquals(1, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(3, false);
        Assertions.assertEquals(1, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(4, true);
        Assertions.assertEquals(2, sr1.getMonthsWithEffectivePayments().length);
    }

    @Test
    void payMonthlyFee() {
        Assertions.assertEquals(0, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(1, true);
        sr1.payMonthlyFee(2, false);
        sr1.payMonthlyFee(3, true);
        Assertions.assertEquals(2, sr1.getMonthsWithEffectivePayments().length);

        sr1.payMonthlyFee(4, false);
        sr1.payMonthlyFee(5, true);
        sr1.payMonthlyFee(6, true);
        Assertions.assertEquals(4, sr1.getMonthsWithEffectivePayments().length);
    }

    @Test
    void seeState() {
        Assertions.assertEquals("Payment for month 1 is pending.", sr1.seeState(1));

        sr1.payMonthlyFee(1, true);
        Assertions.assertEquals("Payment for month 1 made.", sr1.seeState(1));
    }

    @Test
    void getReport() {
        Assertions.assertTrue(sr1.getReport().contains("has not yet paid the monthly fees"));

        sr1.payMonthlyFee(1, true);
        sr1.payMonthlyFee(2, true);
        sr1.payMonthlyFee(3, true);

        Assertions.assertTrue(sr1.getReport().contains("paid 3 of 12 installments"));
    }

    @AfterEach
    void tearDown() {
        sr1 = null;
    }
}