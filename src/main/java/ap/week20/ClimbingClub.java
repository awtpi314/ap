package ap.week20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>ClimbingClub</h3>
 * 
 * <p>
 * This class stores a list of {@link ap.week20.ClimbInfo ClimbInfo} classes.
 * </p>
 * 
 * <ul>
 * <li><b>Class:</b>
 * <ul>
 * <li>TPS AP Java 2020-2021</li>
 * </ul>
 * </li>
 * <li><b>Date:</b>
 * <ul>
 * <li>26 January 2021</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author Alexander Taylor
 * @since 1.0
 * @version 1.0
 */
public class ClimbingClub {
    private List<ClimbInfo> climbs;

    public ClimbingClub() {
        climbs = new ArrayList<>();
    }

    /**
     * An overloaded method to add a climb to the list.
     * 
     * @param name the name of the peak
     * @param time the time taken on the hike
     * @see {@link #addClimbA(ClimbInfo) addClimbA}
     */
    public void addClimbA(String name, int time) {
        addClimbA(new ClimbInfo(name, time));
    }

    /**
     * Add a climb to the list using a {@link ap.week20.ClimbInfo ClimbInfo} class.
     * Using this method, the climb is added to the back of the list.
     * 
     * @param info the climb info class
     */
    public void addClimbA(ClimbInfo info) {
        climbs.add(info);
    }

    /**
     * An overloaded method to add a climb to the list
     * 
     * @param name the name of the peak
     * @param time the time taken on the hike
     * @see {@link #addClimbB(ClimbInfo) addClimbB}
     */
    public void addClimbB(String name, int time) {
        addClimbB(name, time);
    }

    /**
     * Add a climb to the list using a {@link ap.week20.ClimbInfo ClimbInfo} class.
     * With this method the climb is added into the correct position in the
     * pre-sorted list.
     * 
     * @param info the climb to add to the list
     */
    public void addClimbB(ClimbInfo info) {
        String peakName = info.getPeakName();
        int insertPosition = 0;
        for (ClimbInfo cInfo : climbs) {
            if (peakName.compareTo(cInfo.getPeakName()) < 0) {
                break;
            } else {
                insertPosition++;
            }
        }
        climbs.add(insertPosition, info);
    }

    /**
     * Count the number of distinct peak names in the list of climbs.
     * 
     * @return the number of peaks in the climb list
     */
    public int distinctPeakNames() {
        selectionSortByName();

        int listSize = climbs.size();
        int total = listSize;

        for (int i = 1; i < listSize; i++) {
            if (climbs.get(i).getPeakName().compareTo(climbs.get(i - 1).getPeakName()) == 0) {
                total--;
                i++;
            }
        }

        return total;
    }

    /**
     * Sort the list of climbs by name using a selection sort.
     */
    public void selectionSortByName() {
        int size = climbs.size();
        for (int i = 0; i < size - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (climbs.get(j).getPeakName().compareTo(climbs.get(minimumIndex).getPeakName()) < 0) {
                    minimumIndex = j;
                }
            }

            ClimbInfo temp = climbs.get(minimumIndex);
            climbs.set(minimumIndex, climbs.get(i));
            climbs.set(i, temp);
        }
    }

    /**
     * Sort the list of climbs by time using a selection sort.
     */
    public void selectionSortByTime() {
        int size = climbs.size();
        for (int i = 0; i < size - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (climbs.get(j).getClimbTime() < climbs.get(minimumIndex).getClimbTime()) {
                    minimumIndex = j;
                }
            }

            ClimbInfo temp = climbs.get(minimumIndex);
            climbs.set(minimumIndex, climbs.get(i));
            climbs.set(i, temp);
        }
    }

    /**
     * Remove all the duplicates of the string passed
     * 
     * @param name the duplicates to remove
     */
    public void removeDuplicateNames(String name) {
        boolean foundFirst = false;

        for (int i = climbs.size() - 1; i >= 0; i--) {
            if (climbs.get(i).getPeakName().compareTo(name) == 0) {
                if (foundFirst) {
                    climbs.remove(i);
                } else {
                    foundFirst = true;
                }
            }
        }
    }

    /**
     * Remove all climbs with greater length than the passed limit
     * 
     * @param limit the limit to the climb length
     */
    public void removeAll(int limit) {
        for (int i = climbs.size() - 1; i >= 0; i--) {
            if (climbs.get(i).getClimbTime() > limit) {
                climbs.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        int loopCount = climbs.size();
        for (int i = 0; i < loopCount; i++) {
            result += i + ": " + climbs.get(i).toString() + "\n";
        }
        return result;
    }
}
