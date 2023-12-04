package com.diegomd.school;

import com.diegomd.school.entities.Student;
import com.diegomd.school.entities.StudentResponsible;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student("Megan Jimenez Thompson");

        student.consolidateGrade(1, 6.0);
        student.consolidateGrade(2, 8.0);
        student.consolidateGrade(3, 7.0);
        student.consolidateGrade(4, 7.8);

        System.out.println(student.getReport());
        System.out.println(student.seeState(5));

        StudentResponsible studentResponsible = new StudentResponsible("Mike Scott Thompson");

        studentResponsible.payMonthlyFee(1, true);
        studentResponsible.payMonthlyFee(2, true);
        studentResponsible.payMonthlyFee(3, false);
        studentResponsible.payMonthlyFee(4, true);
        studentResponsible.payMonthlyFee(5, false);

        System.out.println(studentResponsible.getReport());
        System.out.println(studentResponsible.seeState(3));
        System.out.println(studentResponsible.seeState(4));
    }
}
