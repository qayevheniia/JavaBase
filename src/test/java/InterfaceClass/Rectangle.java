package InterfaceClass;

public class Rectangle implements Shape {
    private double height;
    private double width;
    private String color;

    public Rectangle(double height, double width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getSquare() {
        return height*width;
    }
}
