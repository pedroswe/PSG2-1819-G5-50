
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "causes")



public class Cause extends NamedEntity {
   
    @Column(name = "cause_name")
    private String name;

    @JoinColumn(name = "cause_description")
    private String description;

    @JoinColumn(name = "budgetTarget")
    private Double budgetTarget;

    @JoinColumn(name = "organization")
    private String organization;



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setBudgetTarget(Double budgetTarget) {
        this.budgetTarget = budgetTarget;
    }

    public Double getBudgetTarget() {
        return this.budgetTarget;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void getStatus(boolean status) {
        status=false;
        if(budgetTarget <3000){
            status=true;
        }
       
    }
}