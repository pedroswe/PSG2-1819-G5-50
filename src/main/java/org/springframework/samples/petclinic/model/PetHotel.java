package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hotel")
public class PetHotel extends BaseEntity {

    @Column(name = "init_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate initDate;
    
    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;

    @Column(name = "pet")
    @OneToOne
    private Pet pet;


    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public LocalDate getInitDate() {
        return this.initDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

}