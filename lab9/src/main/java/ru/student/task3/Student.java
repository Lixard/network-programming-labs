package ru.student.task3;


import java.math.BigDecimal;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String surname;

    private double avgGrade;

    private int age;

    private Student() {
    }

    @Override
    public int compareTo(Student o) {
        return BigDecimal.valueOf(this.avgGrade).compareTo(BigDecimal.valueOf(o.avgGrade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(student.avgGrade, avgGrade) == 0 &&
                age == student.age &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, avgGrade, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", age=" + age +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        private final Student entity;

        public Builder() {
            this.entity = new Student();
        }

        public Builder withSurname(String surname) {
            entity.surname = surname;
            return this;
        }

        public Builder withAvgGrade(double avgGrade) {
            entity.avgGrade = avgGrade;
            return this;
        }

        public Builder withAge(int age) {
            entity.age = age;
            return this;
        }

        public Student build() {
            return entity;
        }

    }
}
