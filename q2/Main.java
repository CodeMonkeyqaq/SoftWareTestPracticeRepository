package BoundTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        int x = 0,y = 0,z = 0;

        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        System.out.println("佣金为:" + yongjin(x, y, z, computer));
    }
    public static double yongjin(int x, int y, int z, Computer computer){
        if(x==-1){
            System.out.println("系统统计本月销售额");
            return 0;
        }else if(x < 1){
            System.out.println("主机过少，没有满足销售一台完整的机器");
            return 0;
        }else if(y < 1){
            System.out.println("显示器过少，没有满足销售一台完整的机器");
            return 0;
        }else if(z < 1){
            System.out.println("外设过少，没有满足销售一台完整的机器");
            return 0;
        }else if(x > 70){
            System.out.println("主机过多，计算失败");
            return 0;
        }else if(y > 80){
            System.out.println("显示器过多，计算失败");
            return 0;
        }else if(z > 90){
            System.out.println("外设过多，计算失败");
            return 0;
        }
        for(int i = 0; i < y; i++){
            computer.sellXianshiqi();
        }
        for(int i = 0; i < z; i++){
            computer.sellWaishe();
        }
        for(int i = 0; i < x; i++){
            computer.sellZhuji();
        }
        computer.sellOver();
        if(computer.sum<=1000){
            return computer.sum * 0.1;
        }else if(computer.sum<=1800){
            return computer.sum * 0.15;
        }else{
            return computer.sum * 0.2;
        }
    }
}
