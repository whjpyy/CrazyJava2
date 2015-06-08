package ch15;

import java.io.*;

/**
 * Created by YouZeng on 2015-06-08.
 */
public class WriteTeacher {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))
        ){
            Person p = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("唐僧", p);
            Teacher t2 = new Teacher("菩提", p);

            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(p);
            oos.writeObject(t1);

            p.setName("孙悟空");
            oos.writeObject(p);

            Teacher rt1 = (Teacher)ois.readObject();
            Teacher rt2 = (Teacher)ois.readObject();
            Person rp = (Person)ois.readObject();
            Teacher rt3 = (Teacher)ois.readObject();

            Person rp2 = (Person)ois.readObject();

            System.out.println("rt1的Person引用是否等于rp：" + (rt1.getPerson() == rp ));
            System.out.println("rt2的Person引用是否等于rp：" + (rt2.getPerson() == rp ));
            System.out.println("rt1是否等于tr3：" +  (rt1 == rt3));

            System.out.println("rp2的名称：" + rp2.getName());
        }
    }
}

class Teacher implements Serializable{
    private String name;
    private Person person;

    public Teacher(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}