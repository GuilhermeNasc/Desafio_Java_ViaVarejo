package com.nascimento.viavarejo.rest.api;

import java.util.Collection;
import java.util.Optional;

import com.nascimento.viavarejo.rest.domain.Insurance;
import com.nascimento.viavarejo.rest.domain.InsuranceConsult;
import com.nascimento.viavarejo.rest.domain.error.NotFoundException;
import com.nascimento.viavarejo.rest.service.InsuranceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class InsuranceRest {
    @Autowired
    InsuranceService service;

    @ApiOperation(value = "List all insurance")
    @RequestMapping(method = RequestMethod.GET, value = "/insurance")
    public Collection<Insurance> getInsurances() throws NotFoundException{
        return service.getInsurances();
    }

    @ApiOperation(value = "Get an insurance", notes = "Id should be valid, or else will return 404")
    @RequestMapping(method = RequestMethod.GET, value = "/insurance/{id}")
    public Insurance getInsuranceById(@PathVariable String id) throws NotFoundException{
        Optional<Insurance> client = service.getInsurance(id);
        if(!client.isPresent()){
            throw new NotFoundException();
        }
        return client.get();
    }

    @ApiOperation(value = "Create an insurance", notes = "Must have valid DriverID, startDate, endDate, value and vehicle plate. Id and Number should not send, it'll be generated server side")
    @RequestMapping(method = RequestMethod.POST, value = "/insurance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Insurance addInsurance(@RequestBody Insurance insurance) throws Exception {
        return service.createInsurance(insurance);
    }

    @ApiOperation(value = "Update an insurance", notes = "Must have id, number, DriverID, startDate, endDate, value and vehicle plate")
    @RequestMapping(method = RequestMethod.PUT, value = "/insurance/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Insurance updateInsurance(@PathVariable String id, @RequestBody Insurance insurance) throws Exception {
        return service.updateInsurance(id, insurance);
    }

    @ApiOperation(value = "Delete an insurance", notes = "Non valid id will not send an error")
    @RequestMapping(method = RequestMethod.DELETE, value = "/insurance/{id}")
    public void deletInsurance(@PathVariable String id) {
        service.deleteInsurance(id);
    }

    @ApiOperation(value = "Consult an insurance information", notes = "Must hava a valid number")
    @RequestMapping(method = RequestMethod.GET, value = "/consultInsurance/{number}")
    public InsuranceConsult getInsuranceDataByNumber(@PathVariable String number) throws NotFoundException{
        return service.getInsuranceData(number);
    }
}
