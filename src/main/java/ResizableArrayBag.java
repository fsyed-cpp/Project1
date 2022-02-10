//import java.util.ArrayList;
import java.lang.SuppressWarnings;
import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T> {

    // MARK: - Properties
    // needed variables
    private T[] bagObject; // array to store the element in the bags
    private int numOfEntries;
    private static final int DEFAULT_CAPACITY = 100;
    private static final int MAX_CAPACITY = 10000;
    private boolean initialized = false;

    // MARK: Constructor
    /**
     * create an empty bag with default capacity
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity
     * @param capacity the integer capacity desired
     */
    public ResizableArrayBag(int capacity)
    {
        // needed method to check capacity

        // @SuppressWarnings("unchecked") instructs the compiler to
        // precede a method definition or a variable declaration
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        this.bagObject = tempBag;
        numOfEntries = 0;
        initialized = true;
    }

    /** create a bag containing given entries of some bag
     * @param someBag An array of object
     */
    public ResizableArrayBag(T[] someBag)
    {
        // needed method to check capacity

        bagObject = Arrays.copyOf(someBag, someBag.length);
        numOfEntries = someBag.length;
        initialized = true;
    }

    // MARK: - Bag Interface Methods

    @Override
    public int getCurrentSize()
    {
        return this.bagObject.length;
    }

    /**
     * Check if it empty
     * @return boolean value
     */
    @Override
    public boolean isEmpty() {
        return this.bagObject.length == 0;
    }

    /**
     * check is the bag is full
     * @return true if the array bag is full, or false if not
     */
    public boolean isFull()
    {
        return numOfEntries >= bagObject.length;
    }

    @Override
    public boolean add(T newEntry)
    {
        bagObject[numOfEntries] = newEntry;
        numOfEntries++;
      return true;
    }

    /**
     * TODO -> Implement the logic for the following Resizable Array Bag methods
     */

    @Override
    public T remove()
    {
        return null;
    }

    @Override
    public boolean remove(T anEntry)
    {
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
    public boolean contains(T anEntry)
    {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag)
    {

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

    // TODO...
    // CODE FOR THROW EXCEPTIONS IN DIFFERENT CASES:

    private void checkIfInitialized()
    {

    }




}
