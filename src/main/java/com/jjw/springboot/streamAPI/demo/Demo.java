package com.jjw.springboot.streamAPI.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        List<Employee> lists = new ArrayList<>();
        lists.add(new Employee("jjw", 20, 8000));
        lists.add(new Employee("xl", 21, 17000));
        lists.add(new Employee("xfy", 22, 6000));
        lists.add(new Employee("zmc", 19, 3000));

        //筛选
        lists.stream().filter((list) -> list.getAge() > 19).forEach((employee) -> System.out.println(employee.getName()));

        //去重
        System.out.println(lists.stream().distinct().count());

        //获取第一个
        lists.stream().limit(1).forEach(System.out::println);

        System.out.println("==================");
        //跳过第一个
        lists.stream().skip(1).forEach(System.out::println);

        System.out.println("==================映射");
        //映射
        lists.stream().map(list -> {
            list.setAge(list.getAge() + 10);
            return list;
        }).forEach(System.out::println);

        //调用方法
        System.out.println("==================调用方法");
        lists.stream().map(list -> {
            list.setName(list.getName().toUpperCase());
            return list;
        }).forEach(System.out::println);

        //排序
        System.out.println("==================排序");
        lists.stream().map(Employee::getAge).sorted().forEach(System.out::println);

        //定制排序
        System.out.println("==================定制排序");
        lists.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            }else {
                return x.getAge() - y.getAge();
            }
        }).forEach(System.out::println);

        //检查全部匹配
        System.out.println(lists.stream().anyMatch(list -> list.getAge() == 30));

        Optional<Employee> max = lists.stream().max((x, y) -> x.getAge() - y.getAge());
        System.out.println(max.get());
    }
}
