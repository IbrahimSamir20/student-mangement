package org.example.studentadminstator.data;

public class Student extends User {
    private String name;
    private String gender;

    public Student(String username, String password, String type, String name) {
        super(username, password, type);
        this.name = name;
//        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getUserName() {
        return getUsername();
    }
    @Override
    public String toString() {
        return "Student{" +
                "username='" + getUsername() + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + getPassword() + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
