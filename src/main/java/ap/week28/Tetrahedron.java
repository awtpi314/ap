package ap.week28;

public class Tetrahedron extends Triangle {
    private static final double sqrt2 = Math.sqrt(2);

    public Tetrahedron(String shapeName, double side) {
        super(shapeName, side);
    }

    public Tetrahedron(double side) {
        super("Tetrahedron", side);
    }

    public Tetrahedron() {
        super("Tetrahedron", 0);
    }

    @Override
    double getArea() {
        return super.getArea() * 4;
    }

    @Override
    double getVolume() {
        return Math.pow(this.getSide(), 3) * sqrt2 / 12;
    }
}
