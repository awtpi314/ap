package ap.week28;

public class Sphere extends Circle {
    public Sphere(String shapeName, double radius) {
        super(shapeName, radius);
    }

    public Sphere(double radius) {
        super("Sphere", radius);
    }

    public Sphere() {
        super("Sphere", 0);
    }

    @Override
    double getArea() {
        return 4 * Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    double getVolume() {
        return this.getArea() * this.getRadius() / 3;
    }
}
