package ap.week28;

/**
 * <h3>Square</h3>
 * 
 * Square extends {@link ap.week28.Shape Shape} and adds the necessary methods
 * for a square
 * 
 * @author Alexander Taylor
 * @since 12 April 2021
 * @version 1.0
 */
public class Square extends Shape {
    /**
     * The length of the side
     */
    private double side;

    /**
     * Full constructor for {@link ap.week28.Square Square}
     * 
     * @param shapeName the name to pass to shape
     * @param side      the length of the side
     */
    public Square(String shapeName, double side) {
        super(shapeName);
        this.side = side;
    }

    /**
     * Single parameter constructor for {@link ap.week28.Square Square}. This
     * constructor calls {@link #Square(String, double) the main constructor} with
     * "Square" as the shape name
     * 
     * @param side the length of the side
     */
    public Square(double side) {
        this("Square", side);
    }

    /**
     * Zero parameter constructor for {@link ap.week28.Square Square}. This
     * constructor calls {@link #Square(String, double) the main constructor} with
     * "Square" as the shape name and "0" as the side length
     */
    public Square() {
        this("Square", 0);
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
        return side * side;
    }

    @Override
    double getPerimeter() {
        return side * 4;
    }
}