/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     * 
     * ASSUMPTIONS:
     * - You may assume that the data is not null.
     *
     * @param data the data to add to the back of the list
     */
    public void addToBack(T data) {

        // Init new node
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        SinglyLinkedListNode<T> curr = tail;

         // Edge case: Empty list:
        if (curr == null) {
            head = newNode;
        }
        else {
            curr.setNext(newNode);
        }

        tail = newNode;

        size++;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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