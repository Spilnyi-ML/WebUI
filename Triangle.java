package ru.gb.lesson4;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(new Triangle().triangle(3, 5, 7));
        System.out.println(new Triangle().triangle(7, 13, 11));
        System.out.println(new Triangle().triangle(0, 0, 11));
    }


        public double triangle(double a, double b, double c){
            double p =(a + b + c)/2;

            double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));

            return s;
        }

    }

