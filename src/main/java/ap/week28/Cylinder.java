package ap.week28;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(String shapeName, double radius, double height) {
        super(shapeName, radius);

        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super("Cylinder", radius);

        this.height = height;
    }

    public Cylinder() {
        super("Cylinder", 0);

        this.height = 0;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double getArea() {
        return 2 * Math.PI * this.getRadius() * this.getRadius() + this.getHeight() * 2 * Math.PI * this.getRadius();
    }

    @Override
    double getVolume() {
        return this.getHeight() * Math.PI * this.getRadius() * this.getRadius();
    }
}
