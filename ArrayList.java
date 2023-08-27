import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * Helper function to create temporary array
     */
    private T[] tempArray(int size, T[] bArray) {

        // Init array
        T[] tempArray;

        // Check if sufficient capacity exists
        if ((size + 1) > bArray.length) {
            // Init an empty array with double the capacity
            tempArray = (T[]) new Object[bArray.length * 2];
        }
        else {
            // Init an empty array
            tempArray = (T[]) new Object[bArray.length];
        }

        return tempArray;
    }

    /**
     * Helper function to assign null to unused posititons of an array
     */
    private T[] fillNull(int size, T[] tempArray) {
        // Init array size
        int i = size;

        // Iterate through array starting at last element index
        while (i < tempArray.length) {
            tempArray[i] = null;
            i ++;
        }

        return tempArray;
    }

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {

        // Edge case:
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Error: Data is null.");
        }

        // Check if sufficient capticity exists
        T[] tempArray = tempArray(size, backingArray);

        // Add to front of array
        tempArray[0] = data;

        // Copy elements
        for (int i = 0; i < size ; i++) {
            tempArray[i + 1] =  backingArray[i];
        }

        // Increment size
        size++;

        // Assign null to unused positions
        tempArray = fillNull(size, tempArray);

        // Re-assign array
        backingArray = tempArray;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {

        // Edge case:
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Error: Data is null.");
        }
        
        // Check if sufficient capticity exists
        T[] tempArray = tempArray(size, backingArray);

        // Copy data
        for (int i = 0; i < size ; i++) {
            tempArray[i] =  backingArray[i];
        }

        // Add to back of array
        tempArray[size] = data;

        // Increment size
        size++;

        // Assign null to unused positions
        tempArray = fillNull(size, tempArray);
        
        // Re-assign array
        backingArray = tempArray;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {

        // Edge case:
        if (size == 0) {
            throw new java.util.NoSuchElementException("Error: List is empty.");
        }

        // Init empty array
        T[] tempArray = (T[]) new Object[backingArray.length];

        // Copy elements
        for (int i = 1; i < size ; i++) {
            tempArray[i - 1] =  backingArray[i];
        }

        // Last Item
        T firstItem = backingArray[0];

        // Assign last index to null
        tempArray[size - 1] = null;

        // Decrement size
        size--;

        // Re-assign array
        backingArray = tempArray;

        return firstItem;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {

        // Edge case:
        if (size == 0) {
            throw new java.util.NoSuchElementException("Error: List is empty.");
        }

        // Last Item
        T lastItem = backingArray[size - 1];

        // Assign last index to null
        backingArray[size - 1] = null;

        // Decrement size
        size--;

        return lastItem;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}