package org.example.studentadminstator;

import org.example.studentadminstator.data.*;

public class AppData {
    private static final AppData instance = new AppData();
    private final StudentDB<Student> studentDB;
    //Reload
    private final InstructorDB<Instructor> instructorDB;
    private final CoursesDB<Course> coursesDB;
    private final UsersDB<User> usersDB;

    private AppData() {
        studentDB = new StudentDB<>();
        instructorDB = new InstructorDB<>();
        coursesDB = new CoursesDB<>();
        usersDB = new UsersDB<>();

        usersDB.createUser(new User("ibrahim", "abdelrahman", "Instructor") {
            @Override
            public String getUserName() {
                return "abdelrahman";
            }
        });

        usersDB.createUser(new User("ibrahim", "ibrahim", "Student"){
            @Override
            public String getUserName(){
                return "ibrahim";
            }
        });

        studentDB.createStudent(new Student("ibrahim", "ibrahim", "Student", "ibrahim") {
            @Override
            public String getUserName() {
                return "ibrahim";
            }
        });
        instructorDB.createInstructor(new Instructor("abdelrahman", "ibrahim", "Instructor")
                                      {
                                          @Override
                                          public String getUsername(){
                                              return "abdelrahman";
                                          }
                                      }
        );




        coursesDB.createCourse(new Course("SoftwareTesting", "ahim"));
        coursesDB.createCourse(new Course("AI", "ahim"));
        coursesDB.createCourse(new Course("Soft Skills", "ahim"));
        coursesDB.createCourse(new Course("Software", "ahim"));
        coursesDB.createCourse(new Course("Software", "ahim"));
        coursesDB.createCourse(new Course("Software", "ahim"));

    }

    public static AppData getInstance() {
        return instance;
    }

    public StudentDB<Student> getStudentDB() {
        return studentDB;
    }

    public InstructorDB<Instructor> getInstructorDB() {
        return instructorDB;
    }

    public CoursesDB<Course> getCoursesDB() {
        return coursesDB;
    }

    public UsersDB<User> getUsersDB() {
        return usersDB;
    }

}