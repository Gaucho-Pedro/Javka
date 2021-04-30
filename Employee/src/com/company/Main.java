package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        // write your code here

        Set<String> mySkills= new HashSet<>();
        mySkills.add("Java");
        mySkills.add("C++");
        mySkills.add("Python");
        HashSet<String> bSkills= new HashSet<>();
        bSkills.add("Sql");
        bSkills.add("Moto");
        HashSet<String> aSkills= new HashSet<>();
        aSkills.add("Java");
        aSkills.add("C++");
        List<Employee> employees = List.of(
                new Employee(new Fio("Калаушин", "Вячеслав", "Александрович"), LocalDate.of(2000, 9, 28), Sex.MALE,"Junior",new BigDecimal("3549.90"),mySkills,LocalDate.of(2021, 2, 22)),
                new Employee(new Fio("Калаушин", "Евгений", "Александрович"), LocalDate.of(1990, 12, 19), Sex.MALE, "Director",new BigDecimal("299999.98"),bSkills,LocalDate.of(2021, 2, 22)),
                new Employee(new Fio("Терентьев", "Антон", "Батькович"), LocalDate.of(1993, 4, 20), Sex.MALE,"JavaBoss",new BigDecimal("999999999999.99") ,aSkills,LocalDate.of(2021, 2, 22)),
                new Employee(new Fio("Осокина", "Ирина", "Дмитриевна"), LocalDate.of(2003, 7, 12), Sex.FEMALE,"MyGirl",new BigDecimal("999999999999.99") ,aSkills,LocalDate.of(2021, 2, 22))
        );

        EmployeeRepository employeeRepository = new EmployeeRepository(employees);
//
//        System.out.println(employeeRepository.getByLastName("Калаушин"));
//        System.out.println(employeeRepository.getByGender(Sex.MALE));
//        System.out.println(employeeRepository.getByStates("Director"));
//        System.out.println(employeeRepository.amount());
        System.out.println(employeeRepository);
    }
}
