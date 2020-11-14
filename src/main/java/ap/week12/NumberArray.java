package ap.week12;

import java.util.Arrays;

/**
 * <p>
 * <b>File:</b> NumberArray.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> {@link NumberArray} is a class that contains many methods
 * for dealing with arrays.
 * </p>
 * 
 * <b>Method list:</b>
 * <ul>
 * <li>{@link #NumberArray(int)}</li>
 * <li>{@link #findSum(int[])}</li>
 * <li>{@link #findHighest(int[])}</li>
 * <li>{@link #findLowest(int[])}</li>
 * <li>{@link #findMode(int[])}</li>
 * <li>{@link #findConsecutivePair(int[])}</li>
 * <li>{@link #reversedArray(int[])}</li>
 * <li>{@link #rotateArray(int[], int)}</li>
 * <li>{@link #shuffle(int[])}</li>
 * <li>{@link #findLargestConsecutive(int[])}</li>
 * <li>{@link #merryGoRound(int[], int)}</li>
 * <li>{@link #consolidate(int[])}</li>
 * </ul>
 * 
 * <hr/>
 * 
 * @author Alexander Taylor (@awtpi314)
 * @version 1.0
 * @since 13 November 2020
 */
public class NumberArray {
    private int[] randomArray;
    private int[] evenArray;
    private int[] brokenArray;

    public NumberArray(int size) {
        randomArray = new int[size];
        evenArray = new int[size];
        brokenArray = new int[size];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = generateRandomInteger(0, size);
            evenArray[i] = 2 * (i + 1);
        }

        int randomTotal = generateRandomInteger(1, size - 1);
        for (int i = 0; i < randomTotal; i++) {
            int index = generateRandomInteger(0, size - 1);
            brokenArray[index] = index + 1;
        }
    }

    /**
     * Finds the sum of the array
     * 
     * @param inArray the target array
     * @return the sum of the array
     */
    public int findSum(int[] inArray) {
        int sum = 0;
        for (int n : inArray) {
            sum += n;
        }
        return sum;
    }

    /**
     * Finds the higest number in the array
     * 
     * @param inArray the target array
     * @return the higest number in the array
     */
    public int findHighest(int[] inArray) {
        int highest = Integer.MIN_VALUE;
        for (int n : inArray) {
            if (n > highest) {
                highest = n;
            }
        }
        return highest;
    }

    /**
     * Finds the lowest number in the array
     * 
     * @param inArray the target array
     * @return the lowest number in the array
     */
    public int findLowest(int[] inArray) {
        int lowest = Integer.MAX_VALUE;
        for (int n : inArray) {
            if (n < lowest) {
                lowest = n;
            }
        }
        return lowest;
    }

    /**
     * Finds the mode of the array
     * 
     * @param inArray the target array
     * @return the mode of the array
     */
    public int findMode(int[] inArray) {
        int modeCount = 0;
        int mode = 0;

        int currentCount = 0;

        for (int candidate : inArray) {
            currentCount = 0;

            for (int comparator : inArray) {
                if (comparator == candidate) {
                    currentCount++;
                }
            }

            if (currentCount >= modeCount) {
                modeCount = currentCount;
                mode = candidate;
            }
        }

        return mode;
    }

    /**
     * Finds the first consective pair in the array
     * 
     * @param inArray the target array
     * @return the first consecutive number
     */
    public int findConsecutivePair(int[] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == inArray[i + 1]) {
                return inArray[i];
            }
        }
        return -1;
    }

    /**
     * Reverse inArray and return it
     * 
     * @param inArray the array to reverse
     * @return the reversed array
     */
    public int[] reversedArray(int[] inArray) {
        int[] outArray = new int[inArray.length];

        for (int i = 0, j = inArray.length - 1; i < outArray.length; i++, j--) {
            outArray[j] = inArray[i];
        }

        return outArray;
    }

    /**
     * This method rotates the array by moving it <i>shift</i> positions.
     *
     * Note: the array is not modified and there is no need to copy the array
     * 
     * @param inArray the array to shift
     * @param shift   how many positions to shift
     * @return the shifted array
     */
    public int[] rotateArray(int[] inArray, int shift) {
        int[] outArray = new int[inArray.length];

        for (int i = 0, j = 0 + shift; i < inArray.length; i++, j = normalizeSize(j++, inArray.length)) {
            outArray[j] = inArray[j];
        }

        return outArray;
    }

    /**
     * Shuffle mixes the array to change positions
     * 
     * @param inArray the array to shuffle
     */
    public void shuffle(int[] inArray) {
        for (int i = inArray.length; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));

            int temp = inArray[i];
            inArray[i] = inArray[randomIndex];
            inArray[randomIndex] = temp;
        }
    }

    /**
     * Finds the largest consecutive items in the array
     * 
     * @param inArray the array in which to find consecutive items
     * @return the largest consecutive pattern
     */
    public int findLargestConsecutive(int[] inArray) {
        int largestConsecutive = inArray[0];
        int size = 1;

        int currentConsecutive = inArray[1];
        int currentSize = 0;

        for (int i = 1; i < inArray.length; i++) {
            if (inArray[i] == currentConsecutive) {
                currentSize++;
            } else {
                currentConsecutive = inArray[i];
            }

            if (currentSize > size) {
                largestConsecutive = currentConsecutive;
            }
        }

        return largestConsecutive;
    }

    /**
     * <p>
     * Distributes the "candies" in inArray[currentIndex] over the following array
     * indices.
     * </p>
     * <p>
     * <b>Note:</b> If there are more "candies" than positions in the array, it will
     * wrap around and start at index 0
     * </p>
     * 
     * @param inArray      the array to distribute
     * @param currentIndex the index to pull "candies" from
     * @return the end index
     */
    public int merryGoRound(int[] inArray, int currentIndex) {
        int numOfCandies = inArray[currentIndex];
        inArray[currentIndex] = 0;

        int lastIndex = inArray.length - 1;
        int endIndex = normalizeSize(currentIndex + numOfCandies, lastIndex);

        for (int i = currentIndex + 1; i < inArray.length; i++) {
            inArray[i]++;
        }

        for (int i = 0; i < endIndex; i++) {
            inArray[i]++;
        }

        return endIndex;
    }

    /**
     * Moves all non-zeros to the beginning of the array
     * 
     * @param inArray the array to consolidate
     */
    public void consolidate(int[] inArray) {
        int[] consolidated = new int[inArray.length];
        int consolidatedIndex = 0;

        for (int n : inArray) {
            if (n != 0)
                consolidated[consolidatedIndex++] = n;
        }

        inArray = consolidated;
    }

    /**
     * This method brings size within the bounds of the array
     * 
     * @param position the index to normalize
     * @param size     the size of the array
     * @return the normalized index
     */
    private int normalizeSize(int position, int size) {
        if (position > size) {
            return position % size;
        } else {
            return position;
        }
    }

    /**
     * Generate a pseudo-random integer in range minimum to maximum
     * 
     * @param minimum the lower bound of the generator
     * @param maximum the upper bound
     * @return the random integer
     */
    private int generateRandomInteger(int minimum, int maximum) {
        return (int) ((maximum - minimum + 1) * Math.random()) + minimum;
    }
}
