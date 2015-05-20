package ch09;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouZeng on 2015-05-20.
 */
public class Canvas {

    public void drawAll(List<Shape> shapes){
        for(Shape shape : shapes){
            shape.draw(this);
        }
    }

    public void drawAll2(List<? extends Shape> shapes){
        for(Shape shape : shapes){
            shape.draw(this);
        }
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        Canvas canvas = new Canvas();
        canvas.drawAll(shapes);

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        canvas.drawAll2(circles);
    }
}

abstract class Shape{
    public abstract void draw(Canvas canvas);
}

class Circle extends Shape{

    @Override
    public void draw(Canvas canvas) {
        System.out.println("在" + canvas + "上画一个圆");
    }
}

class Rectangle extends Shape{
    @Override
    public void draw(Canvas canvas) {
        System.out.println("在" + canvas + "上画一个矩形");
    }
}