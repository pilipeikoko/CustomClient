package org.bsuir.model;

import org.bsuir.util.CustomDate;

import java.io.Serializable;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String placeOfResidence;
    private CustomDate birthday;
    private CustomDate dateOfReceipt;
    private String doctorsFullName;
    private String conclusion;

    public Patient(String fullName, String placeOfResidence, CustomDate birthday, CustomDate dateOfReceipt, String doctorsFullName, String conclusion) {
        this.fullName = fullName;
        this.placeOfResidence = placeOfResidence;
        this.birthday = birthday;
        this.dateOfReceipt = dateOfReceipt;
        this.doctorsFullName = doctorsFullName;
        this.conclusion = conclusion;
    }

    public Patient() {

    }

    public CustomDate getBirthday() {
        return birthday;
    }

    public CustomDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String getDoctorsFullName() {
        return doctorsFullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }


    public void setBirthday(CustomDate birthday) {
        this.birthday = birthday;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setDateOfReceipt(CustomDate dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public void setDoctorsFullName(String doctorsFullName) {
        this.doctorsFullName = doctorsFullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }
}
