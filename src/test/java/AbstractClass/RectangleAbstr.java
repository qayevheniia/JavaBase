package AbstractClass;

public class RectangleAbstr extends ShapeAbstr {
    private double height;
    private double width;


    public RectangleAbstr(double height, double width) {
        super("Blue");
        this.height = height;
        this.width = width;

    }

    @Override
    public String getName() {
        return "Rectangle";
    }


    @Override
    public double getSquare() {
        return height*width;
    }
}

