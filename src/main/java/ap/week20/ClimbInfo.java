package ap.week20;

/**
 * <h3>ClimbInfo</h3>
 * <p>
 * ClimbInfo stores the name and time that a hike takes
 * </p>
 */
public class ClimbInfo {
    private String peakName;
    private int climbTime;

    public ClimbInfo(String name, int time) {
        peakName = name;
        climbTime = time;
    }

    public String getPeakName() {
        return peakName;
    }

    public int getClimbTime() {
        return climbTime;
    }

    @Override
    public String toString() {
        return peakName + "/" + climbTime;
    }
}
