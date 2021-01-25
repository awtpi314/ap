package ap.week19;

import java.util.ArrayList;

/**
 * NumberArrayList
 */
public class NumberArrayList {
    ArrayList<Integer> randomArray;
    ArrayList<Integer> evenArray;
    ArrayList<Integer> brokenArray;

    public NumberArrayList(int n) {
        randomArray = new ArrayList<Integer>();
        evenArray = new ArrayList<Integer>();
        brokenArray = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            randomArray.add(generateRandomNumber(0, n));
            evenArray.add(2 * (i + 1));
        }

        for (int i = 0; i < n; i++) {
            brokenArray.add(generateRandomNumber(0, n / 2));
        }
    }

    public void display() {
        int mode;
        String result = "";

        /* testing with randomArray */

        System.out.println("random array list: " + randomArray);
        result += String.format("%-30s%d\n", "The sum is:", findSum(randomArray));
        result += String.format("%-30s%.3f\n", "The average is;", ((double) findSum(randomArray)) / randomArray.size());
        result += String.format("%-30s%d\n", "The highest in the array:", findHighest(randomArray));
        result += String.format("%-30s%d\n", "The lowest in the array:", findLowest(randomArray));
        result += String.format("%-30s%d\n", "consecutive pair:", findConsecutivePair(randomArray));
        result += String.format("%-30s%d\n", "longest consecutive value: ", findLongestConsecutive(randomArray));
        mode = findMode(randomArray);
        result += String.format("%-30s%d\n", "mode:", mode);
        System.out.println(result);

        // sort the random array
        insertionSort(randomArray);
        System.out.println("Sorted array:\t\t" + randomArray);

        // remove consecutive duplicates
        System.out.println("remove consecutive duplicates:\t" + removeConsecutiveDuplicates(randomArray));

        // remove all mode values from the ArrayList
        removeAll(randomArray, mode);
        System.out.println("remove all mode:\t" + randomArray);

        /* testing with evenArray */

        // display results with evenArray
        System.out.println("\neven array:\t\t\t" + evenArray);
        System.out.println("ReversedArray:\t\t" + reversedArray(evenArray));

        // generate a random shifter in [0, size)
        int shifter = generateRandomNumber(0, evenArray.size() - 1);
        System.out.println("Shifter = " + shifter);
        System.out.println("EvenArray gets Rotated: " + rotatedArray(evenArray, shifter));

        // shuffle
        shuffle(evenArray);
        System.out.println("after being shuffled:\t" + evenArray);

        // testing merryGoRound
        int currentIndex = generateRandomNumber(0, evenArray.size() - 1);
        System.out.println("\nmerryGoRound currentIndex = " + currentIndex);
        System.out.println("endIndex = " + merryGoRound(evenArray, currentIndex));
        System.out.println("merryGoRound:\t\t\t\t" + evenArray);

        /* testing with brokenArray */
        System.out.println("\nbrokenArray:\t\t\t\t" + brokenArray);
        consolidate(brokenArray);
        System.out.println("After consolidation:\t\t" + brokenArray);
    }

    public int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        return (int) (range * Math.random() + min);
    }

    /**
     * <p>
     * findSum returns the sum of all the elements in the passed
     * {@link java.util.ArrayList ArrayList}
     * </p>
     * 
     * @param array the array to sum
     * @return the sum of all the elements
     */
    public int findSum(ArrayList<Integer> array) {
        int sum = 0;

        for (int n : array) {
            sum += n;
        }

        return sum;
    }

    /**
     * <p>
     * findHighest is a method to find the highest number in the passed
     * {@link java.util.ArrayList ArrayList}
     * </p>
     * 
     * @param array the array to process
     * @return the highest number in the array
     */
    public int findHighest(ArrayList<Integer> array) {
        int highest = Integer.MIN_VALUE;

        for (int n : array) {
            if (n > highest) {
                highest = n;
            }
        }

        return highest;
    }

    /**
     * <p>
     * findLowest is a method to find the lowest number in the passed
     * {@link java.util.ArrayList ArrayList}
     * </p>
     * 
     * @param array the array to process
     * @return the lowest number in the array
     */
    public int findLowest(ArrayList<Integer> array) {
        int lowest = Integer.MAX_VALUE;

        for (int n : array) {
            if (n < lowest) {
                lowest = n;
            }
        }

        return lowest;
    }

    /**
     * <p>
     * findConsecutivePair searches the input array for the first occurrence of two
     * consecutive numbers
     * </p>
     * 
     * @param array the array to search
     * @return the first consecutive pair in the array
     */
    public int findConsecutivePair(ArrayList<Integer> array) {
        int length = array.size();
        for (int i = 1; i < length; i++) {
            if (array.get(i) == array.get(i - 1)) {
                return array.get(i);
            }
        }

        return -1;
    }

    /**
     * <p>
     * findLongestConsecutive iterates through the entire array and finds the number
     * that has the most consecutive occurences in the passed
     * {@link java.util.ArrayList ArrayList}.
     * </p>
     * 
     * @param array
     * @return
     */
    public int findLongestConsecutive(ArrayList<Integer> array) {
        int longestConsecutive = array.get(0);
        int size = 1;

        int currentConsecutive = array.get(0);
        int currentSize = 1;

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) == currentConsecutive) {
                currentSize++;
            } else {
                currentConsecutive = array.get(i);
                currentSize = 1;
            }

            if (currentSize > size) {
                size = currentSize;
            }
        }

        if (size == 1) {
            return -1;
        }

        return longestConsecutive;
    }

    /**
     * findMode finds the element in the list that occurs most frequently.
     * 
     * @param array {@link java.util.ArrayList ArrayList<Integer>}
     * @return the item which occurs most frequently
     */
    public int findMode(ArrayList<Integer> array) {
        int modeCount = 0;
        int mode = 0;

        int currentCount = 0;

        for (int candidate : array) {
            currentCount = 0;

            for (int comparator : array) {
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
     * insertionSort take modifies the passed {@link java.util.ArrayList ArrayList}
     * and sorts it increasingly.
     * 
     * @param array the list to sort
     */
    public void insertionSort(ArrayList<Integer> array) {
        int size = array.size();

        for (int i = 1; i < size; i++) {
            int key = array.get(i);

            int j = i - 1;
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j--;
            }

            array.set(j + 1, key);
        }
    }

    /**
     * removeConsecutiveDuplicates searches the array for consecutive duplicates and
     * removes them. This method does not change the parameter, and instead returns
     * a new temporary {@link java.util.ArrayList ArrayList}
     * 
     * @param array the array to search
     * @return an {@link java.util.ArrayList ArrayList} that contains the contents
     *         of the parameter, minus the consecutive duplicates
     */
    public ArrayList<Integer> removeConsecutiveDuplicates(ArrayList<Integer> array) {
        if (array == null)
            return null;

        // make a copy of array
        ArrayList<Integer> temp = new ArrayList<Integer>(array);

        int i = 1;
        while (i < temp.size()) {
            if (temp.get(i) == temp.get(i - 1)) {
                temp.remove(i);
            } else {
                i++;
            }
        }

        return temp;
    }

    /**
     * removeAll searches the passed {@link java.util.ArrayList ArrayList} for all
     * occurences of the key.
     * 
     * @param array the array to search and modify
     * @param key   the integer to search for and remove from the
     *              {@link java.util.ArrayList ArrayList}
     */
    public void removeAll(ArrayList<Integer> array, int key) {
        int i = 0;
        while (i < array.size()) {
            if (array.get(i) == key) {
                array.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * reversedArray returns the reverse of the passed {@link java.util.ArrayList
     * ArrayList}. This method does not change the parameter array, but rather makes
     * a new ArrayList.
     * 
     * @param array the array to reverse
     * @return the reversed {@link java.util.ArrayList ArrayList}
     */
    public ArrayList<Integer> reversedArray(ArrayList<Integer> array) {
        ArrayList<Integer> tempArray = new ArrayList<>();

        array.forEach((Integer n) -> {
            tempArray.add(0, n);
        });

        return tempArray;
    }

    /**
     * rotatedArray returns an {@link java.util.ArrayList ArrayList} that is shifted
     * the passed number of positions. This method does not change the input
     * ArrayList.
     * 
     * @param array   the array to shift
     * @param shifter the amount to shift the array
     * @return the rotated ArrayList
     */
    public ArrayList<Integer> rotatedArray(ArrayList<Integer> array, int shifter) {
        ArrayList<Integer> tempArray = new ArrayList<Integer>(array.size());

        for (int i = 0, j = array.size() - shifter; i < array.size(); i++, j = normalizeSize(++j, array.size())) {
            tempArray.add(i, array.get(j));
        }

        return tempArray;
    }

    /**
     * shuffle moves the elements of the array to random other position
     * 
     * @param array the array to shuffle
     */
    public void shuffle(ArrayList<Integer> array) {
        int length = array.size();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * length);

            int temp = array.get(i);
            array.set(i, array.get(randomIndex));
            array.set(randomIndex, temp);
        }
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
     * @param array        the array to distribute
     * @param currentIndex the index to pull "candies" from
     * @return the end index
     */
    public int merryGoRound(ArrayList<Integer> array, int currentIndex) {
        int length = array.size();
        int loopTimes = array.get(currentIndex) - 1;
        array.set(currentIndex, 0);

        for (int i = 0, j = currentIndex + 1; i < loopTimes; i++, j = normalizeSize(++j, length)) {
            array.set(j, array.get(j) + 1);
        }

        return normalizeSize(loopTimes + currentIndex + 1, length);
    }

    /**
     * consolidated takes an {@link java.util.ArrayList ArrayList} and moves all the
     * non-zero elements to the left of the array. Any zeros will be left at the end
     * of the array.
     * 
     * @param array the array to consolidate
     */
    public void consolidate(ArrayList<Integer> array) {
        ArrayList<Integer> consolidated = new ArrayList<>();
        int consolidatedIndex = 0;

        for (int n : array) {
            if (n != 0) {
                consolidated.add(consolidatedIndex++, n);
            } else {
                consolidated.add(0);
            }
        }

        for (int i = 0; i < array.size(); i++) {
            array.set(i, consolidated.get(i));
        }
    }

    /**
     * normalizeSize takes an integer index and length and moves the index within
     * the bounds of length.
     * 
     * @param index  the index to normalize
     * @param length the length of the array
     * @return the normalized index
     */
    public int normalizeSize(int index, int length) {
        if (index >= length) {
            return index % length;
        } else {
            return index;
        }
    }
}