package com.company;

import java.util.Scanner;
public class Calendar {
    public static void main(String[] args){
        //思路：
        //1、构建Scanner扫描器类的对象
        Scanner input = new Scanner(System.in);

        //2、从控制台接收用户录入的年份、月份
        System.out.println("请输入年月日空格分隔");

        int year  = input.nextInt();

        int month  = input.nextInt();

        int day = input.nextInt();//获取日期

        if (year > 2100 || year < 1900) {
            System.out.println("Y不在取值范围内");
            System.exit(0);
        }
        if (month < 1 || month > 12) {
            System.out.println("M不在取值范围内");
            System.exit(0);
        }
        int days = 28;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {//判断闰年的情况
                days = 29;
            }
        }

        if (day < 1 || day > days) {
            System.out.println("D不在取值范围内");
            System.exit(0);
        }
        //3、获得1900年距离当前年份上一年的总天数
        int totalDays = getFromNowYearTo1900TotalDays(year);

        //4、获得当前年份所经过的天数
        int totalDaysThisYear = getNowYearPassedTotalDays(year,month);

        //5、求得给定月份第一天的星期数
        int week = (totalDays + totalDaysThisYear +1) % 7;//星期日是，week = 0

        //6、格式化输出日历
        formatCalendarOutput(week,year,month,day);
    }

    /**
     *格式化输出日历
     *@param week:当前月份第一天的星期数
     *@param year:当前年份
     *@param month:当前月份
     */
    public static void formatCalendarOutput(int week,int year,int month,int day){

        week = (week + day - 1) % 7;
        String weeks = "一" ;
        switch (week){
            case 0:{
                weeks = "日";
                break;
            }
            case 1:{
                weeks = "一";
                break;
            }
            case 2:{
                weeks = "二";
                break;
            }
            case 3:{
                weeks = "三";
                break;
            }
            case 4:{
                weeks = "四";
                break;
            }
            case 5:{
                weeks = "五";
                break;
            }
            case 6:{
                weeks = "六";
                break;
            }
        }
        System.out.println(year + "年" + month + "月" + day + "日" + "星期" + weeks);
    }
    /**
     *判断给定的年份是否为闰年
     *@param year:给定的年份
     *@return true:闰年；false：平年
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     *根据参数指定的年份，月份，求出当前月的总天数
     *@param year:年份
     *@param month:月份
     *@return 月的总天数
     */
    public static int getNowMonthDays(int year,int month){//year:设计该参数的原因，2月份根据年份是否是闰年来确定其天数的
        switch(month){
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    /**
     *获得当前年份的上一年距离1900年所经过的总天数
     *@param year 当前年份
     *@return 总天数
     */
    public static int getFromNowYearTo1900TotalDays(int year){
        int totalDays = 0;
        for(int i = 1900; i< year; i++){//i:年份
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        return totalDays;
    }

    /**
     *求出当前年份经过的总天数（从当前年的1月1日到给定月份的上一个月最末一天）
     *@param year:年份
     *@param month:月份
     *@return 总天数
     */
    public static int getNowYearPassedTotalDays(int year,int month){
        int totalDays = 0;
        for(int i=1;i< month;i++){//i:月份
            totalDays += getNowMonthDays(year,i);
        }
        return totalDays;
    }

}
