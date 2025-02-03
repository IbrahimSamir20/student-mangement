package org.example.studentadminstator.data;

import java.util.ArrayList;

public class CoursesDB<T> {
//        private Course course;
       ArrayList<Course> coursesDB = new ArrayList<>();

//        public CoursesDB(Course course) {
//                this.course = course;
//        }

        public void createCourse(Course course) {
                coursesDB.add(course);
        }

        public void updateCourse(Course newCourse, int index) {
                coursesDB.set(index, newCourse);
        }

        public void deleteCourse(int index) {
                coursesDB.remove(index);
        }

        public ArrayList<Course> fetch(){
                return coursesDB;
        }
}
