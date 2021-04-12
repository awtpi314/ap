package ap.week28;

public class Cube extends Square {
    public Cube(String shapeName, double side) {
        super(shapeName, side);
    }

    public Cube(double side) {
        super("Cube", side);
    }

    public Cube() {
        super("Cube", 0);
    }

    @Override
    double getArea() {
        return this.getSide() * this.getSide() * 6;
    }

    @Override
    double getPerimeter() {
        return this.getSide() * 12;
    }

    @Override
    double getVolume() {
        return this.getSide() * this.getSide() * this.getSide();
    }
}
