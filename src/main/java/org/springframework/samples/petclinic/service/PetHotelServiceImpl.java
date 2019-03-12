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
package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetHotel;
import org.springframework.samples.petclinic.repository.PetHotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class PetHotelServiceImpl implements PetHotelService {
    
    private PetHotelRepository petHotelRepository;

    @Autowired
    public PetHotelServiceImpl(PetHotelRepository petHotelRepository) {
        this.petHotelRepository = petHotelRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PetHotel> findAll() throws DataAccessException {
        return petHotelRepository.findAll();
    }

    @Override
    @Transactional
    public void save(PetHotel petHotel) throws DataAccessException {
        petHotelRepository.save(petHotel);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
