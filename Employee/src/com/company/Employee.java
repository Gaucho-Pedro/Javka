package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Employee {
    private static int globalId;
    private final int id;

    private Fio fio;

    private final LocalDate birthDate;
    private int age;
    private final Sex sex;

    private String post;
    private BigDecimal salary;
    private Set<String> skills;
    private final LocalDate dataOfStart;
    private boolean fired;

    public Employee(Fio fio, LocalDate birthDate, Sex sex, String post, BigDecimal salary, Set<String> skills, LocalDate dataOfStart) {
        globalId++;
        this.id = globalId;
        this.fio = fio;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
        this.sex = sex;
        this.post = post;
        this.salary = salary;
        this.skills = skills;
        this.dataOfStart = dataOfStart;
    }

    public int calculateAge(LocalDate birthDate) {
        if (LocalDate.now().getMonthValue() < birthDate.getMonthValue() || (LocalDate.now().getMonthValue() < birthDate.getMonthValue() || LocalDate.now().getDayOfMonth() < birthDate.getDayOfMonth())) {
            return LocalDate.now().compareTo(birthDate) - 1;
        } else {
            return LocalDate.now().compareTo(birthDate);
        }
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Fio getFio() {
        return fio;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getDataOfStart() {
        return dataOfStart;
    }

    public int getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nFull Name: " + fio + "\nBirthday: " + birthDate + "\nSex: " + sex + "\nPost: " + post + "\nSalary: " + salary + "\nSkills: " + skills + "\nDate of Start: " + dataOfStart + "\n";
    }
}