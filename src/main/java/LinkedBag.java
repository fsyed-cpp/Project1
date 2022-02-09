/**
 * The Linked List representation of our bag that implements the Bag interface
 * @param <T>
 */

public class LinkedBag<T> implements BagInterface<T>
{

    // MARK: - Properties
    private Node firstNode;
    private int numberOfEntries;
    Node head;

    // MARL: - Constructor

    public LinkedBag(Node head)
    {
        firstNode = null;
        numberOfEntries = 0;
        this.head = head;
    }

    private class Node
    {
        private T data;
        private Node next;

        // MARK: - Constructor

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
        private T getData()
        {
            return data;
        }
        private void setData(T newData)
        {
            data = newData;
        }
        private Node getNextNode()
        {
            return next;
        }
        private void netNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }

    // MARK: - Bag Interface methods

    /**
     * TODO -> Implement the logic for all the Linked Bag methods
     */

    public void union()
    {

    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag) {
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> bag) {
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag) {
        return null;
    }
}
