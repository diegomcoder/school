package com.diegomd.school.entities;

public class StudentResponsible {

    private boolean[] installments = new boolean[12];

    public boolean[] getInstallments() {
        return installments;
    }

    public void setInstallments(boolean[] installments) {
        this.installments = installments;
    }

    public boolean payMonthlyFee(int month, boolean payed) {
        // TODO implements
        return false;
    }
}
