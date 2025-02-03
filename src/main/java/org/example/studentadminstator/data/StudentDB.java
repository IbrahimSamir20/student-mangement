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

        return studentDB.get(index);
       }

       
      
}
