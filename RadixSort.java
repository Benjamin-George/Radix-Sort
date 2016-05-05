/**
 * <h1><LeastSignificantDigit Radix Sort</h1>
 * Each integer is first figuratively dropped into one level of buckets corresponding to the value of the rightmost digit.
 * Each bucket preserves the original order of the integers as the integers are dropped into the bucket.
 * There is a one-to-one relationship between the buckets and the values, represented by the rightmost digit.
 * Then, the process repeats with the next significant digit until there are no more digits to process.
 * In other words:
 * -Take the least significant digit (or group of bits, both being examples of radices) of each integer.
 * -Group the integers based on that digit, but otherwise keep the original order of integers.
 * -Repeat the grouping process with each more significant digit.
 * -Hybridizing the final steps can improve performance (but is not needed for this assignment)
 *
 *
 * @author Jean-Paul Labadie
 * @since 11-20-2015
 */
public interface RadixSort {

    /**
     * This method should re-initialize your RadixSort, clearing all data structures and resetting variables
     */
    void init();

    /**
     * Run a full RadixSort (LSD variant) on the input int array.
     * The array should be modified so that no return is needed.
     *
     * @param input int array for sorting, modify this input array
     * @param max_significant_digits the maximum amount of digits in any given input in the array
     */
    void sortRadixLSD(int[] input, int max_significant_digits);

    /**
     * Run a single pass of RadixSort, allowing us to step through the process.
     * Checks to the input array after each sorting pass should show increasingly semi-sorted data.
     * @param input the input array (no max_significant_digit is needed as we manually loop).
     */
    void sortRadixLSDOnePass(int[] input);
}
