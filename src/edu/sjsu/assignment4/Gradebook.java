package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook extends HashMap<Student, Character> {

    public boolean addStudent(Student student, char grade){
        // if student isn't already in the HashMap, then add it and return true
        if (!this.containsKey(student)){
            // If the grade is not valid, set it to N and add the student with a grade N.
            if(!validateGrade(grade)){
                grade = 'N';
            }
            this.put(student,grade);
            return true;
        }
        else return false;

    }
    public boolean addStudent(Student student){
        if(this.containsKey(student)) return false;
        this.addStudent(student, 'N');
        return true;
    }
    private Student getStudent(HashMap<Student, Character> map, int id){
        Set<Student> keys = map.keySet();
        for (Student student: keys){
            if(student.getId() == id) return student;
        }
        return new Student(id);
    }
    public boolean deleteStudent(int id){
        // if the student isn't found return false
        if (!this.containsKey(getStudent(this,id))) return false;
        //remove student
        this.remove(getStudent(this, id));
        return true;
    }
    public boolean updateStudent(int id, String newName){
        // return false if the student doesn't exist in the map
        if (!this.containsKey(getStudent(this, id))) return false;
        // Save the student's grade
        char currentStudentGrade = this.get(getStudent(this,id));
        //Remove the student from the map
        this.remove(getStudent(this,id));
        //Create a new student with the updated name, but same id
        Student updatedStudent = new Student(id,newName);
        //Reinsert the student with the updated name and same id to the map
        this.put(updatedStudent,currentStudentGrade);
        return true;
    }
    public static boolean validateGrade(char grade){
        return grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F' || grade == 'N';
    }
    public boolean updateGrade(int id, char newGrade){
        // check if the student exists in the map
        if (!this.containsKey(getStudent(this, id))) return false;
        //Make sure the grade is valid format
        if(!validateGrade(newGrade)) return false;
        this.put(getStudent(this,id), newGrade);
        return true;
    }

    public void printGrades(Comparator<Student> comparator){
        //Sort the Map according to the comparator
        TreeMap<Student,Character> sorted = new TreeMap<>(comparator);
        sorted.putAll(this);
        for (Map.Entry<Student, Character> entry: sorted.entrySet()){
            System.out.println(entry.getKey().toString() + entry.getValue());
        }

    }



}
