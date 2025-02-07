package org.example.studentadminstator.data;

public class Instructor extends User {
    private String name;

    public Instructor(String username, String password, String type) {
        super(username, password, type);
        this.name = username;
    }

    public String getInstructorName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUserName() {
        return super.getUsername();
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
