package com.nascimento.viavarejo.rest.service;

import java.util.Collection;
import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Driver;
import com.nascimento.viavarejo.rest.domain.error.CpfAlreadyUsedException;
import com.nascimento.viavarejo.rest.domain.error.InvalidCpfException;
import com.nascimento.viavarejo.rest.domain.error.InvalidDataException;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;
import com.nascimento.viavarejo.rest.repository.DriverRepository;
import com.nascimento.viavarejo.rest.service.utils.CpfUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository repository;
	
	@Override
	public Driver createDriver(Driver driver) throws InvalidCpfException, CpfAlreadyUsedException, InvalidDataException {
		if (!CpfUtils.validateCpf(driver.getCpf())) {
			throw new InvalidCpfException();
		}
		if (repository.findByCpf(driver.getCpf()).isPresent()) {
			throw new CpfAlreadyUsedException();
		}
		if (!validateDriver(driver)){
			throw new InvalidDataException();
		}

		return repository.insert(driver);
	}

	@Override
	public Driver updateDriver(String id, Driver driver) throws NotFoundException, InvalidDataException {
		if (!validateDriver(driver)){
			throw new InvalidDataException();
		}

		Optional<Driver> optDriver = repository.findById(id);

		if (optDriver.isEmpty()) {
			throw new NotFoundException();
		}

		driver.setId(optDriver.get().getId());

		return repository.save(driver);
	}

	@Override
	public void deleteDriver(String id) {
		repository.deleteById(id);
	}

	@Override
	public Collection<Driver> getDrivers() {
		return repository.findAll();
	}

	@Override
	public Optional<Driver> getDriver(String id) {
		return repository.findById(id);
	}

	private boolean validateDriver(Driver driver){
		return !(driver.getName().isEmpty() || driver.getCity().isEmpty() || driver.getState().isEmpty());
	}
}
