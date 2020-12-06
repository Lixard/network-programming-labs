package ru.student.reader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.student.model.StudentWrapper;

import java.io.File;

import static ru.student.Main.XML_FILE_PATH;

public class XmlReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlReader.class);

    public void readFromFile() {
        try {
            final var file = new File(XML_FILE_PATH);
            final var jaxbContext = JAXBContext.newInstance(StudentWrapper.class);
            final var unmarshaller = jaxbContext.createUnmarshaller();
            final var studentWrapper = (StudentWrapper) unmarshaller.unmarshal(file);
            LOGGER.info("Successfully read from file");
            studentWrapper.getStudents().forEach(s -> LOGGER.info(s.toString()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
