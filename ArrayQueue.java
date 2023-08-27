import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Helper function to resize (if necessary) and create temporary array
     */
    private T[] temporaryArray(T[] bArray) {

        // Init an empty array with double the capacity
        T[] tempArray = (T[]) new Object[bArray.length * 2];
        int arrayIndex = 0;

        // Populate current array from Front to Back
        for (int i = front; i < bArray.length; i++) {
            tempArray[arrayIndex] = bArray[i];
            arrayIndex++;
        }

        // Populate current array from Start to Front
        for (int i = 0; i < front; i++) {
            tempArray[arrayIndex] = bArray[i];
            arrayIndex++;
        }

        // Populate unused positions with null
        while (arrayIndex < tempArray.length) {
            tempArray[arrayIndex] = null;
            arrayIndex++;
        }

        // Reset front index
        front = 0;

        return tempArray;
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {

        // Edge case: Null parameter data
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Error: Data is null.");
        }

        // Init back index
        int back = front + size;

        // Check if sufficient capacity exists
        if (back > backingArray.length) {
            T[] tempArray = temporaryArray(backingArray);

            // Assign new value to back
            tempArray[back] = data;

            // Re-assign array
            backingArray = tempArray;
        }

        else {
            // Assign new value to back
            backingArray[back] = data;
        }

        // Increment size by 1
        size ++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {

        // Edge case:
        if (size == 0) {
            throw new java.util.NoSuchElementException("Error: List is empty.");
        }

        // Store front element
        T frontElement = backingArray[front];

        // Assign null
        backingArray[front] = null;

        // Decrement size and increment front index
        size--;
        front++;

        // Edge case: Front index wrap around
        if (front == backingArray.length) {
            front = 0;
        }

        return frontElement;
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}