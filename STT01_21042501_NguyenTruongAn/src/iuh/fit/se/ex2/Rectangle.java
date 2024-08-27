    /*
     * @ (#) Rectangle.java 1.0 8/23/2024
     *
     * Copyright (c) 2024 IUH.All rights reserved
     */

    package iuh.fit.se.ex2;

    /*
     * @description
     * @author : Nguyen Truong An
     * @date : 8/23/2024
     * @version 1.0
     */
    /**
     * Represents a rectangle with a length and width.
     */
    public class Rectangle {
        private double length;
        private double width;

        public Rectangle() {
            this(0,0);
        }

        /**
         * Creates a new rectangle with the specified length and width.
         * @param length the length of the rectangle
         * @param width the width of the rectangle
         * @throws IllegalArgumentException if length or width is less than 0
         */
        public Rectangle(double length, double width) {
            if (length < 0 || width < 0){
                throw new IllegalArgumentException("Length and width should be greater than 0");
            }
            this.length = length;
            this.width = width;
        }
        /**
         * Returns the length of the rectangle.
         * @return the length of the rectangle
         */
        public double getLength() {
            return length;
        }
        /**
         * Sets the length of the rectangle.
         * @param length the new length of the rectangle
         * @throws IllegalArgumentException if length is less than 0
         */
        public void setLength(double length) {
            if (length < 0){
                throw new IllegalArgumentException("Length should be greater than 0");
            }
            this.length = length;
        }
        /**
         * Returns the width of the rectangle.
         * @return the width of the rectangle
         */
        public double getWidth() {
            return width;
        }
        /**
         * Sets the width of the rectangle.
         * @param width the new width of the rectangle
         * @throws IllegalArgumentException if Width less than 0
         */
        public void setWidth(double width) {
            if (width < 0){
                throw new IllegalArgumentException("Width should be greater than 0");
            }
            this.width = width;
        }
        /**
         * Returns the area of the rectangle.
         * @return the area of the rectangle
         */
        public double getArea(){
            return length * width;
        }
        /**
         * Returns the perimeter of the rectangle.
         * @return the perimeter of the rectangle
         */
        public double getPerimeter(){
            return (length + width) * 2;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "length=" + length +
                    ", width=" + width +
                    '}';
        }
    }
