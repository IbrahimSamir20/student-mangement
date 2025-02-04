package org.example.studentadminstator.data;

public class Student extends User {
        private String name;
        private String gender;
        public Student(String username, String password, String type) {
        super(username, password, type);
        this.name = username;
    }

    public String getName() {

            return name;
    }

    public void setName(String name) {

            this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
}
