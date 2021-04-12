package ap.week28;

public class Circle extends Shape {
    private double radius;

    public Circle(String shapeName, double radius) {
        super(shapeName);
        this.radius = radius;
    }

    public Circle(double radius) {
        this("Circle", radius);
    }

    public Circle() {
        this("Circle", 0);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double getVolume() {
        return 0;
    }

    @Override
    double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

}
