package com.diegomd.school.entities;

public class StudentResponsible extends Person {

    private boolean[] installments = new boolean[12];

    public StudentResponsible(String name) {
        super(name);
    }

    public boolean[] getInstallments() {
        return installments;
    }

    public void setInstallments(boolean[] installments) {
        this.installments = installments;
    }

    public boolean payMonthlyFee(int month, boolean payed) {
        installments[month] = payed;
        return payed;
    }

    private String getMonthsWithEffectivePayments() {
        StringBuilder monthsWithEffectivePayments = new StringBuilder();
        for (byte i = 0; i < installments.length; i++)
            if (installments[i]) monthsWithEffectivePayments.append(", ").append(i);
        if (!monthsWithEffectivePayments.isEmpty())
            monthsWithEffectivePayments.replace(0,2, "");
        return monthsWithEffectivePayments.toString();
    }

    @Override
    public String seeState(int month) {
        if (getInstallments()[month])
            return String.format("Payment for month %d made.", month);
        return String.format("Payment for month %d is pending.", month);
    }

    @Override
    public String getReport() {
        String monthsWithEffectivePayments = getMonthsWithEffectivePayments();
        if (monthsWithEffectivePayments.isEmpty())
            return String.format("The financial person %s has not yet paid the monthly fees.", getName());
        return String.format("The financial person responsible %s paid the following monthly fees: %s.", getName(), monthsWithEffectivePayments);
    }
}
