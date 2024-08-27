/*
 * @ (#) mainTest.java 1.0 8/23/2024
 *
 * Copyright (c) 2024 IUH.All rights reserved
 */

package iuh.fit.se.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * @description
 * @author : Nguyen Truong An
 * @date : 8/23/2024
 * @version 1.0
 */
public class mainTest {
    public static void main(String[] args) {
                CourseList courseList = new CourseList();
                Course[] courses = courseList.getCourses();

                Course c1 = new Course(4,"Get API","G01","Nguyen A B");
                courseList.addCourse(c1);
                Course c2 = new Course(3,"Python 1","P01","Johny Z");
                courseList.addCourse(c2);
                Course c3 = new Course(3,"Python 2","P02","Johny C");
                courseList.addCourse(c3);
                Course c4 = new Course(3,"Python 3","P03","Johny");
                courseList.addCourse(c4);
                Course c5 = new Course(4,"Axios","A01","An");
                courseList.addCourse(c5);


                Scanner sc = new Scanner(System.in);
                while (true) {
                    menu();
                    System.out.println("Enter your choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            Course course = new Course();
                            System.out.print("Enter course ID: ");
                            String id = sc.next();
                            if(courseList.findCourseById(id) == null){
                                course.setId(id);
                                System.out.print("Enter course credit: ");
                                course.setCredit(sc.nextInt());
                                System.out.print("Enter course title: ");
                                course.setTitle(sc.next());
                                System.out.print("Enter course department: ");
                                sc.nextLine();
                                String dpm = sc.nextLine();
                                course.setDepartment(dpm);
                                System.out.println("\nCourse added");
                                courseList.addCourse(course);
                            }
                            else
                                System.out.println("\nCourse not added : ID was existed");

                            break;
                        case 2:
                            header();
                            for (Course c : courses) {
                                System.out.println(c);
                                System.out.print("________________________________________________________________________\n");
                                if(c == null){
                                    break;
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Enter course ID to remove: ");
                            String removeId = sc.next();
                            if(courseList.removeCourse(removeId)){
                                System.out.println("Course removed");
                            }
                            else
                                System.out.println("Course not removed");
                            break;
                        case 4:
                            System.out.print("Enter course ID to find: ");
                            String findId = sc.next();
                            if (courseList.findCourseById(findId) == null) {
                                System.out.println("Course not found");
                            }

                            else{
                                header();
                                System.out.print(courseList.findCourseById(findId));
                            }
                            break;
                        case 5:
                            sc.nextLine();
                            System.out.print("Enter course Title to find: ");
                            String findTT = sc.nextLine();
                            System.out.println(findTT);
                            Course[] rsT = courseList.findCourseByTitle(findTT);
                            if (rsT.length == 0) {
                                System.out.println("Course not found");
                            } else {
                                header();
                                for(Course c : rsT){
                                    System.out.println(c);
                                }
                            }
                            break;
                        case 6:
                            sc.nextLine();
                            System.out.print("Enter course Department to find: ");
                            String findDpm = sc.nextLine();
                            Course[] rsD = courseList.findCourseByDepartment(findDpm);
                            if (rsD.length == 0) {
                                System.out.println("Course not found");
                            } else {
                                header();
                                for(Course c : rsD){
                                    System.out.println(c);
                                }
                            }
                            break;
                        case 7:
                            courseList.sortCoursesByTitle();
                            System.out.println("SortCoursesByTitle has been called");
                            break;
                        case 8:
                            Course[] maxCredits = courseList.findMaxCreditsCourse();
                                header();
                                for(Course c : maxCredits){
                                    System.out.println(c);
                                }
                            break;
                        case 9:
                            String mostDpm = courseList.findDepartmentWithMostCourses();
                            if(mostDpm==null){
                                System.out.println("No department with most course found");
                            }
                            else
                                System.out.println("Department with most courses: " + mostDpm);
                            break;
                        case 10:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
    public static void menu(){
        System.out.println("\nMenu:");
        System.out.println("1. Add course");
        System.out.println("2. List courses");
        System.out.println("3. Remove course");
        System.out.println("4. Find course by ID");
        System.out.println("5. Find courses by title");
        System.out.println("6. Find courses by department");
        System.out.println("7. Sort courses by title");
        System.out.println("8. Find course with max credit");
        System.out.println("9. Find department with most courses");
        System.out.println("10. Exit");

    }
    public static void header(){
        String line ="________________________________________________________________________\n";
        String header = String.format("| %-10s| %-25s|%-10s| %-20s|\n", "ID", "Title", "Credit", "Department");
        System.out.print(line);
        System.out.printf(header);
        System.out.print(line);
    }

}
