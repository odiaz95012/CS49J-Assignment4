package edu.sjsu.assignment4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] employeesStrings = {"Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"};
        LinkedList<String> employees = new LinkedList<String>(Arrays.asList(employeesStrings));
        System.out.println("List of employees before downsize: " + employees);
        MyCollections.downsize(employees,3);
        System.out.println("List of employees after downsize: " + employees);

        System.out.println(MyCollections.isBalanced("System.out.println(list.get(0))"));
        System.out.println(MyCollections.isBalanced("[](3*5)^2"));
        System.out.println(MyCollections.isBalanced("[(2+3]*5)^2"));
        System.out.println(MyCollections.isBalanced("System.out.println(list.get(0)"));
        System.out.println(MyCollections.isBalanced("[(3*5)]^2]"));

        Gradebook gradebook = new Gradebook();
        Student s1 = new Student("Bob", 1);
        Student s2 = new Student("Alice", 2);
        gradebook.addStudent(s1, 'B');
        gradebook.addStudent(s2,'A');
        Student s3 = new Student("Jay", 3);
        gradebook.addStudent(s3);
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (!o1.equals(o2)) return o1.getId() - o2.getId();
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Student> comparator2 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        System.out.println("Print Map by ID order");
        gradebook.printGrades(comparator);
        System.out.println("Deleting a student");
        gradebook.deleteStudent(3);
        gradebook.printGrades(comparator);
        System.out.println("Updating student name");
        gradebook.updateStudent(1, "Jay");
        gradebook.printGrades(comparator);
        System.out.println("Updating student grade");
        gradebook.updateGrade(1,'C');
        gradebook.printGrades(comparator);
        System.out.println("New updated Map");
        gradebook.printGrades(comparator);



    }
}
