package org.example;

public class Person {


    private static int a=10;
    private String name;
    public int age;
    private boolean isAdult;

    public Person(String name, int age) {
        a++;
        this.name = name;
        this.age = age;
        if(age > 18 && age < 100){
            this.isAdult = true;
        }else{
            this.isAdult=false;
        }
    }

    public int getA(){
        return this.a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void incrementA(){
        a++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 100) {
            this.age = age;
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }
}
