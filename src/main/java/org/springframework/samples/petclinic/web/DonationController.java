package org.springframework.samples.petclinic.web;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DonationController {

    private ClinicService clinicService;

    @RequestMapping(value = "/donations/{causeId}/list", method = RequestMethod.GET)
    public ModelAndView listDonationsCause(@PathVariable("causeId") int causeId) {
        // aqui va la query que devuelve todas las donations de una cause
        Collection<Donation> donations = clinicService.findDonationsByCauseId(causeId);
        ModelAndView result = new ModelAndView("");

        return result;

    }

}
