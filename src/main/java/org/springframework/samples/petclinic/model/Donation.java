package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "donation")
public class Donation extends BaseEntity {

    @Column(name = "amount")
    private Double amount;

    @Column(name = "moment")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate donationDate;

    @ManyToOne
    @JoinColumn(name = "cause_id")
    private Cause cause;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner donator;



    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }
   
    public LocalDate getDonationDate() {
        return this.donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Cause getCause() {
        return this.cause;
    }

    public void setCause(Cause cause) {
        this.cause = cause;
    }

    public Owner getOwner() {
        return this.donator;
    }

    public void setOwner(Owner donator) {
        this.donator = donator;
    }



}