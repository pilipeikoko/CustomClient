package org.bsuir.parser;

import org.bsuir.model.Patient;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PatientsXMLReader extends DefaultHandler {
    private final PatientsHandler handler;
    private final SAXParser parser;
    private final File file;

    public PatientsXMLReader(File file) throws ParserConfigurationException, SAXException {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();

        parser = factory.newSAXParser();

        handler = new PatientsHandler();
    }

    public List<Patient> readAll() throws IOException, SAXException,IllegalArgumentException {

        parser.parse(file, handler);

        return handler.getPatients();
    }
}