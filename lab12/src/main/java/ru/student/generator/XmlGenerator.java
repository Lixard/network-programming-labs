package ru.student.generator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.student.model.Student;
import ru.student.model.StudentWrapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static ru.student.Main.XML_FILE_PATH;

public class XmlGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGenerator.class);

    public void generateFileFromList(List<Student> students) {
        try {
            final var jaxbContext = JAXBContext.newInstance(StudentWrapper.class);
            final var marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            final var studentWrapper = new StudentWrapper();
            studentWrapper.setStudents(students);
            final var file = new File(XML_FILE_PATH);
            if (file.createNewFile()) {
                LOGGER.info("File created: {}", file);
            }
            marshaller.marshal(studentWrapper, new FileOutputStream(XML_FILE_PATH, false));
            LOGGER.info("XML data writed to file: {}", file);

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
