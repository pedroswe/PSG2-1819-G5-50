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
package org.springframework.samples.petclinic.repository;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Donation;

import java.util.Collection;
/**
 * Repository class for <code>Donation</code> domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring Data See here:
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public interface DonationRepository {
    /**
     * Retrieve an <code>Donation</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Donation</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    Donation findById(int id) throws DataAccessException;

    /**
     * Retrieve all <code>Donation</code> from the data store.
     *
     * @return a <code>Collection</code> of <code>Donation</code>
     */
    Collection<Donation> findAll() throws DataAccessException;


    Double findTotalBudgetAchievedByCauseId(int causeId) throws DataAccessException;

    /**
     * Save a <code>Donation</code> to the data store, either inserting or updating it.
     *
     * @param d the <code>Donation</code> to save
     * @see BaseEntity#isNew
     */
    boolean save(Donation d) throws DataAccessException;

    Collection<Donation> findDonationsByCauseId(int id) throws DataAccessException;
}