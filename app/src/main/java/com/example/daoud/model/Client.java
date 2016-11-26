package com.example.daoud.model;

import java.util.Date;

/**
 * Created by daoud on 06/02/2016.
 */
public class Client {
    int cin;
    String nomclient;
    String adresse;
    String telephone;

    public Client(int cin, String nomclient, String adresse, String telephone) {
        this.cin = cin;
        this.nomclient = nomclient;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Client() {
    }

    public  int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
