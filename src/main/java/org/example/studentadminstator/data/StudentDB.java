package org.example.studentadminstator.data;

import java.util.ArrayList;

public class StudentDB<T> {
       private final ArrayList<Student> studentDB = new ArrayList<>();

       public void createStudent(Student student){
                studentDB.add(student);
       }

       public void updateStudent(int index, Student student) {
                studentDB.set(index, student);
       }

       public void updateStudentWithoutIndex(Student student) {
        for (int i = 0; i < studentDB.size(); i++) {
             if (studentDB.get(i).getUsername().equals(student.getUsername())) {
                    studentDB.set(i, student);
                    return;
             }
        }
        System.err.println("Student not found for update: " + student.getUsername());
    }

       public void deleteStudent(Student student){
           for(int i=0;i< studentDB.size();i++){
               if(studentDB.get(i).getName().equals(student.getName())){
                   studentDB.remove(student);
               }
           }
       }

       public ArrayList<Student> fetchStudent(){
        return studentDB;
       }

       public Student fetchOneStudent (String username){
        for(Student student:studentDB){
            if(student.getUsername().equals(username)){
                return student;
            }
        }
        System.err.println("Student not found " + username) ;
        return null;
       }

}
