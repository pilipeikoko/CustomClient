package org.bsuir.parser;

import org.bsuir.util.CustomDate;
import org.bsuir.model.Patient;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PatientsHandler extends DefaultHandler {

    private List<Patient> patients;
    private Patient patient;
    private String currentElement;
    private Boolean isPatient;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        if (qName.equals("patients")) {
            patients = new ArrayList<>();
        }

        if (qName.equals("patient")) {
            patient = new Patient();
            isPatient = true;
        }

        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("patient")) {
            patients.add(patient);
            isPatient = false;
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        try {
            if (currentElement.equals("fullName") && isPatient) {
                patient.setFullName(text(ch, start, length));
            }

            if (currentElement.equals("address") && isPatient) {
                patient.setPlaceOfResidence(text(ch, start, length));
            }

            if (currentElement.equals("birthday") && isPatient) {
                patient.setBirthday(new CustomDate(text(ch, start, length)));
            }

            if (currentElement.equals("receiptDate") && isPatient) {
                patient.setDateOfReceipt(new CustomDate(text(ch, start, length)));
            }

            if (currentElement.equals("doctorsFullName") && isPatient) {
                patient.setDoctorsFullName(text(ch, start, length));
            }

            if (currentElement.equals("conclusion") && isPatient) {
                patient.setConclusion(text(ch, start, length));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
