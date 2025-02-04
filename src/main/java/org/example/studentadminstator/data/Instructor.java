package org.example.studentadminstator.data;

public class Instructor extends User {
       private String name;
       private String grade ;
              
    public Instructor(String username, String password, String type) {
        super(username, password, type); 
        this.name=username;

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}




