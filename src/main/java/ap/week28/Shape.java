package ap.week28;

/**
 * <h3>Shape</h3>
 * 
 * This class implements a shape with a name and nothing else. The abstract
 * methods {@link #getArea() getArea}, {@link #getPerimeter() getPerimeter},
 * {@link #getVolume() getVolume} are to be implemented by subclasses with the
 * correct calculations.
 * 
 * @author Alexander Taylor
 * @since 7 April 2021
 * @version 1.0
 */
public abstract class Shape {
    /**
     * The name of the shape
     */
    private String shapeName;

    /**
     * Constructs a {@link ap.week28.Shape Shape} object
     * 
     * @param shapeName the name of the shape
     */
    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    /**
     * Acessor method for {@link #shapeName}
     * 
     * @return the shape name
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * Get the volume of the shape. If the shape is 2D, return 0
     * 
     * @return the volume of the shape
     */
    abstract double getVolume();

    /**
     * Get the area of the shape. If the shape is 3D, return the surface area of the
     * object
     * 
     * @return the area of the shape
     */
    abstract double getArea();

    /**
     * Get the perimeter of the object
     * 
     * @return the perimeter of the object
     */
    abstract double getPerimeter();

    /**
     * Get a string representation of the object.
     * 
     * @return a string in the form *shape type*: *shape name*
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getShapeName();
    }
}
