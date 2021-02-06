package com.nascimento.viavarejo.rest.service;

import java.util.Collection;
import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Driver;
import com.nascimento.viavarejo.rest.domain.error.CpfAlreadyUsedException;
import com.nascimento.viavarejo.rest.domain.error.InvalidCpfException;
import com.nascimento.viavarejo.rest.domain.error.InvalidDataException;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;

public interface DriverService {
    public abstract Driver createDriver(Driver driver) throws InvalidCpfException, CpfAlreadyUsedException, InvalidDataException;
    public abstract Driver updateDriver(String id, Driver driver) throws NotFoundException, InvalidDataException;
    public abstract void deleteDriver(String id);
    public abstract Collection<Driver> getDrivers();
    public abstract Optional<Driver> getDriver(String id);
}
