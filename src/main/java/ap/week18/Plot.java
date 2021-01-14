package ap.week18;

/**
 * <h3>Plot</h3>
 * <p>
 * Plot is a representation of a plot of land with a certain type of production
 * and an amount of production represented by the integer passed to the
 * constructor.
 * </p>
 * 
 * @author Alexander Taylor
 * @since Version 1.0
 * @since 14 January 2021
 * @version 1.0
 */
public class Plot {
    private String cropType;
    private int cropYield;

    /**
     * The default constructor for {@link ap.week18.Plot Plot}. It sets
     * {@link #cropType} to an empty string and {@link #cropYield} to zero.
     */
    public Plot() {
        cropType = "";
        cropYield = 0;
    }

    /**
     * An overloaded constructor for {@link ap.week18.Plot Plot}. It sets
     * {@link #cropType} and {@link #cropYield} to whatever it passed by the user.
     * 
     * @param cropType  the crop type
     * @param cropYield the crop yield
     */
    public Plot(String cropType, int cropYield) {
        this.cropType = cropType;
        this.cropYield = cropYield;
    }

    /**
     * A public accessor method for {@link #cropType}.
     * 
     * @return the crop type as a string
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * A public accessor method for {@link #cropYield}.
     * 
     * @return the crop yield as an integer
     */
    public int getCropYield() {
        return cropYield;
    }

    /**
     * A public mutator method for {@link #cropType}.
     * 
     * @param cropType the new type of crop
     */
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    /**
     * A public mutator method for {@link #cropYield}.
     * 
     * @param cropYield the new yield for the crop
     */
    public void setCropYield(int cropYield) {
        this.cropYield = cropYield;
    }

    @Override
    public String toString() {
        return String.format("%15s", getCropType() + "/" + getCropYield());
    }
}
