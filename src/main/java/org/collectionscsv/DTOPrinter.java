package org.collectionscsv;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DTOPrinter {
    private DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

    public void printEmployee(EmployeeDTO dto) {
        System.out.print("Id: ");
        System.out.println(dto.id);

        System.out.print("Name: ");
        System.out.println(dto.name);

        System.out.print("Gender: ");
        System.out.println(dto.gender);

        System.out.print("Birth date: ");
        System.out.println(dateToString(dto.birthDate));

        System.out.println("Department: ");
        System.out.println("......................");
        printDepartment(dto.department);

        System.out.print("Salary: ");
        System.out.println(dto.salary);

        System.out.println("======================");
    }

    private String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public void printDepartment(DepartmentDTO dto) {
        System.out.print("Id: ");
        System.out.println(dto.id);

        System.out.print("Name: ");
        System.out.println(dto.name);

        System.out.println("......................");
    }
}
