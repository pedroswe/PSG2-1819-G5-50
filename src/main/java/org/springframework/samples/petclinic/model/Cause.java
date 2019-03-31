
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "domain")



public class Domain extends NamedEntity {
   
    @Column(name = "domain_name")
    private String name;

    @JoinColumn(name = "domain_description")
    private String description;

    @JoinColumn(name = "domain_budgetTarget")
    private Double budgetTarget;

    @JoinColumn(name = "domain_organization")
    private String organization;

    @JoinColumn(name = "domain_status")
    private boolean status;


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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }


}