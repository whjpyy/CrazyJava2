package ch15;

import java.io.*;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class WriteObject {

    public static void main(String[] args) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Object.txt"))){
            oos.writeObject(new Person("轼佣", 25));
        }
    }
}

class Person implements Serializable{
    private String name;
    private int age;

    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}