package org.bsuir.service.impl;

import org.bsuir.exception.CustomClientException;
import org.bsuir.request.*;
import org.bsuir.response.*;
import org.bsuir.util.CustomDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.bsuir.model.Patient;
import org.bsuir.service.PatientService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    private String serverAddress;
    private int serverPort;
    private Socket serverSocket;

    public PatientServiceImpl() {
        PropertiesConfiguration config = new PropertiesConfiguration();
        try {
            config.load("application.properties");
            this.serverPort = config.getInt("serverPort");
            this.serverAddress = config.getString("serverAddress");

            serverSocket = getConnection();
        } catch (ConfigurationException ex) {
            LOGGER.error("Unable to get configuration key `port`. Check application.properties file");
        }
    }

    private Socket getConnection() {
        try {
            return new Socket(this.serverAddress, this.serverPort);
        } catch (IOException exception) {
            LOGGER.error("Failure while connecting to server on " + serverAddress + ":" + serverPort);
            throw new RuntimeException("Unable to connect to server!");
        }
    }

    private ServerResponse sendAndGetResponse(ServerRequest serverRequest) throws CustomClientException {
        ObjectInputStream inputStream;
        ObjectOutputStream outputStream;

        LOGGER.info(serverRequest.getRequestType().toString());

        try {
            outputStream = new ObjectOutputStream(serverSocket.getOutputStream());
            inputStream = new ObjectInputStream(serverSocket.getInputStream());
        } catch (IOException exception) {
            LOGGER.error("Error while creating Object Stream!");
            exception.printStackTrace();
            return new ServerResponse();
        }

        try {
            outputStream.writeObject(serverRequest);

            Object obj = inputStream.readObject();
            ServerResponse serverResponse = (ServerResponse) obj;
            LOGGER.info(serverResponse.toString());
            return serverResponse;
        } catch (IOException exception) {
            LOGGER.error("Error while sending object");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error while receiving object");
        }
        throw new CustomClientException("Unable to get response");
    }

    private void addRequest(Patient patient) throws CustomClientException {
        ServerRequest addRequest = new AddRequest(patient);

        AddResponse addResponse = (AddResponse) sendAndGetResponse(addRequest);

        if (!addResponse.isAdded()) {
            throw new CustomClientException("Couldn't add");
        }

    }

    private List<Patient> getPageRequest(int currentPage, int amountOfPagesOnTheTable) throws CustomClientException {
        ServerRequest getPageRequest = new FindPage(currentPage, amountOfPagesOnTheTable);

        PageResponse pageResponse = (PageResponse) sendAndGetResponse(getPageRequest);

        return pageResponse.getListOfPatients();
    }

    private int deletePatientByDateRequest(CustomDate date) throws CustomClientException {
        ServerRequest deleteRequest = new DeleteByDate(date);

        DeleteResponse deleteResponse = (DeleteResponse) sendAndGetResponse(deleteRequest);

        return deleteResponse.getAmount();
    }

    private int deletePatientByFullNameOrAddressRequest(String fullName, String address) throws CustomClientException {

        ServerRequest deleteRequest = new DeleteByFullNameOrAddress(fullName, address);

        DeleteResponse deleteResponse = (DeleteResponse) sendAndGetResponse(deleteRequest);

        return deleteResponse.getAmount();
    }

    private int deletePatientByDoctorsFullNameOrReceiptDateRequest(String fullName, CustomDate date) throws CustomClientException {
        ServerRequest deleteRequest = new DeleteByDoctorsFullNameOrDate(fullName, date);

        DeleteResponse deleteResponse = (DeleteResponse) sendAndGetResponse(deleteRequest);

        return deleteResponse.getAmount();
    }

    private int getAmountOfPatientsRequest() throws CustomClientException {
        ServerRequest request = new GetAmountOfPatients();

        AmountResponse response = (AmountResponse) sendAndGetResponse(request);

        return response.getAmount();
    }


    private List<Patient> searchPatientByDateRequest(CustomDate date) throws CustomClientException {
        ServerRequest request = new SearchByDate(date);

        SearchResponse response = (SearchResponse) sendAndGetResponse(request);

        return response.getListOfPatients();
    }

    private List<Patient> searchPatientByFullNameOrAddressRequest(String fullName, String address) throws CustomClientException {
        ServerRequest request = new SearchByFullNameOrAddress(fullName, address);

        SearchResponse response = (SearchResponse) sendAndGetResponse(request);

        return response.getListOfPatients();
    }

    private List<Patient> searchPatientByDoctorsFullNameOrReceiptDateRequest(String fullName, CustomDate date) throws CustomClientException {
        ServerRequest request = new SearchByDoctorsFullNameOrDate(fullName, date);

        SearchResponse response = (SearchResponse) sendAndGetResponse(request);

        return response.getListOfPatients();
    }

    private void readFromFileRequest(String sourceFilePath) throws CustomClientException {
        ServerRequest request = new ReadFromFile(sourceFilePath);

        FileResponse response = (FileResponse) sendAndGetResponse(request);

        if (!response.isSuccess()) {
            throw new CustomClientException("Couldn't read from file");
        }
    }

    private void saveToFileRequest(String targetFilePath) throws CustomClientException {
        ServerRequest request = new SaveToFile(targetFilePath);

        FileResponse response = (FileResponse) sendAndGetResponse(request);

        if (!response.isSuccess()) {
            throw new CustomClientException("Couldn't save to file");
        }
    }

    private List<Patient> getPageByListRequest(List<Patient> list, int currentPage, int amountOfPagesOnTheTable) throws CustomClientException {
        ServerRequest getPageRequest = new FindPageByList(currentPage, amountOfPagesOnTheTable, list);

        PageResponse pageResponse = (PageResponse) sendAndGetResponse(getPageRequest);

        return pageResponse.getListOfPatients();
    }

    private List<Patient> getAllPatientsRequest() throws CustomClientException {
        ServerRequest getAllPatients = new GetAllPatients();

        SearchResponse searchResponse = (SearchResponse) sendAndGetResponse(getAllPatients);

        return searchResponse.getListOfPatients();

    }

    @Override
    public List<Patient> getPage(int amountOfPages, int amountOfPagesOnTheTable) throws CustomClientException {
        return getPageRequest(amountOfPages, amountOfPagesOnTheTable);
    }

    @Override
    public List<Patient> getPageByList(List<Patient> list, int amountOfPages, int amountOfPagesOnTheTable) throws CustomClientException {
        return getPageByListRequest(list, amountOfPages, amountOfPagesOnTheTable);
    }

    @Override
    public void addPatient(Patient professorToAdd) throws CustomClientException {
        addRequest(professorToAdd);
    }

    @Override
    public int deletePatientByDate(CustomDate date) throws CustomClientException {
        return deletePatientByDateRequest(date);
    }

    @Override
    public int deletePatientByFullNameOrAddress(String fullName, String address) throws CustomClientException {
        return deletePatientByFullNameOrAddressRequest(fullName, address);
    }

    @Override
    public int deletePatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date) throws CustomClientException {
        return deletePatientByDoctorsFullNameOrReceiptDateRequest(fullName, date);
    }

    @Override
    public List<Patient> searchPatientByDate(CustomDate date) throws CustomClientException {
        return searchPatientByDateRequest(date);
    }

    @Override
    public List<Patient> searchPatientByFullNameOrAddress(String fullName, String Address) throws CustomClientException {
        return searchPatientByFullNameOrAddressRequest(fullName, Address);
    }

    @Override
    public List<Patient> searchPatientByDoctorsFullNameOrReceiptDate(String fullName, CustomDate date) throws CustomClientException {
        return searchPatientByDoctorsFullNameOrReceiptDateRequest(fullName, date);
    }

    @Override
    public List<Patient> getAllPatients() throws CustomClientException {
        return getAllPatientsRequest();
    }

    @Override
    public int getAmountOfPatients() throws CustomClientException {
        return getAmountOfPatientsRequest();
    }

    @Override
    public void readFromFile(String sourceFilePath) throws CustomClientException {
        readFromFileRequest(sourceFilePath);
    }

    @Override
    public void saveToFile(String targetFilePath) throws CustomClientException {
        saveToFileRequest(targetFilePath);
    }
}
