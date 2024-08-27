/*
 * @ (#) Course.java 1.0 8/23/2024
 *
 * Copyright (c) 2024 IUH.All rights reserved
 */

package iuh.fit.se.ex3;

/*
 * @description
 * @author : Nguyen Truong An
 * @date : 8/23/2024
 * @version 1.0
 */
public class Course {
    private int credit;
    private String title;
    private String id;
    private String department;

    /**
     * Default constructor.
     */
    public Course() {
        super();
    }
    /**
     * Constructor with parameters.
     *
     * @param credit  the credit of the course
     * @param title   the title of the course
     * @param id      the id of the course
     * @param department the department of the course
     */
    public Course(int credit, String title, String id, String department) {
        this.setCredit(credit);
        this.setTitle(title);
        this.setId(id);
        this.department = department;
    }
    /**
     * Gets the credit of the course.
     *
     * @return the credit of the course
     */
    public int getCredit() {
        return credit;
    }
    /**
     * Sets the credit of the course.
     *
     * @param credit the credit of the course
     * @throws IllegalArgumentException if credit is less than or equal to 0
     */
    public void setCredit(int credit) {
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        this.credit = credit;
    }
    /**
     * Gets the title of the course.
     *
     * @return the title of the course
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of the course.
     *
     * @param title the title of the course
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }
    /**
     * Gets the id of the course.
     *
     * @return the id of the course
     */

    public String getId() {
        return id;
    }
    /**
     * Sets the id of the course.
     *
     * @param id the id of the course
     * @throws IllegalArgumentException if id is invalid (less than 3 characters or contains non-letter/digit characters)
     */
    public void setId(String id) {
        if(id.trim().length()<3){
            throw new IllegalArgumentException("ID must have at least 3 characters");
        }
        for(int i = 0; i < id.trim().length(); i++) {
            char c = id.charAt(i);
            if(!Character.isLetter(c) && !Character.isDigit(c)) {
                throw new IllegalArgumentException("ID must contain only letters or digits");
            }
        }
        this.id = id;
    }
    /**
     * Gets the department of the course.
     *
     * @return the department of the course
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Sets the department of the course.
     *
     * @param department the department of the course
     */
    public void setDepartment(String department) {
        this.department = department;
    }

//    //Sap xep theo title
//    public int compareTo(Course c)
//    {
//        return(String)(this.title-c.getTitle());
//    }
    /**
     * Returns a string representation of the course.
     *
     * @return a string representation of the course
     */
    @Override
    public String toString() {
        return String.format("| %-10s| %-25s|%10d| %-20s|",id,title,credit,department);
    }
}
