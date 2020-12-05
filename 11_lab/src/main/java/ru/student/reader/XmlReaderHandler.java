package ru.student.reader;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import ru.student.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlReaderHandler extends DefaultHandler {

    private static final String STUDENT = "student";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final Map<String, Boolean> fieldsMap = new HashMap<>();

    static {
        fieldsMap.put(FIRST_NAME, false);
        fieldsMap.put(LAST_NAME, false);
    }

    private List<Student> studentList;
    private StringBuilder data;
    private Student currentStudent;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase(STUDENT)) {
            currentStudent = new Student();
            if (studentList == null) {
                studentList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase(FIRST_NAME)) {
            fieldsMap.replace(FIRST_NAME, true);
        } else if (qName.equalsIgnoreCase(LAST_NAME)) {
            fieldsMap.replace(LAST_NAME, true);
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Boolean.TRUE.equals(fieldsMap.get(FIRST_NAME))) {
            currentStudent.setFirstName(data.toString());
            fieldsMap.replace(FIRST_NAME, false);
        } else if (Boolean.TRUE.equals(fieldsMap.get(LAST_NAME))) {
            currentStudent.setLastName(data.toString());
            fieldsMap.replace(LAST_NAME, false);
        }
        if (qName.equalsIgnoreCase(STUDENT)) {
            studentList.add(currentStudent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
