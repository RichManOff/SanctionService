package com.example.sanction_service.model;

import jakarta.persistence.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@Table(name = "sanctions")
@XmlRootElement(name = "CONSOLIDATED_LIST")
@XmlAccessorType(XmlAccessType.FIELD)
public class SanctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement(name = "FIRST_NAME")
    private String name;

    @XmlElement(name = "SECOND_NAME")
    private String surname;

    @XmlElement(name = "INDIVIDUAL_DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @XmlElement(name = "NATIONALITY")
    private String nationality;

    @XmlElement(name = "LISTED_ON")
    private LocalDate sanctionStartDate;

    @XmlElement(name = "LAST_DAY_UPDATED")
    private LocalDate sanctionEndDate;

    public SanctionEntity() {
    }

    public SanctionEntity(Long id, String name, String surname, LocalDate dateOfBirth, String nationality, LocalDate sanctionStartDate, LocalDate sanctionEndDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.sanctionStartDate = sanctionStartDate;
        this.sanctionEndDate = sanctionEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
