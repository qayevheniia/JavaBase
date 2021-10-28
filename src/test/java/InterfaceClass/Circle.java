package InterfaceClass;

public class Circle implements Shape{
    private double radius;
    private String color;

    public Circle (double r, String c ){
        radius = r;
        color = c;
    }
    @Override
    public String getName() {
        return "Circle";
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getSquare() {
        return 3.1415926 * radius * radius;
    }
}
