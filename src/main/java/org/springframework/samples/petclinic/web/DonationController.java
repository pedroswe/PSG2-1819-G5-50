package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DonationController {


    private static final String VIEWS_DONATION_CREATE_OR_UPDATE_FORM = "donation/createDonation";
    private final ClinicService clinicService;
 
    @Autowired
	public DonationController(ClinicService clinicService) {
		this.clinicService = clinicService;
    }

    @InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
    
    // GET Donation
    @RequestMapping(value = "/donation/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
        Collection<Owner> owners = this.clinicService.findAllOwners();
		Donation donation = new Donation();
        model.put("donation", donation);
        model.put("owners", owners);
		return VIEWS_DONATION_CREATE_OR_UPDATE_FORM;
    }

    // POST Donation
    @RequestMapping(value = "/donation/new", method = RequestMethod.POST)
    public String processCreationForm(Donation donation, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            Collection<Owner> owners = this.clinicService.findAllOwners();
            model.put("owners", owners);
            return VIEWS_DONATION_CREATE_OR_UPDATE_FORM;
		} else {
			this.clinicService.saveDonation(donation);
			return "redirect:/donations/" + donation.getId();
        }
        
	}








}