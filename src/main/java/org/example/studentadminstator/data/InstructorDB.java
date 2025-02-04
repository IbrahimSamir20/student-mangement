package org.example.studentadminstator.data;

import java.util.ArrayList;

public class InstructorDB<T> {
         Instructor oneInstructor=new Instructor("abdelrahman aql", "ibrahim",  "instructor");
       private final ArrayList<Instructor> instructorDB = new ArrayList<>();

       public InstructorDB() {
            createInstructor(oneInstructor);
                
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

    public ArrayList<Instructor> fetchInstructors() {
        return instructorDB;
    }

    public Instructor fetchOneInstructor(String username) {
        for (Instructor instructor : instructorDB) {
            if (instructor.getUsername().equals(username)) {
                return instructor;
            }
        }
        return null;
    }


//   public int getIndex (String username){
//           for(Instructor  instructor:instructorDB){
//
//               if(instructor.getUsername().equals(username)){
//                   return instructorDB.indexOf(instructor);
//               }
//
//           }
//    return -1;
//       }
       

      



}




