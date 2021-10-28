package InterfaceClass;

import java.util.ArrayList;

public class MainClass {

public static void main(String[] args){
    ArrayList<Shape> shapes = new ArrayList<>();
    Shape shape = new Circle(1, "Red");
    shapes.add(shape);
//    or
    shapes.add(new Rectangle(1,1,"Blue"));

    printShapes(shapes);

}

    public static void printShapes (ArrayList<Shape> shapes){
    for(Shape shape: shapes){
        System.out.println("Name: " +shape.getName());
        System.out.println("Square: " +shape.getSquare());
        System.out.println("Color: " +shape.getColor());

    }

    }
}

