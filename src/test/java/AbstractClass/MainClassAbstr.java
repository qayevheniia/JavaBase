package AbstractClass;

import InterfaceClass.Circle;
import InterfaceClass.Rectangle;
import InterfaceClass.Shape;

import java.util.ArrayList;

public class MainClassAbstr{

    public static void main(String[] args){
        ArrayList<ShapeAbstr> shapes = new ArrayList<>();
        ShapeAbstr shape = new CircleAbstr(1);
        shapes.add(shape);
//    or
        shapes.add(new RectangleAbstr(1,1));

        printShapes(shapes);

    }

    public static void printShapes (ArrayList<ShapeAbstr> shapes){
        for(ShapeAbstr shape: shapes){
            System.out.println("Name: " +shape.getName());
            System.out.println("Square: " +shape.getSquare());
            System.out.println("Color: " +shape.getColor());

        }

    }
}