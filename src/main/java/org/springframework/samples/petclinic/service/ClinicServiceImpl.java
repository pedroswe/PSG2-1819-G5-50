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
	private CauseRepository causesRepository;
	private DonationRepository donationRepository;

	@Autowired
	public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository,
			VisitRepository visitRepository, SpecialtyRepository specialtyRepository, CauseRepository causeRepository) {
		this.petRepository = petRepository;
		this.vetRepository = vetRepository;
		this.ownerRepository = ownerRepository;
		this.visitRepository = visitRepository;
		this.specialtyRepository = specialtyRepository;
		this.causesRepository = causeRepository;
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
	@Transactional
	public Collection<Visit> findVisitsByPetId(int petId) {
		return visitRepository.findByPetId(petId);
	}

	@Transactional
	public void deleteByIdPet(Integer id) {
		this.petRepository.deleteById(id);
	}

	@Transactional
	public void deleteByIdVet(Integer id) {
		this.vetRepository.deleteById(id);
	}

	@Transactional
	public void deleteOwnerById(Integer id) {
		this.ownerRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void saveVet(Vet vet) throws DataAccessException {
		vetRepository.save(vet);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Specialty> findSpecialtys() throws DataAccessException {
		return specialtyRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vet findVetById(int id) throws DataAccessException {
		return vetRepository.findById(id);
	}

	@Override
	@Transactional
	public void saveSpecialty(Specialty specialty) throws DataAccessException {
		specialtyRepository.save(specialty);
	}

	public Collection<Pet> findAllPets() {
		return this.petRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Specialty findSpecialtyByName(String name) throws DataAccessException {
		return specialtyRepository.findByName(name);
	}

	@Override
	@Transactional
	public Collection<Cause> findAll(Integer ownerId) {
		return causesRepository.findAll(ownerId);
	}

	@Override
	@Transactional
	public Cause findOne(Integer id) {
		return causesRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(Cause cause) throws DataAccessException {
		this.causesRepository.save(cause);
	}

	@Override
	@Transactional
	public Collection<Cause> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return this.causesRepository.findAll();
	}

	@Override
	@Transactional
	public Double findTotalBudgetAchievedByCauseId(int causeId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.donationRepository.findTotalBudgetAchievedByCauseId(causeId);
	}

	@Override
	@Transactional
	public Collection<Donation> findDonationByCause(int causeId) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.donationRepository.findDonationByCause(causeId);
	}
}
