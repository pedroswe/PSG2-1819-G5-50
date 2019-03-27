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
package org.springframework.samples.petclinic.repository.springdatajpa;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.PetHotel;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetHotelRepository;

/**
 * Spring Data JPA specialization of the {@link OwnerRepository} interface
 *
 * @author Michael Isvy
 * @since 15.1.2013
 */
public interface SpringDataPetHotelRepository extends PetHotelRepository, Repository<PetHotel,Integer> {

    @Override
    @Query("select count(p) from PetHotel p where p.pet.id=:petId and ((:initDate < p.initDate and :endDate > p.endDate) or (:initDate between p.initDate and p.endDate) or (:endDate between p.initDate and p.endDate))")
    Integer bookingCount(@Param("petId") int petId, @Param("initDate") LocalDate initDate, @Param("endDate") LocalDate endDate) throws DataAccessException;
}
