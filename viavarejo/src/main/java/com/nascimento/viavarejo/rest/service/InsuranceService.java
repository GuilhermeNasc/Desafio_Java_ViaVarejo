package com.nascimento.viavarejo.rest.service;

import java.util.Collection;
import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Insurance;
import com.nascimento.viavarejo.rest.domain.InsuranceConsult;
import com.nascimento.viavarejo.rest.domain.error.InvalidDataException;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;

public interface InsuranceService {
    public abstract Insurance createInsurance(Insurance insurance) throws InvalidDataException;
    public abstract Insurance updateInsurance(String id, Insurance insurance) throws NotFoundException, InvalidDataException;
    public abstract void deleteInsurance(String id);
    public abstract Collection<Insurance> getInsurances();
    public abstract Optional<Insurance> getInsurance(String id);
    public abstract InsuranceConsult getInsuranceData(String number) throws NotFoundException;
}
