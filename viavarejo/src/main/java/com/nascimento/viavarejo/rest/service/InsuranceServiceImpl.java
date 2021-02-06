package com.nascimento.viavarejo.rest.service;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.nascimento.viavarejo.rest.domain.Insurance;
import com.nascimento.viavarejo.rest.domain.InsuranceConsult;
import com.nascimento.viavarejo.rest.domain.error.InvalidDataException;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;
import com.nascimento.viavarejo.rest.repository.DriverRepository;
import com.nascimento.viavarejo.rest.repository.InsuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceRepository repository;

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Insurance createInsurance(Insurance insurance) throws InvalidDataException {
        if (!validateInsurance(insurance) || insurance.getNumber() != null) {
            throw new InvalidDataException();
        }

        if (!driverRepository.findById(insurance.getDriverId()).isPresent()) {
            throw new InvalidDataException();
        }

        while (true) {
            String number = String.format("%05d", new Random().nextInt(99999));
            Optional<Insurance> byNumber = repository.findByNumber(number);
            if (!byNumber.isPresent()) {
                insurance.setNumber(number);
                break;
            }
        }

        return repository.insert(insurance);
    }

    @Override
    public Insurance updateInsurance(String id, Insurance insurance) throws NotFoundException, InvalidDataException {
        if (!validateInsurance(insurance) || insurance.getNumber() == null || insurance.getNumber().isEmpty()) {
            throw new InvalidDataException();
        }

        Optional<Insurance> optInsurance = repository.findById(id);

        if (!optInsurance.isPresent()) {
            throw new NotFoundException();
        }

        if (!driverRepository.findById(insurance.getDriverId()).isPresent()) {
            throw new InvalidDataException();
        }

        insurance.setId(optInsurance.get().getId());

        return repository.save(insurance);
    }

    @Override
    public void deleteInsurance(String id) {
        repository.deleteById(id);
    }

    @Override
    public Collection<Insurance> getInsurances() {
        return repository.findAll();
    }

    @Override
    public Optional<Insurance> getInsurance(String id) {
        return repository.findById(id);
    }

    public Optional<Insurance> getInsuranceByNumber(String number) {
        return repository.findByNumber(number);
    }

    @Override
    public InsuranceConsult getInsuranceData(String number) throws NotFoundException {
        Optional<Insurance> insuranceByNumber = getInsuranceByNumber(number);
        if (!insuranceByNumber.isPresent()) {
            throw new NotFoundException();
        }

        Insurance insurance = insuranceByNumber.get();

        LocalDate today = LocalDate.now();
        if (today.isAfter(insurance.getEndDate())) {
            long expiredDays = ChronoUnit.DAYS.between(insurance.getEndDate(), today);
            return new InsuranceConsult("vencido", expiredDays, insurance);
        } else {
            long expiredDays = ChronoUnit.DAYS.between(today, insurance.getEndDate());
            return new InsuranceConsult("válido", expiredDays, insurance);
        }
    }

    private boolean validateInsurance(Insurance insurance) {
        return (insurance.getDriverId().isEmpty() || insurance.getStartDate() == null || insurance.getEndDate() == null
                || insurance.getValue() != 0 || insurance.getVehiclePlate().isEmpty());
    }
}
