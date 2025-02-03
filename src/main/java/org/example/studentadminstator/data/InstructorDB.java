package org.example.studentadminstator.data;

import java.util.ArrayList;

public class InstructorDB<T> {
        Instructor oneInstructor=new Instructor("ibrahim", "doaa",  "instructor");
       private ArrayList<Instructor> instructorDB = new ArrayList<>();

       public InstructorDB() {
           instructorDB.add(oneInstructor);
                
        }

       public void createInstructor(Instructor instructor){
                instructorDB.add(instructor);
       }

       public void updateInstructor(int index , Instructor instructor){
                instructorDB.set(index, instructor);
       }

       public void deleteInstructor(int index){
                instructorDB.remove(index);
       }

       public ArrayList<Instructor> fetchInstructors(){
        return instructorDB;
       }

       public Instructor fetchOneInstructor (int index){
        return instructorDB.get(index);
       }



}
