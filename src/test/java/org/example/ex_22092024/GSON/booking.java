package org.example.ex_22092024.GSON;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

public class booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositepaid;
    private bookingdates bookingdates;


    public org.example.ex_22092024.GSON.bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(org.example.ex_22092024.GSON.bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getDepositepaid() {
        return depositepaid;
    }

    public void setDepositepaid(Boolean depositepaid) {
        this.depositepaid = depositepaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
    private String additionalneeds;
}
