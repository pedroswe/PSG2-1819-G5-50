package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Collection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
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

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;


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
    @RequestMapping(value = "/cause/{causeId}/donations/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
        Collection<Owner> owners = this.clinicService.findAllOwners();
        //Cause cause = this.clinicService.findCauseById(causeId);
		Donation donation = new Donation();
        
        model.put("donation", donation);
        model.put("owners", owners);
        //model.put("cause", cause);
		return VIEWS_DONATION_CREATE_OR_UPDATE_FORM;
    }

    // POST Donation
    @RequestMapping(value = "/cause/{causeId}/donations/new", method = RequestMethod.POST)
    public String processCreationForm(@PathVariable("causeId") int causeId, Donation donation, BindingResult result, ModelMap model) {
        Cause cause = this.clinicService.findCauseById(causeId);
        donation.setCause(cause);
        donation.setMoment(LocalDate.now());
        if (donation.getCause()==null) {
            Collection<Owner> owners = this.clinicService.findAllOwners();
            model.put("owners", owners);
            model.put("donation", donation);
            model.put("donationError", true);
            model.put("donation", donation);
            return VIEWS_DONATION_CREATE_OR_UPDATE_FORM;
		} else {
            try{
                int antes = this.clinicService.findDonationsByCauseId(cause.getId()).size();
                this.clinicService.saveDonation(donation);
                int despues = this.clinicService.findDonationsByCauseId(cause.getId()).size();
                
                model.put("donationSaved", donation);
                boolean iguales = antes == despues;
                if (iguales){
                    model.put("donationError", true);
                    model.put("donation", donation);
                }
            }catch(Exception e){
                model.put("error", true);
            }
        }
        return "redirect:/cause/{causeId}/donations/list";
	}

    // LIST
    @RequestMapping(value = "/cause/{causeId}/donations/list", method = RequestMethod.GET)
    public ModelAndView listDonationsCause(@PathVariable("causeId") int causeId) {
        // aqui va la query que devuelve todas las donations de una cause
        Collection<Donation> donationsVictor = clinicService.findDonationsByCauseId(causeId);
        Cause cause = this.clinicService.findCauseById(causeId);
        Double totalBudgetAchieved = this.clinicService.findTotalBudgetAchievedByCauseId(causeId);
        if (totalBudgetAchieved == null){
            totalBudgetAchieved = 0.0;
        }

        ModelAndView result = new ModelAndView("/cause/showCause");
        result.addObject("donationsVictor", donationsVictor);
        result.addObject("totalBudgetAchieved", totalBudgetAchieved);
        result.addObject("cause", cause);
        return result;

    }
}

