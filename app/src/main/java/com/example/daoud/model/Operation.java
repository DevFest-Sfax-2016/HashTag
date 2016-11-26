package com.example.daoud.model;

import java.util.Date;

/**
 * Created by daoud on 06/02/2016.
 */
public class Operation {
    String numoperation;
    int cin;
    String nomclient;
    String numrobe;
    int avance;
    String datedebut;

    public Operation(String numoperation, int cin, String nomclient, String numrobe, int avance, String datedebut) {
        this.numoperation = numoperation;
        this.cin = cin;
        this.nomclient = nomclient;
        this.numrobe = numrobe;
        this.avance = avance;
        this.datedebut = datedebut;
    }

    public Operation() {
    }

    public  String getNumoperation() {
        return numoperation;
    }

    public void setNumoperation(String numoperation) {
        this.numoperation = numoperation;
    }

    public int getCin() {
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

    public String getNumrobe() {
        return numrobe;
    }

    public void setNumrobe(String numrobe) {
        this.numrobe = numrobe;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }
}
