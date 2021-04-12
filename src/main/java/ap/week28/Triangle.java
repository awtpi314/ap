package ap.week28;

public class Triangle extends Shape {
    private static final double sqrt3 = Math.sqrt(3);

    private double side;

    public Triangle(String shapeName, double side) {
        super(shapeName);
        this.side = side;
    }

    public Triangle(double side) {
        this("Triangle", side);
    }

    public Triangle() {
        this("Triangle", 0);
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
        return side * side * sqrt3 / 4;
    }

    @Override
    double getPerimeter() {
        return side * 3;
    }
}
