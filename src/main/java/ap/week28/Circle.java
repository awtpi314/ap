package ap.week28;

/**
 * <h3>Circle</h3>
 * 
 * Circle extends {@link ap.week28.Shape Shape} and adds the necessary methods.
 * 
 * @author Alexander Taylor
 * @since 12 April 2021
 * @version 1.0
 */
public class Circle extends Shape {
    /**
     * The radius of the circle
     */
    private double radius;

    /**
     * Main constructor for {@link ap.week28.Circle Circle}
     * 
     * @param shapeName the name of the shape
     * @param radius    the radius of the circle
     */
    public Circle(String shapeName, double radius) {
        super(shapeName);
        this.radius = radius;
    }

    /**
     * Single parameter constructor for {@link ap.week28.Circle Circle}. It calls
     * {@link #Circle(String,double) the main constructor} with "Circle" as the
     * shape name
     * 
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this("Circle", radius);
    }

    /**
     * Zero parameter constructor for {@link ap.week28.Circle Circle}. It calls
     * {@link #Circle(String, double) the main constructor} with "Circle" as the
     * shape name and "0" as the radius
     */
    public Circle() {
        this("Circle", 0);
    }

    /**
     * Accessor method for {@link #radius}
     * 
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Mutator method for {@link #radius}
     * 
     * @param radius the new radius
     */
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
