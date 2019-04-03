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
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.CauseRepository;
import org.springframework.samples.petclinic.repository.DonationRepository;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.SpecialtyRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ClinicServiceImpl implements ClinicService {

    private PetRepository petRepository;
    private VetRepository vetRepository;
    private OwnerRepository ownerRepository;
    private VisitRepository visitRepository;
    private SpecialtyRepository specialtyRepository;
    private CauseRepository causeRepository;
    private DonationRepository donationRepository;

    @Autowired
    public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitRepository visitRepository, SpecialtyRepository specialtyRepository, CauseRepository causeRepository, DonationRepository donationRepository) {
        this.petRepository = petRepository;
        this.vetRepository = vetRepository;
        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
        this.specialtyRepository = specialtyRepository;
        this.causeRepository = causeRepository;
        this.donationRepository = donationRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return petRepository.findPetTypes();
    }

	@Override
	@Transactional(readOnly = true)
	public Owner findOwnerById(int id) throws DataAccessException {
		return ownerRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	@Transactional
	public void saveOwner(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Override
	@Transactional
	public void saveVisit(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Override
	@Transactional(readOnly = true)
	public Pet findPetById(int id) throws DataAccessException {
		return petRepository.findById(id);
	}

	@Override
	@Transactional
	public void savePet(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Vet> findVets() throws DataAccessException {
		return vetRepository.findAll();
	}

    @Override
    @Transactional(readOnly = true)
	public Collection<Visit> findVisitsByPetId(int petId) {
		return visitRepository.findByPetId(petId);
	}

    @Override
    @Transactional(readOnly = true)
	public void deleteByIdPet(Integer id) {
		this.petRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
	public void deleteByIdVet(Integer id) {
		this.vetRepository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
	public void deleteOwnerById(Integer id) {
		this.ownerRepository.deleteById(id);
	}

    @Override
    @Transactional(readOnly = true)
    public Collection<Specialty> findSpecialtys() throws DataAccessException {
        return this.specialtyRepository.findAll();
    }
 
    @Override
    @Transactional(readOnly = true)
    public Vet findVetById(int id) throws DataAccessException {
        return vetRepository.findById(id);
    }
    
    @Override
    @Transactional
    public void saveSpecialty(Specialty specialty) throws DataAccessException{
        this.specialtyRepository.save(specialty);
    }
    @Override
    @Transactional(readOnly = true)
    public Collection<Pet> findAllPets(){
        return this.petRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Specialty findSpecialtyByName(String name) throws DataAccessException{
        return this.specialtyRepository.findByName(name);
    }
    
    @Override
    @Transactional(readOnly = true)
	public Collection<Cause> findAllCausesByOwnerId(Integer ownerId) {
		return this.causeRepository.findAllCausesByOwnerId(ownerId);
	}
    
    @Override
    @Transactional(readOnly = true)
	public Cause findCauseById(Integer id) {
		return this.causeRepository.findById(id);
	}

    @Override
    @Transactional(readOnly = true)
	public void saveCause(Cause cause) throws DataAccessException {
		this.causeRepository.save(cause);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Donation findDonationById(int id) throws DataAccessException{
        return this.donationRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
	public Collection<Donation> findAllDonations() throws DataAccessException{
        return this.donationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
	public Double findTotalBudgetAchievedByCauseId(int causeId) throws DataAccessException{
        return this.donationRepository.findTotalBudgetAchievedByCauseId(causeId);

    }

    @Override
    @Transactional(readOnly = true)
	public boolean saveDonation (Donation d) throws DataAccessException{
        return this.donationRepository.save(d);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Donation> findDonationsByCauseId(int causeId) throws DataAccessException{
        return this.donationRepository.findDonationsByCauseId(causeId);
    }

    @Override
    public void saveVet(Vet vet) throws DataAccessException {
        this.vetRepository.save(vet);
    }

    @Override
    public Collection<Cause> findAllCauses() throws DataAccessException {
        return this.causeRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findAllOwners() throws DataAccessException{
        return this.ownerRepository.findAll();
    }
}
