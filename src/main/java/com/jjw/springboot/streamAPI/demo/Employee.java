package com.jjw.springboot.streamAPI.demo;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Employee {

    private String name;
    private int age;
    private int salary;
}
