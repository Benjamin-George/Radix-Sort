import java.lang.Math;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.commons.lang3.ArrayUtils;

public class MyRadixSort implements RadixSort {
    private int digitCount = 0;

    @SuppressWarnings("unchecked")
    private LinkedList<Integer>[] buckets = new LinkedList[10];

    //initialize all of the 'buckets' that input numbers will be dropped into
    public void init() {
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void sortRadixLSD(int[] input, int max_significant_digits) {

        //create an arrayList and fill it with all of the ints (converted to Integers) from input
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int i: input) {
            inputList.add(i);
        }

        for (int i = 0; i < max_significant_digits; i++) { //a loop to iterate over each digit in the input

            for (Integer j: input) {
                //store the current number into a temp variable
                int current = j;

                //cut the temp variable down to the relevant digit
                current = current % (int)(Math.pow(10, i + 1));
                current = current / (int)(Math.pow(10, i));

                //drop the current number into the bucket corresponding to the digit
                buckets[current].add(j);

            }

            inputList.clear(); //clear out the inputList to drop numbers into it from the buckets

            //go through each of the buckets and drop all of their contents back into the inputList
            for (int k = 0; k < 10; k++) {
                LinkedList<Integer> currentBucket = buckets[k];

                //add all contents from the current bucket into the inputList
                while (!currentBucket.isEmpty()) {
                    inputList.add(currentBucket.remove(0));
                }
            }

            //go through some type conversion shenanigans to convert the ArrayList of Integers to an array of ints
            Integer[] tempInt = new Integer[inputList.size()];
            inputList.toArray(tempInt);
            int[] tempArr = ArrayUtils.toPrimitive(tempInt);
            System.arraycopy(tempArr, 0, input, 0, tempArr.length);
        }
    }

    //perform a single iteration of the radix sort, sorting based on the amount of digits that have been sorted
    public void sortRadixLSDOnePass(int[] input) {
        sortRadixLSD(input, ++digitCount);
    }
}
