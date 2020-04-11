package com.jjw.springboot.jvm;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    //-Xms1m -Xmx1m -XX:+PrintGC
    public static void main(String[] args) {
//        List<Object> list = new LinkedList<>();
//        int i = 0;
//        while (true) {
//            i++;
//            if (i % 10000 == 0) System.out.println(i);
//            list.add(new Object());
//        }
        //循环不停的分配对象，分配的太多，GC来不及回收，堆被撑爆
        //Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded

        //heap堆
        //在分配时，有超过堆内存大小的对象在分配
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        String[] arr = new String[1000000000];
    }
}
