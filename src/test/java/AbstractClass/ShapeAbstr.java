package AbstractClass;

public abstract class ShapeAbstr {
    private String color;

    public ShapeAbstr(String c) {
        color=c;
    }

    public abstract  String getName();
    public abstract double getSquare();
    public String getColor(){
        return color;
    };

}
