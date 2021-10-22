package pt.iade.unimanage.models;

import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected LocalDate birthDay;
    protected String email;
    protected char gender;

    public Person(String name, LocalDate birthDay, String email, char gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.gender = gender;
    }

    public Person(String name, LocalDate birthDay, char gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public abstract String getReference();
}
