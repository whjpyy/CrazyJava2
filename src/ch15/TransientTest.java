package ch15;

import java.io.*;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class TransientTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"))
        ){
            TransientObj obj = new TransientObj("chen", 25, 180);
            oos.writeObject(obj);

            TransientObj obj2 = (TransientObj)ois.readObject();
            System.out.println("name：" + obj.getName() + ", age：" + obj2.getAge());
        }
    }
}

class TransientObj implements Serializable{
    private String name;
    private transient int age;
    private int high;

    public TransientObj(String name, int age, int high) {
        this.name = name;
        this.age = age;
        this.high = high;
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

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(new StringBuffer(name).reverse());
        oos.writeInt(high);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)ois.readObject()).reverse().toString();
        this.high = ois.readInt();
    }
}