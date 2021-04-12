package ap.week28;

public class Square extends Shape {
    private double side;

    public Square(String shapeName, double side) {
        super(shapeName);
        this.side = side;
    }

    public Square(double side) {
        this("Square", side);
    }

    public Square() {
        this("Square", 0);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    double getVolume() {
        return 0;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    double getPerimeter() {
        return side * 4;
    }
}