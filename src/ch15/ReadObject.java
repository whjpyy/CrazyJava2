package ch15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class ReadObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))){
            Person p = (Person)ois.readObject();
            System.out.println(p.getName() + ", " + p.getAge());
        }
    }
}
