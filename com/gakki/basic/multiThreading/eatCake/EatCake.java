package com.gakki.basic.multiThreading.eatCake;

/**
 * @author wangxiaobin
 */
public class EatCake extends Thread{

    private Cake cake;
    public EatCake(Cake cake,String whoEat) {
        this.cake = cake;
        setName(whoEat);
    }

//    private void eatCake(Cake cake,int size){
//        this.cake = cake;
//        cake.eatCake(size);
//    }

    @Override
    public void run() {
        while (true) {
            int n = 3;
            System.out.println(getName()+" eat size:"+n);
            cake.eatCake(n);
            System.out.println("Cake size: "+cake.getSize());
            try {
                sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if (cake.getSize() <= 0) {
                System.out.println(getName()+" died now");
                return;
            }
        }
    }
}
