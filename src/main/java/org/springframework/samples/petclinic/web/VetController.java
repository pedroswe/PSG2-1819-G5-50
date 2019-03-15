/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {

    private static final String VIEWS_VET_CREATE_OR_UPDATE_FORM = "vets/createOrUpdateVetForm";
    private static final String ADD_SPECIALTY = "vets/addSpecialty";
    private final ClinicService clinicService;
   

    @Autowired
    public VetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }
    // First option is to send all Specialties to the view by using this method
    @ModelAttribute("_specialities")
	public Collection<Specialty> populateSpecialtys() {
		return this.clinicService.findSpecialtys();
    }
  
    @InitBinder("vet")
	public void initVetBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
    }
/*
    @InitBinder("specialty")
	public void initSpecialtyBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new SpecialtyValidator());
	}
*/
    @RequestMapping(value = { "/vets.html", "/vets/list"})
    public String showVetList(Map<String, Object> model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects
        // so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        model.put("vets", vets);
        return "vets/vetList";
    }

    @RequestMapping(value = { "/vets.json", "/vets.xml"})
    public
    @ResponseBody
    Vets showResourcesVetList() {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects
        // so it is simpler for JSon/Object mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        return vets;
    }


    // CREATE (GET)
    @RequestMapping(value = "/vets/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        // Second option is to send all Specialties inside this controller
        //Collection<Specialty> _specialties = this.clinicService.findSpecialtys();
        Vet vet = new Vet();
        model.put("vet", vet);
        return VIEWS_VET_CREATE_OR_UPDATE_FORM;
    }
    
    // CREATE TO SAVE (POST)
    @RequestMapping(value = "/vets/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Vet vet, BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(vet.getFirstName()) && StringUtils.hasLength(vet.getLastName()) && vet.isNew() && vet.getFirstName().equals(vet.getLastName())) {
			result.rejectValue("firstName", "duplicate", "already exists");
		}
		if (result.hasErrors()) {
            model.put("vet", vet);
            //model.put("_specialties", vet.getSpecialties());
			return VIEWS_VET_CREATE_OR_UPDATE_FORM;
		} else {
            Vet res = (Vet) vet;
            this.clinicService.saveVet(res);
			return "redirect:/vets/list";//modificado
		}
	}
    
    // EDIT (GET) = UPDATE
    @RequestMapping(value = "/vets/{vetId}/edit", method = RequestMethod.GET)
	public String initUpdateForm(@PathVariable("vetId") int vetId, ModelMap model) {
		Vet vet = this.clinicService.findVetById(vetId);
        model.put("vet", vet);
        model.put("specialties", vet.getSpecialties());
		return VIEWS_VET_CREATE_OR_UPDATE_FORM;
	}
    // EDIT (POST) = UPDATE
	@RequestMapping(value = "/vets/{vetId}/edit", method = RequestMethod.POST)
	public String processUpdateForm(@PathVariable("vetId") int vetId, Vet vet, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            model.put("vet", vet);
			return VIEWS_VET_CREATE_OR_UPDATE_FORM;
		} else {
            Vet res = new Vet();
            if (vetId != 0){
                //actualiza: hace falta coger vetId porque vet.getId() no sirve
                res = this.clinicService.findVetById(vetId);
                res.setFirstName(vet.getFirstName());
                res.setLastName(vet.getLastName());
            }else{
                res.setFirstName(vet.getFirstName());
                res.setLastName(vet.getLastName());
                res.getSpecialties().addAll(new ArrayList<Specialty>());
            }
            this.clinicService.saveVet(res);
			return "redirect:/vets/list";
		}
	}

    // CREATE SPECIALTY (GET)
    @RequestMapping(value = "/vets/{vetId}/addSpecialty", method = RequestMethod.GET)
    public String addSpecialtyForm(@PathVariable("vetId") Integer vetId, ModelMap model) {
        Vet vet = this.clinicService.findVetById(vetId);
        Specialty specialty = new Specialty();
        model.put("vetId", vet.getId());
        model.put("specialty", specialty);
        return ADD_SPECIALTY;
    }

    // CREATE SPECIALTY TO SAVE (POST)
    @RequestMapping(value = "/vets/{vetId}/addSpecialty", method = RequestMethod.POST)
    public String processAddSpecialtyForm(Specialty specialty, BindingResult result, Integer vetId, ModelMap model){
        if (result.hasErrors()) {
            model.put("vetId", vetId);
            model.put("specialty", specialty);
			return ADD_SPECIALTY;
		} else {
            if (this.clinicService.findSpecialtyByName(specialty.getName()) == null ){
                this.clinicService.saveSpecialty(specialty);
                
            }else{
                
            }
                Specialty res = this.clinicService.findSpecialtyByName(specialty.getName());
                Vet vet = this.clinicService.findVetById(vetId);
                vet.addSpecialty(res);
                this.clinicService.saveVet(vet);
			return "redirect:/vets/list";
		}
    }

}
