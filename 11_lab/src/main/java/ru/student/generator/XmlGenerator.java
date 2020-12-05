package ru.student.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.student.model.Student;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

import static ru.student.Main.XML_FILE_PATH;

public class XmlGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGenerator.class);

    public void createFileFromStudents(List<Student> students) {
        try {
            final var docFactory = DocumentBuilderFactory.newInstance();
            final var docBuilder = docFactory.newDocumentBuilder();

            final var doc = docBuilder.newDocument();
            final var rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            for (var student : students) {
                LOGGER.info("Student to XML file: {}", student);
                rootElement.appendChild(createElement(doc, student));
            }

            final var transformerFactory = TransformerFactory.newInstance();
            final var transformer = transformerFactory.newTransformer();

            final var domSource = new DOMSource(doc);
            final var streamResult = new StreamResult(new File(XML_FILE_PATH));
            transformer.transform(domSource, streamResult);

            LOGGER.info("Xml file created");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private Element createElement(Document doc, Student student) {
        final var studentElement = doc.createElement("student");

        final var firstNameElement = doc.createElement("firstname");
        firstNameElement.appendChild(doc.createTextNode(student.getFirstName()));

        final var lastNameElement = doc.createElement("lastname");
        lastNameElement.appendChild(doc.createTextNode(student.getLastName()));

        studentElement.appendChild(firstNameElement);
        studentElement.appendChild(lastNameElement);

        return studentElement;
    }
}
