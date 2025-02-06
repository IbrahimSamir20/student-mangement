package org.example.studentadminstator.components;

public class Test {
    String username;
    String password;
    public Test(String username, String password){
        this.username=username;
        this.password=password;
    }

    public void print (){
        System.out.println("username is "+ username + "password is " + password);
    }

}
