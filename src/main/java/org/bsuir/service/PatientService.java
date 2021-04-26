package org.bsuir.service;

import org.bsuir.exception.CustomClientException;
import org.bsuir.model.Patient;
import org.bsuir.util.CustomDate;

import java.util.List;

public interface PatientService {

    List<Patient> getPage(int amountOfPages, int amountOfPagesOnTheTable) throws CustomClientException;

    List<Patient> getPageByList(List<Patient> list, int amountOfPages, int amountOfPagesOnTheTable) throws CustomClientException;

    void addPatient(Patient professorToAdd) throws CustomClientException;

    int deletePatientByDate(CustomDate date) throws CustomClientException;

    int deletePatientByFullNameOrAddress(String fullName, String Address) throws CustomClientException;

    int deletePatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date) throws CustomClientException;

    List<Patient> searchPatientByDate(CustomDate date) throws CustomClientException;

    List<Patient> searchPatientByFullNameOrAddress(String fullName, String Address) throws CustomClientException;

    List<Patient> searchPatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date) throws CustomClientException;

    List<Patient> getAllPatients() throws CustomClientException;

    int getAmountOfPatients() throws CustomClientException;


    void readFromFile(String sourceFilePath) throws CustomClientException;

    void saveToFile(String targetFilePath) throws CustomClientException;
}
