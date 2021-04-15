package com.nicholas;


import lombok.Data;

@Data
public class Dog {


    private String name;
    private String color;
    private int age;

    public Dog() {
    }

    public Dog(String name, String color, int age) {
        super();
        this.name = name;
        this.color = color;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Dog [name=" + name + ", color=" + color + ", age=" + age + "]";
    }
}
