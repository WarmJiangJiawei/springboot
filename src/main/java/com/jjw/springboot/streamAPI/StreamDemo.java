package com.jjw.springboot.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("hello");
        lists.add("stream");
        lists.add("goodnight!");

        int count = 0;
        for (String list : lists) {
            if (list.length() > 3) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("============================");

        long count1 = lists.stream().filter(list -> list.length() > 3).count();
        System.out.println(count1);

        int[] array = new int[]{2, 3, 4};
        IntStream stream = Arrays.stream(array);
        long count2 = stream.filter((arr) -> arr > 2).count();
        System.out.println(count2);
    }
}
