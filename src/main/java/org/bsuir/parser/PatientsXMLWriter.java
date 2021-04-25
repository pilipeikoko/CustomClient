package org.bsuir.parser;

import org.bsuir.model.Patient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PatientsXMLWriter {
    private final File file;
    private static final String DEFAULT_STRUCTURE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<patients>\n</patients>";

    public PatientsXMLWriter(File file) throws IOException {

        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(DEFAULT_STRUCTURE);
        fileWriter.close();
        this.file = file;

    }

    public void writeAll(List<Patient> patients) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();
        Node patientTag = document.getElementsByTagName("patients").item(0);
        removeAll(document, Node.ELEMENT_NODE, "patient");


        for (Patient patient : patients) {
            Element patientElement = document.createElement("patient");
            patientTag.appendChild(patientElement);

            Element patientFullName = document.createElement("fullName");
            patientFullName.appendChild(document.createTextNode(patient.getFullName()));
            patientElement.appendChild(patientFullName);

            Element patientAddress = document.createElement("address");
            patientAddress.appendChild(document.createTextNode(patient.getPlaceOfResidence()));
            patientElement.appendChild(patientAddress);

            Element patientBirthday = document.createElement("birthday");

            patientBirthday.appendChild(document.createTextNode(patient.getBirthday().toString()));
            patientElement.appendChild(patientBirthday);

            Element patientReceiptDate = document.createElement("receiptDate");

            patientReceiptDate.appendChild(document.createTextNode(patient.getBirthday().toString()));
            patientElement.appendChild(patientReceiptDate);

            Element patientsDoctorsFullName = document.createElement("doctorsFullName");
            patientsDoctorsFullName.appendChild(document.createTextNode(patient.getDoctorsFullName()));
            patientElement.appendChild(patientsDoctorsFullName);

            Element patientsConclusion = document.createElement("conclusion");
            patientsConclusion.appendChild(document.createTextNode(patient.getConclusion()));
            patientElement.appendChild(patientsConclusion);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        transformer.transform(domSource, streamResult);
    }


    private void removeAll(Node node, short nodeType, String name) {
        if (node.getNodeType() == nodeType && (name == null || node.getNodeName().equals(name))) {
            node.getParentNode().removeChild(node);
        } else {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                removeAll(list.item(i), nodeType, name);
            }
        }
    }


}
