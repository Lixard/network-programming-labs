package ru.student.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

import static ru.student.Main.XML_FILE_PATH;

public class XmlReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlReader.class);

    public void readFromFile() {
        final var saxParserFactory = SAXParserFactory.newInstance();
        try {
            final var saxParser = saxParserFactory.newSAXParser();
            final var xmlReaderHandler = new XmlReaderHandler();
            saxParser.parse(new File(XML_FILE_PATH), xmlReaderHandler);

            xmlReaderHandler.getStudentList().forEach(s -> LOGGER.info(s.toString()));

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
