package ch15;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class ReplaceTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("replace.txt"))
        ){
            ReplaceObj obj = new ReplaceObj("chen", 25);
            oos.writeObject(obj);

            ArrayList<Object> list = (ArrayList<Object>)ois.readObject();
            System.out.println(list);
        }
    }
}

class ReplaceObj implements Serializable{
    private String name;
    private int age;

    public ReplaceObj(String name, int age){
        this.name = name;
        this.age = age;
    }

    private Object writeReplace() throws ObjectStreamException{
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
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