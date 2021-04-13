package ap.week28;

/**
 * <h3>Triagle</h3>
 * 
 * Triagle extends {@link ap.week28.Shape Shape} and adds the necessary methods
 * 
 * @author Alexander Taylor
 * @since 12 April 2021
 * @version 1.0
 */
public class Triangle extends Shape {
    /**
     * Store the square root of 3 to avoid recalculation
     */
    private static final double sqrt3 = Math.sqrt(3);

    /**
     * The length of the triangle side
     */
    private double side;

    /**
     * The main constructor for {@link ap.week28.Triangle Triangle}
     * 
     * @param shapeName the name of the shape
     * @param side      the length of the triangle side
     */
    public Triangle(String shapeName, double side) {
        super(shapeName);
        this.side = side;
    }

    /**
     * Single parameter constructor for {@link ap.week28.Triangle Triangle}. It
     * calls the {@link #Triangle(String, double) main constructor} with "Triangle"
     * as shape name
     * 
     * @param side
     */
    public Triangle(double side) {
        this("Triangle", side);
    }

    /**
     * Zero-parameter constructor for {@link ap.week28.Triangle Triangle}. It calls
     * the {@link #Triangle(String, double) main constructor} with "Triangle" as
     * shape name and "0" as side length
     */
    public Triangle() {
        this("Triangle", 0);
    }

    /**
     * Accessor method for {@link #side}
     * 
     * @return the side length
     */
    public double getSide() {
        return side;
    }

    /**
     * Mutator method for {@link #side}
     * 
     * @param side the new side length
     */
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
