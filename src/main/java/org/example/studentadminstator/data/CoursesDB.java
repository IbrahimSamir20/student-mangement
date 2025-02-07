package org.example.studentadminstator.data;

import java.util.ArrayList;
import java.util.List;

public class CoursesDB<T> {
    private final ArrayList<Course> coursesDB = new ArrayList<>();

    public void createCourse(Course course) {
        coursesDB.add(course);
    }

    public void deleteCourse(String courseName) {
        coursesDB.removeIf(course -> course.getName().equalsIgnoreCase(courseName));
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(coursesDB);
    }

    public boolean updateCourseName(String oldName, String newName) {
        for (Course course : coursesDB) {
            if (course.getName().equalsIgnoreCase(oldName)) {
                course.setName(newName);
                return true;
            }
        }
        return false;
    }

    public Course findCourseByName(String courseName) {
        for (Course course : coursesDB) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    public Course getOneCourseByStudentName(String studentName,String courseName) {
        Course coursee = new Course("No Courses yest","");
        for (int i = 0; i < coursesDB.size(); i++) {
            if(coursesDB.get(i).getName().equalsIgnoreCase(courseName)){
                for (int j =0; j<coursesDB.get(i).getStudentsAtCourse().size();j++){
                    if(coursesDB.get(i).getStudentsAtCourse().get(j).getStudentName().equalsIgnoreCase(studentName)){
                        return coursesDB.get(i);
                    }
                }
            }

        }
        return coursee;
    }
    public void clearAllCourses() {
        coursesDB.clear();
    }
}
