package org.bsuir.service;

import org.bsuir.exception.CustomClientException;
import org.bsuir.model.Patient;
import org.bsuir.util.CustomDate;

import java.util.List;

public interface PatientService {

    List<Patient> getPage(int amountOfPages, int amountOfPagesOnTheTable);

    List<Patient> getPageByList(List<Patient> list, int amountOfPages, int amountOfPagesOnTheTable);

    void addPatient(Patient professorToAdd) throws CustomClientException;

    int deletePatientByDate(CustomDate date);

    int deletePatientByFullNameOrAddress(String fullName, String Address);

    int deletePatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date);

    List<Patient> searchPatientByDate(CustomDate date);

    List<Patient> searchPatientByFullNameOrAddress(String fullName, String Address);

    List<Patient> searchPatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date);

    int getAmountOfPatients();


    void readFromFile(String sourceFilePath) throws CustomClientException;

    void saveToFile(String targetFilePath) throws CustomClientException;
}
