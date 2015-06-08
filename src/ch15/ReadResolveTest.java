package ch15;

import java.io.*;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class ReadResolveTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("orientation.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("orientation.txt"))
        ){
            oos.writeObject(Orientation.HORIZONTAL);
            Orientation o = (Orientation)ois.readObject();
            System.out.println(o == Orientation.HORIZONTAL);
        }
    }
}

class Orientation implements Serializable{
    public static Orientation HORIZONTAL = new Orientation(1);
    public static Orientation VERTICAL = new Orientation(2);
    private int value;
    private Orientation(int value){
        this.value = value;
    }

    private Object readResolve(){
        if(value == 1){
            return HORIZONTAL;
        }else if(value == 2){
            return VERTICAL;
        }
        return null;
    }
}