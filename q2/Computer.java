package BoundTest;

public class Computer {
    int sum = 0;
    public final int zhujiPrice = 25;
    public final int xianshiqiPrice = 30;
    public final int waishePrice = 45;
    public int zhujiNumber = 70;
    public int xianshiqiNumber = 80;
    public int waisheNumber = 90;
    public void sellZhuji(){
        zhujiNumber -=1;
        if(zhujiNumber==-1){
            System.out.println("主机销售结束，统计销售额");
            sellOver();
            return;
        }
        sum+=zhujiPrice;
    }
    public void sellXianshiqi(){
        xianshiqiNumber -= 1;
        if(xianshiqiNumber<0){
            System.out.println("以达到显示器最大销量");
            return;
        }
        sum+=xianshiqiPrice;
    }
    public void sellWaishe(){
        waisheNumber -=1;
        if(waisheNumber<0){
            System.out.println("以达到外设最大销量");
            return;
        }
        sum+=waishePrice;
    }
    public void sellOver(){
        System.out.println("本月销售结束，统计销售额");
        System.out.println(sum);
    }
}
