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


import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.repository.DonationRepository;

/**
 * Spring Data JPA specialization of the {@link DonationRepository} interface
 *
 * @author Michael Isvy
 * @since 15.1.2013
 */
public interface SpringDataDonationRepository extends DonationRepository, Repository<Donation, Integer> {


  /* @Override
    @Query("SELECT d FROM Donation d WHERE d.id =:id")
    Donation findById(@Param("id") int id);

    @Override
    @Query("SELECT sum(d.amount) from Donation d WHERE d.cause.id = ?1")
    Collection<Donation> findAll() throws DataAccessException; */

    @Override
    @Query("SELECT sum(d.amount)*1.0 from Donation d WHERE d.cause.id = ?1")
    Double findTotalBudgetAchievedByCauseId(int causeId) throws DataAccessException;
    
    @Query("SELECT d from Donation d WHERE d.cause.id = ?1")
    Collection<Donation> findDonationByCause(int causeId) throws DataAccessException;
   
}
