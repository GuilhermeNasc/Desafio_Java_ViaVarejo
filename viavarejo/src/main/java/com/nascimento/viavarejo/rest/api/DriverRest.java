package com.nascimento.viavarejo.rest.api;

import java.util.Collection;
import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Driver;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;
import com.nascimento.viavarejo.rest.service.DriverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Drivers.", tags = { "driver" })
@RestController
@RequestMapping(value = "/api")
public class DriverRest {

    @Autowired
    DriverService service;

    @ApiOperation(value = "Get a driver", notes = "Id should be valid, or else will return 404")
    @RequestMapping(method = RequestMethod.GET, value = "/driver/{id}")
    public Driver getDriverById(@PathVariable String id) throws NotFoundException {
        Optional<Driver> client = service.getDriver(id);
        if (!client.isPresent()) {
            throw new NotFoundException();
        }
        return client.get();
    }

    @ApiOperation(value = "List all drivers")
    @RequestMapping(method = RequestMethod.GET, value = "/driver")
    public Collection<Driver> getDrivers() {
        return service.getDrivers();
    }

    @ApiOperation(value = "Create a driver", notes = "Must have name, city, state, valid and unique CPF and Id should not send, it'll be generated server side")
    @RequestMapping(method = RequestMethod.POST, value = "/driver", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Driver createDriver(@RequestBody Driver driver) throws Exception {
        return service.createDriver(driver);
    }

    @ApiOperation(value = "Update a driver", notes = "Id should be valid, or else will return 404")
    @RequestMapping(method = RequestMethod.PUT, value = "/driver/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Driver updateDriver(@PathVariable String id, @RequestBody Driver driver) throws Exception {
        return service.updateDriver(id, driver);
    }

    @ApiOperation(value = "Delete a driver", notes = "Non valid id will not send an error")
    @RequestMapping(method = RequestMethod.DELETE, value = "/driver/{id}")
    public void deleteDriver(@PathVariable String id) {
        service.deleteDriver(id);
    }
}
