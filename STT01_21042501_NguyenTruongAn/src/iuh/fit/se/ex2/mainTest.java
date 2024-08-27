/*
 * @ (#) mainTest.java 1.0 8/23/2024
 *
 * Copyright (c) 2024 IUH.All rights reserved
 */

package iuh.fit.se.ex2;

import java.util.Scanner;

/*
 * @description
 * @author : Nguyen Truong An
 * @date : 8/23/2024
 * @version 1.0
 */
/**
 * Main test class.
 */
public class mainTest {
    /**
     * Main method.
     * @param args command line arguments
     */
    public static void main(String[] args) {
            Rectangle r = new Rectangle(20,25.5);
            System.out.print(r);
            System.out.print("\nArea:" + r.getArea());
            System.out.print("\nPerimeter:" + r.getPerimeter());
        }
}
