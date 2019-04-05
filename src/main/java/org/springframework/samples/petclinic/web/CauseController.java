package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "/cause" })
public class CauseController {

	@Autowired
	private ClinicService clinicService;

	// LIST general
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView result;

		result = new ModelAndView("cause/causeList");

		Collection<Cause> causes = new ArrayList<Cause>();

		causes = this.clinicService.findAllCauses();
		result.addObject("causes", causes);
		Map<Integer, Double> map = new HashMap<Integer, Double>();

		for (Cause c : causes) {
			try {
				Double d = this.clinicService.findTotalBudgetAchievedByCauseId(c.getId());
				if (d == null) {
					map.put(c.getId(), 0.0);
				} else {
					map.put(c.getId(), d);
				}
			} catch (Throwable oops) {
				map.put(c.getId(), 0.0);
			}
		}
		result.addObject("map", map);
		return result;
	}

	// LIST FOR OWNER
	@RequestMapping(value = "/{ownerId}/list", method = RequestMethod.GET)
	public ModelAndView listOwner(@PathVariable("ownerId") Integer ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeList");

		Collection<Cause> causes = new ArrayList<Cause>();

		if (ownerId == 0) {
			causes = clinicService.findAllCauses();
		} else {
			causes = clinicService.findAllCausesByOwnerId(ownerId);
		}
		result.addObject("causes", causes);
		Map<Integer, Double> map = new HashMap<Integer, Double>();

		for (Cause c : causes) {
			try {
				Double d = this.clinicService.findTotalBudgetAchievedByCauseId(c.getId());
				if (d == null) {
					map.put(c.getId(), 0.0);
				} else {
					map.put(c.getId(), d);
				}
			} catch (Throwable oops) {
				map.put(c.getId(), 0.0);
			}
		}
		result.addObject("map", map);
		return result;
	}

	//CREATE
	@RequestMapping(value = "{ownerId}/create", method = RequestMethod.GET)
	public ModelAndView create(@PathVariable("ownerId") Integer ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeEdit");
		Cause c = new Cause();
		c.setId(0);

		result.addObject("cause", c);
		result.addObject("requestURI", "/cause/" + ownerId + "/edit/" + 0);
		return result;
	}
	
	//GET edit
	@RequestMapping(value = "{ownerId}/edit/{causeId}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("causeId") int causeId, @PathVariable("ownerId") int ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeEdit");

		result.addObject("cause", clinicService.findCauseById(causeId));
		result.addObject("requestURI", "/cause/" + ownerId + "/edit/" + causeId);
		return result;
	}

	//POST edit
	@RequestMapping(value = "{ownerId}/edit/{causeId}", method = RequestMethod.POST)
	public ModelAndView save(@PathVariable("ownerId") Integer ownerId, @PathVariable("causeId") Integer causeId,
			Cause cause, BindingResult binding) {

		ModelAndView result;
		if (cause.getBudgetTarget() == null || cause.getDescription()== "" || cause.getName()=="" || cause.getOrganization()==""){
			return this.create(ownerId);
		}
		
		cause.setOwner(this.clinicService.findOwnerById(ownerId));
		

		if(causeId!=0){
			cause.setId(causeId);
		}
		if (binding.hasErrors()) {
			result = new ModelAndView("cause/causeEdit");
			result.addObject("cause", cause);
		} else {
			if (causeId == 0) {
				//cause.setOwner(this.clinicService.findOwnerById(ownerId));
				this.clinicService.saveCause(cause);
			} else {
				this.clinicService.saveCause(cause);
			}

			result = new ModelAndView("redirect:/cause/" + ownerId + "/list");
		}
		return result;
	}

}
