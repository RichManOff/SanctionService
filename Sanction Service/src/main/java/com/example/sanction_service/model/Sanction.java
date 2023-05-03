package com.example.sanction_service.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDate;

public class Sanction {
    @JacksonXmlProperty(localName = "first_name")
    private String name;

    @JacksonXmlProperty(localName = "last_name")
    private String surname;

    @JacksonXmlProperty(localName = "date_of_birth")
    private LocalDate dateOfBirth;

    @JacksonXmlProperty(localName = "nationality")
    private String nationality;

    @JacksonXmlProperty(localName = "sanction_start_date")
    private LocalDate sanctionStartDate;

    @JacksonXmlProperty(localName = "sanction_end_date")
    private LocalDate sanctionEndDate;

    // getters and setters for the fields

    public Sanction() {
    }

    public Sanction(String name, String surname, LocalDate dateOfBirth, String nationality, LocalDate sanctionStartDate, LocalDate sanctionEndDate) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.sanctionStartDate = sanctionStartDate;
        this.sanctionEndDate = sanctionEndDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getSanctionStartDate() {
        return sanctionStartDate;
    }

    public void setSanctionStartDate(LocalDate sanctionStartDate) {
        this.sanctionStartDate = sanctionStartDate;
    }

    public LocalDate getSanctionEndDate() {
        return sanctionEndDate;
    }

    public void setSanctionEndDate(LocalDate sanctionEndDate) {
        this.sanctionEndDate = sanctionEndDate;
    }
}
