
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "causes")
public class Cause extends BaseEntity {
   
    @Column(name = "cause_name")
    @NotEmpty
    private String name;

    @Column(name = "cause_description")
    @NotEmpty
    private String description;

    @Column(name = "budgetTarget")
    private Double budgetTarget;

    @Column(name = "organization")
    @NotEmpty
    private String organization;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

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