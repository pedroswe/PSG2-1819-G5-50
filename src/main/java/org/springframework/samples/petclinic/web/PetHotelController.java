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

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetHotel;
import org.springframework.samples.petclinic.service.PetHotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller used to showcase what happens when an exception is thrown
 *
 * @author Michael Isvy
 *         <p/>
 *         Also see how the bean of type 'SimpleMappingExceptionResolver' has been declared inside
 *         /WEB-INF/mvc-core-config.xml
 */
@Controller
@RequestMapping("/pethotel")
public class PetHotelController {

    private static final String VIEWS_PET_HOTELS_LIST = "pethotel/list"; 
       
    private PetHotelService petHotelService;

	@Autowired
	public PetHotelController(PetHotelService petHotelService) {
		this.petHotelService = petHotelService;
	}

    @RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		// Collection<PetHotel> petHotels = petHotelService.findAll();
		// model.put("petHotels", petHotels);
		return VIEWS_PET_HOTELS_LIST;
	}


}
