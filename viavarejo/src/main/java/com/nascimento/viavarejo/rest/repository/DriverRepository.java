package com.nascimento.viavarejo.rest.repository;

import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
    public Optional<Driver> findByCpf(String cpf);
}