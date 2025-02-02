package org.example.studentadminstator.data;

public class Instructor extends User {
        String hi;
        String title;
                   
    public Instructor(String username, String password, String type) {
        super(username, password, type); 
        this.hi ="hi, " + username;
        this.title=type;

    }

    

}




