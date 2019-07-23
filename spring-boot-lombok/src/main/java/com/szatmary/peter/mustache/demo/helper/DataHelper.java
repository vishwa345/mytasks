package com.szatmary.peter.mustache.demo.helper;

import com.szatmary.peter.mustache.demo.obj.Address;
import com.szatmary.peter.mustache.demo.obj.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nue on 24.6.2016.
 */
public class DataHelper {

    public static Student oneStudent() {
        return new Student("Student Adam", 21, new Address("address 1"));
    }

    public static List<Student> twoStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Student Adam", 21, new Address("address 1")));
        students.add(new Student("Student Anna", 31, new Address("address 2")));
        return students;
    }

    public static List<Student> noStudents() {
        return null;
    }

    public static List<Student> emptyList() {
        return new ArrayList<>();
    }

}
