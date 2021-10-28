package AbstractClass;

public class CircleAbstr extends  ShapeAbstr {
    private double radius;

    public CircleAbstr(double r) {
        super("Red");
        radius=r;
    }


    @Override
    public String getName() {
        return "Circle";
    }


    @Override
    public double getSquare() {
        return 3.1415926 * radius * radius;
    }
}
