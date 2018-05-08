package com.rfboernehave.demo.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;


public class Barn {

    private int id;
    private String fornavn;
    private String efternavn;
    private String cpr;
    private int alder;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date indmeldelsesdato;

    public Barn() {
    }

    public Barn(int id, String fornavn, String efternavn, int alder, String cpr, Date date) {
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
        this.cpr = cpr;
        this.indmeldelsesdato = date;

    }

    public Barn(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public Date getIndmeldelsesdato() {
        return indmeldelsesdato;
    }

    public void setIndmeldelsesdato(Date indmeldelsesdato) {
        this.indmeldelsesdato = indmeldelsesdato;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }
}