package com.nascimento.viavarejo.rest.domain;

public class InsuranceConsult {
    private String status;
    private Long expiredDays;
    private Long toExpireDays;
    private Insurance insurance;

    public InsuranceConsult(String status, long days, Insurance insurance) {
        this.status = status;

        if(status.equals("vencido")){
            this.expiredDays = days;
            this.toExpireDays = 0L;
        }else{
            this.toExpireDays = days;
            this.expiredDays = 0L;
        }
        
        this.insurance = insurance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getExpiredDays() {
        return expiredDays;
    }

    public void setExpiredDays(long expiredDays) {
        this.expiredDays = expiredDays;
    }

    public long getToExpireDays() {
        return toExpireDays;
    }

    public void setToExpireDays(long toExpireDays) {
        this.toExpireDays = toExpireDays;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
