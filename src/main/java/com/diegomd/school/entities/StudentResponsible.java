package com.diegomd.school.entities;

import java.util.ArrayList;
import java.util.List;

public class StudentResponsible extends Person {

    final byte MONTHS = 12;
    private final boolean[] installments = new boolean[MONTHS];

    public StudentResponsible(String name) {
        super(name);

    }

    public boolean payMonthlyFee(int month, boolean payed) {
        installments[month] = payed;
        return payed;
    }

    private String getMonthsStringFromArray(byte[] months) {
        StringBuilder monthsSb = new StringBuilder();
        for (byte month : months)
            monthsSb.append(", ").append(month);
        if (!monthsSb.isEmpty())
            monthsSb.replace(0, 2, "");
        return monthsSb.toString();
    }

    public byte[] getMonthsWithEffectivePayments() {
        List<Byte> values = new ArrayList<>();
        for (byte i = 0; i < installments.length; i++)
            if (installments[i]) values.add((byte) (i+1));

        byte[] result = new byte[values.size()];
        values.forEach(v -> result[values.indexOf(v)] = v);
        return result;
    }

    @Override
    public String seeState(int month) {
        if (installments[month])
            return String.format("Payment for month %d made.", month);
        return String.format("Payment for month %d is pending.", month);
    }

    @Override
    public String getReport() {
        byte[] monthsWithEffectivePaymentsArr = getMonthsWithEffectivePayments();
        byte installmentsPayedCounter = (byte) monthsWithEffectivePaymentsArr.length;
        String monthsWithEffectivePaymentsStr = getMonthsStringFromArray(monthsWithEffectivePaymentsArr);
        if (monthsWithEffectivePaymentsStr.isEmpty())
            return String.format("%s, the financial person responsible, has not yet paid the monthly fees.", getName());
        return String.format("%s, the financial person responsible, paid %d of %d installments, corresponding to the months: %s.", getName(), installmentsPayedCounter, MONTHS, monthsWithEffectivePaymentsStr);
    }
}
