package org.example.studentadminstator.data;

import java.util.ArrayList;

public class StudentDB<T> {
       private ArrayList<Student> studentDB = new ArrayList<>();

       public void createStudent(Student student){
                studentDB.add(student);
       }

       public void updateStudent(int index, Student student) {
                studentDB.set(index, student);
       }

       public void deleteStudent(int index){
                studentDB.remove(index);
       }

       public ArrayList<Student> fetchStudent(){
        return studentDB;
       }

       public Student fetchOneStudent(int index){
        if (index >= 0 && index < studentDB.size()) {
            return studentDB.get(index);
        } else {
            System.out.println("User not found.");
            return null;
        }
       }

    public Integer getStudentIndex(String studentName) {
        for (Student student : studentDB) {
            if (student != null && student.getName() != null && student.getName().equals(studentName)) { // Check for null!
                return studentDB.indexOf(student);
            }
        }
        return -1;
    }

       
      
}
