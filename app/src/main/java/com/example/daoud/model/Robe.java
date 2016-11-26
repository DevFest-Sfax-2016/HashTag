package com.example.daoud.model;

/**
 * Created by daoud on 06/02/2016.
 */
public class Robe {
    String numrobe;
    String designation;
    int prixtotal;

    public Robe(String numrobe, String designation, int prixtotal) {
        this.numrobe = numrobe;
        this.designation = designation;
        this.prixtotal = prixtotal;
    }

    public Robe() {
    }

    public String getNumrobe() {
        return numrobe;
    }

    public void setNumrobe(String numrobe) {
        this.numrobe = numrobe;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(int prixtotal) {
        this.prixtotal = prixtotal;
    }
}
