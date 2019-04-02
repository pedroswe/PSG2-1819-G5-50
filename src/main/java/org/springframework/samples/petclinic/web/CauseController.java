package org.springframework.samples.petclinic.web;

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
@RequestMapping(value = "/cause/{ownerId}")
public class CauseController {

	@Autowired
	private ClinicService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("ownerId") Integer ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeList");

		result.addObject("causes", service.findAll(ownerId));

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@PathVariable("ownerId") Integer ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeEdit");
		Cause c = new Cause();
		c.setId(0);

		result.addObject("cause", c);
		result.addObject("requestURI", "../../cause/" + ownerId + "/edit/" + 0);
		return result;
	}

	@RequestMapping(value = "/edit/{causeId}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("causeId") int id, @PathVariable("ownerId") int ownerId) {

		ModelAndView result;

		result = new ModelAndView("cause/causeEdit");

		result.addObject("cause", service.findOne(id));
		result.addObject("requestURI", "../edit/" + id);
		return result;
	}

	@RequestMapping(value = "/edit/{causeId}", method = RequestMethod.POST)
	public ModelAndView save(@PathVariable("ownerId") Integer ownerId, @PathVariable("causeId") Integer causeId,
			Cause cause, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = new ModelAndView("cause/causeEdit");
			result.addObject("cause", cause);
		} else {
			if (causeId == 0) {
				cause.setOwner(this.service.findOwnerById(ownerId));
				this.service.save(cause);
			} else {
				Cause c = this.service.findOne(causeId);
				c.setName(cause.getName());
				c.setDescription(cause.getDescription());
				c.setBudgetTarget(c.getBudgetTarget());
				c.setOrganization(cause.getOrganization());
				this.service.save(c);
			}

			

			result = new ModelAndView("redirect:/cause/" + ownerId + "/list");
		}
		return result;
	}

}
