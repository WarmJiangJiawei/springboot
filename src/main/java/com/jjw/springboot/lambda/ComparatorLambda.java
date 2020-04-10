package com.jjw.springboot.lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorLambda {
    /**
     *  简化匿名委托（匿名内部类）
     */

    public static void main(String[] args) {
        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        TreeSet<String> treeSet1 = new TreeSet<>(comparator1);

        Comparator<String> comparator2 = ((o1, o2) -> {
            return o1.length() - o2.length();
        });
        TreeSet<String> treeSet2 = new TreeSet<>(comparator2);

        TreeSet<String> treeSet3 = new TreeSet<String>(((o1, o2) -> o1.length() - o2.length()));
    }
}
