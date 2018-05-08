package com.rfboernehave.demo.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MinBruger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String brugernavn;
    private String adgangskode;
    private String rolle;
    private int id;

    public MinBruger() {
    }

    public MinBruger(int id, String brugernavn, String adgangskode, String rolle) {
        this.id = id;
        this.brugernavn = brugernavn;
        this.adgangskode = adgangskode;
        this.rolle = rolle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getAdgangskode() {
        return adgangskode;
    }

    public void setAdgangskode(String adgangskode) {
        this.adgangskode = adgangskode;
    }

    public String getRolle(){return rolle;}

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return "MinBruger{" +
                "id=" + id +
                ", brugernavn='" + brugernavn + '\'' +
                ", adgangskode='" + adgangskode + '\'' +
                ", rolle=" + rolle + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        MinBruger minBruger = (MinBruger) o;
//
//        if (id != null ? !id.equals(minBruger.id) : minBruger.id != null) return false;
//        if (brugernavn != null ? !brugernavn.equals(minBruger.brugernavn) : minBruger.brugernavn != null) return false;
//        if (adgangskode != null ? !adgangskode.equals(minBruger.adgangskode) : minBruger.adgangskode != null) return false;
//
//        return Arrays.equals(rolle, minBruger.rolle);
//    }

}
