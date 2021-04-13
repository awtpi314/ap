package ap.week28;

/**
 * <h3>Cube</h3>
 * 
 * Cube extends {@link ap.week28.Square} and changes the necessary methods
 * 
 * @author Alexander Taylor
 * @since 12 April 2021
 * @version 1.0
 */
public class Cube extends Square {
    /**
     * Main constructor for {@link ap.week28.Cube Cube}
     * 
     * @param shapeName the name of the shape
     * @param side      the length of a side on the cube
     */
    public Cube(String shapeName, double side) {
        super(shapeName, side);
    }

    /**
     * Alternate constructor for {@link ap.week28.Cube Cube}
     * 
     * @param shapeName the name of the shape
     * @param square    the square off of which to base the cube
     */
    public Cube(String shapeName, Square square) {
        this(shapeName, square.getSide());
    }

    /**
     * Single-parameter constructor for {@link ap.week28.Cube Cube}. It calls the
     * {@link #Cube(String, double) main constructor} with "Cube" as shape name
     * 
     * @param side the length of one side of the cube
     */
    public Cube(double side) {
        super("Cube", side);
    }

    /**
     * Zero-parameter constructor for {@link ap.week28.Cube Cube}. It calls the
     * {@link #Cube(String, double) main constructor} with "Cube" as shape name and
     * "0" as the side length
     */
    public Cube() {
        super("Cube", 0);
    }

    @Override
    double getArea() {
        return super.getArea() * 6;
    }

    @Override
    double getPerimeter() {
        return this.getSide() * 12;
    }

    @Override
    double getVolume() {
        return super.getArea() * this.getSide();
    }
}
