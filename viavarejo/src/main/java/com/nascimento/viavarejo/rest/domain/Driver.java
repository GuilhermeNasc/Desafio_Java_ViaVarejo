package com.nascimento.viavarejo.rest.domain;

import org.springframework.data.annotation.Id;

public class Driver {
    @Id
    private String id;

    private String name;
    private String cpf;
    private String city;
    private String state;

    public Driver() {
    }

    public Driver(String name, String cpf, String city, String state) {
        this.name = name;
        this.cpf = cpf;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
