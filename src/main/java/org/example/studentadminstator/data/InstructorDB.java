package org.example.studentadminstator.data;

import java.util.ArrayList;

public class InstructorDB<T> {
        
       private ArrayList<Instructor> instructorDB = new ArrayList<>();
        
       public void createInstructor(Instructor instructor){

                instructorDB.add(instructor);
       }

       public void updateInstructor(int index , Instructor instructor){
                instructorDB.set(index, instructor);
       }

       public void deleteInstructor(int index){
                instructorDB.remove(index);
       }

       public ArrayList<Instructor> 



}
