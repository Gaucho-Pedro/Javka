package com.company;

public class Fio {
    private String lastName;
    private final String firstName;// было бы круто выделить ФИО в отдельный класс
    private final String fatherName;

    Fio(String lastName, String firstName, String fatherName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return lastName+" "+firstName+" "+fatherName;
    }

}
