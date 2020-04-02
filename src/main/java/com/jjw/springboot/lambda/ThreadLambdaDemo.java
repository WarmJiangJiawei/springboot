package com.jjw.springboot.lambda;

public class ThreadLambdaDemo {

    public static void main(String[] args) {
        //匿名内部类形式
        Runnable runnable1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("hello Lambda1");
            }
        };
        new Thread(runnable1).start();

        //lambda
        Runnable runnable2 = () -> {
            System.out.println("hello lambda2");
        };
        new Thread(runnable2).start();


        new Thread(() -> {
            System.out.println("hello lambda3");
        }).start();

        new Thread(() -> System.out.println("hello lambda4")).start();
    }
}
