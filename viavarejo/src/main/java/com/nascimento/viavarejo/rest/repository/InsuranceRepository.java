package com.nascimento.viavarejo.rest.repository;

import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Insurance;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends MongoRepository<Insurance, String>{
    public Optional<Insurance> findByNumber(String number);
}
