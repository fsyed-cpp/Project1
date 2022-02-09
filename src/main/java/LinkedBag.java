/**
 * The Linked List representation of our bag that implements the Bag interface
 * @param <T>
 */

public class LinkedBag<T> implements BagInterface<T>
{

    // MARK: - Properties
    private Node<T> firstNode;
    private int numberOfEntries;
    Node<T> head;

    // MARL: - Constructor

    public LinkedBag(Node<T> head)
    {
        firstNode = null;
        numberOfEntries = 0;
        this.head = head;
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
