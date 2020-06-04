package com.company;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	Integer a = input.nextInt();
	Integer b = input.nextInt();
	Integer c = input.nextInt();
	judge(a,b,c);
    }
    public static void judge(Integer a,Integer b,Integer c){
        if(a < 0 || b < 0 ||c < 0) {
            System.out.println("非三角形");
        }
        else{
            if (a + b > c && a + c > b && b + c > a) {
                if(a == b && b == c && a == c){
                    System.out.printf("等边三角形");
                }
                else if(a == b || b == c || c == a){
                    System.out.printf("等腰三角形");
                }
                else {
                    System.out.printf("一般三角形");
                }
            }
            else {
                System.out.printf("非三角形");
            }
        }
    }

}
