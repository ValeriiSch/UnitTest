package com.company;


public class Calculator {

    public Calculator() {

    }

    public static int add(int a, int b){
        return (int)a+b;
    }

    public static int sub(int a, int b){
        return (int)a-b;
    }

    public static int mult(int a, int b){
        return (int)a*b;
    }

    public static int divide(int a, int b){
        return (int)a/b;
    }

    public static Boolean isPositive(int a){
        return  a > 0 ? true : false;
    }

    public static Boolean isNegative(int a){
        return  a < 0 ? true : false;
    }

    public static Boolean isZero(int a){
        return  a == 0 ? true : false;
    }

}
