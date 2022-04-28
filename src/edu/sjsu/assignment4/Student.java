package edu.sjsu.assignment4;

import java.util.Objects;

public class Student {
    private String name;
    private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Student(int id) {
        this(id,"Unnamed");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.id + "." + this.name + ": ";
    }

}
