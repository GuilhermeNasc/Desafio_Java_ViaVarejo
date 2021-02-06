package com.nascimento.viavarejo.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nascimento.viavarejo.rest.service.utils.CpfUtils;

import org.junit.jupiter.api.Test;

public class CpfUtilsTests {
    
    @Test
    public void invalidCPF(){
        assertFalse(CpfUtils.validateCpf("000.000.000-00"));
        assertFalse(CpfUtils.validateCpf("000.000.000-99"));
        assertFalse(CpfUtils.validateCpf("000.000-99"));
        assertFalse(CpfUtils.validateCpf("00000000000"));
        assertFalse(CpfUtils.validateCpf("00000000099"));
        assertFalse(CpfUtils.validateCpf("00000099"));
    }

    @Test
    public void validCPF(){
        assertTrue(CpfUtils.validateCpf("000.000.002-72"));
        assertTrue(CpfUtils.validateCpf("00000000272"));
    }
}
