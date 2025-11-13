package com.korit.servlet_study.ch09;

import lombok.*;

@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private String school;
}
