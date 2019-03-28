package com.learn.junittest.Calculator;

import java.util.ArrayList;

public class Calculator {

    public  int  add(int a,int b){
        return  a+b;
    }

    public Calculator(){
        System.out.println("Calculator constructed");
    }

    public static void main(String[] args) {

        System.out.println(new Calculator().add(1,2));
    }
}
