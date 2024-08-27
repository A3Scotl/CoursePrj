/*
 * @ (#) CourseList.java 1.0 8/23/2024
 *
 * Copyright (c) 2024 IUH.All rights reserved
 */

package iuh.fit.se.ex3;

import java.util.*;

/*
 * @description
 * @author : Nguyen Truong An
 * @date : 8/23/2024
 * @version 1.0
 */
public class CourseList {
    private int count = 0;
    private Course[] courses = new Course[20];

    /**
     * Default Constructor.
     */
    public CourseList() {
        super();
    }
    /**
     * Constructor with a specified count.
     *
     * @param count the initial count of courses
     * @throws IllegalArgumentException if count is less than 0
     */
    public CourseList(int count) {
        if(count<0){
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[count];
    }
    /**
     * Constructor with a specified count and courses array.
     *
     * @param count  the initial count of courses
     * @param courses the initial courses array
     */
    public CourseList(int count, Course[] courses) {
        this.count = count;
        this.courses = courses;
    }
    /**
     * Gets the courses array.
     *
     * @return the courses array
     */
    public Course[] getCourses() {
        return courses;
    }
    /**
     * Sets the courses array.
     *
     * @param courses the new courses array
     */
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
    /**
     * Gets the count of courses.
     *
     * @return the count of courses
     */
    public int getCount() {
        return count;
    }
    /**
     * Sets the count of courses.
     *
     * @param count the new count of courses
     */
    public void setCount(int count) {
        this.count = count;
    }
    /**
     * Adds a new course to the list.
     *
     * @param course the new course to add
     * @return true if the course was added successfully, false otherwise
     */
    //Them course moi
    public boolean addCourse(Course course) {
         if (course == null) return false;
         if (isExist(course)) return false;
         if (count >= courses.length) return false;
         courses[count++] = course;
         return true;

    }
    /**
     * Checks if a course with the same ID already exists in the list.
     *
     * @param course the course to check
     * @return true if the course already exists, false otherwise
     */
    //Kiem tra id da ton tai hay chua
    private boolean isExist(Course course) {
        for(int i = 0;i< count;i++){
            if(courses[i].getId().equalsIgnoreCase(course.getId())){
                return true;
            }
        }
        return false;
    }
    /**
     * Removes a course from the list by ID.
     *
     * @param id the ID of the course to remove
     * @return true if the course was removed successfully, false otherwise
     */
    //Xoa course
    public boolean removeCourse(String id) {
        if (id == null) return false;
        for(int i = 0;i< count;i++){
            if(courses[i].getId().equalsIgnoreCase(id)){
                courses[i] = null;
            }
        }
        return true;


    }
    /**
     * Finds a course by ID.
     *
     * @param id the ID of the course to find
     * @return the course if found, null otherwise
     */
    //Tim 1 course theo ID
    public Course findCourseById(String id) {
        if (id == null) return null;
        for(int i = 0;i< count;i++){
            if(courses[i].getId().equalsIgnoreCase(id)){
                return courses[i];
            }
        }
        return null;
    }
    /**
     * Finds courses by department.
     *
     * @param department the department to search for
     * @return an array of courses that match the department
     */
    //Tim cac course theo deparment
    public Course[] findCourseByDepartment(String department) {
        Course[] results = new Course[count];
            for(int i = 0;i< count;i++){
                if(courses[i].getDepartment().equalsIgnoreCase(department)){
                    results[i] = courses[i];
                }
            }
       return results;
    }
    /**
     * Finds courses by title.
     *
     * @param tt the title to search for
     * @return an array of courses that match the title
     */
    //Tim cac course theo title tuong doi
    public Course[] findCourseByTitle(String tt) {
        Course[] results = new Course[count];
            for(int i = 0;i< count;i++){
                if(courses[i].getTitle().toLowerCase().contains(tt.toLowerCase())){
                    results[i] = courses[i];
                }
            }
        return results;
    }
    //Hoán vị
    public void swap(Course list[],int i,int j,Course temp)
    {
        temp=courses[i];
        courses[i]=courses[j];
        courses[j]=temp;
    }
    //Sap xep theo title
    public void sortCoursesByTitle(){
        Course temp = null;
        for (int i=0;i<count-1;i++)
            for (int j=i+1;j<count;j++)
                if(courses[i].getTitle().compareTo(courses[j].getTitle())>0)
                    swap(courses,i,j,temp);
    }
    //Tim cac course co credit lon nhat
    public Course[] findMaxCreditsCourse() {
        int max = 0;
        List<Course> maxCredits = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > max) {
                max = courses[i].getCredit();
                maxCredits.clear();
                maxCredits.add(courses[i]);
            } else if (courses[i].getCredit() == max) {
                maxCredits.add(courses[i]);
            }
        }

        return maxCredits.toArray(new Course[0]);
    }
    //Tim deparment xuat hien nhieu nhat
    public String findDepartmentWithMostCourses() {
        String rs = null;
        int max = 1;
        for (int i = 0; i < count; i++) {
            String dpm = courses[i].getDepartment();
            int countD = 0;
            for (int j = 0; j < count; j++) {
                if (courses[j].getDepartment().equalsIgnoreCase(dpm)) {
                    countD++;
                }
            }
            if (countD > max) {
                max = countD;
                rs = dpm;
            }

        }
        return rs;
    }
    @Override
    public String toString() {
        return "CourseList{" +
                "count=" + count +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
