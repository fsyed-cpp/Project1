import java.lang.SuppressWarnings;
import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>
{

    // MARK: - Properties
    private T[] bagObject; // array to store the element in the bags
    private int numOfEntries;
    private static final int DEFAULT_CAPACITY = 100;

    // additional variables to make the implementation secure
    private boolean initialized;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Default constructor:
     * create an empty bag with default capacity
     */
    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
        initialized = true;
    }

    /**
     * Creates an empty bag having a given initial capacity
     * @param capacity the integer capacity desired
     */
    public ResizableArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            //instructs the compiler to
            // precede a method definition or a variable declaration
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity]; //unchecked cast
            this.bagObject = tempBag;
            numOfEntries = 0;
            initialized = true;
        }
        else {
            checkCapacity(capacity);
        }
    }

    /** create a bag containing given entries of some bag
     * @param someBag An array of object
     */
    public ResizableArrayBag(T[] someBag)
    {
        checkCapacity(someBag.length);

        bagObject = Arrays.copyOf(someBag, someBag.length);
        numOfEntries = someBag.length;
    }

    // MARK: - Bag Interface Methods

    /**
     * get the number of size of the array bag
     * @return number of entries
     */
    @Override
    public int getCurrentSize()
    {
        return numOfEntries;
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
        return numOfEntries == bagObject.length;
    }

    /**
     * This method checks whether the bag is full
     * return boolean value.
     * If the bag is full, the program simply add new entry in the array bag
     */
    @Override
    public boolean add(T newEntry)
    {
        checkIntegrity();

        boolean result = true;
        if (isFull())
        {
           doubleCapacity();
        }

        bagObject[numOfEntries] = newEntry;
        numOfEntries++;

      return true;
    }

    /**
     * Removes one unspecified entry from the bag, if possible.
     * @return either the removed entry, if the removal was successful, or null otherwise.
     */
    @Override
    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numOfEntries-1);
        return result;
    }

    /**
     * Removes one occurrence of a given entry from the bag .
     * @param anEntry  The entry to be removed.
     * @return true if the removal was successful, or false if not.
     */
    @Override
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return false;
    }

    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear()
    {
        while(isEmpty())
        {
            remove();
        }

    }

    /**
     * count the number of times of an entry appears in the bag
     * @param anEntry  The entry to be counted.
     * @return number of frequency of entry in the bag
     */
    @Override
    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();

        int counter = 0;
        for (int index = 0; index < numOfEntries; index++)
        {
            if (anEntry.equals(bagObject[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Test whether this bag contains given entry.
     * @param anEntry . The entry to locate
     * @return True if this bag contains anEntry, or false otherwise.
     */
    @Override
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1; // or >=0
    }

    /**
     * retrieve the entries that are in a bag
     * @return entries to the client within the newly allocated array.
     */
    @Override
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
                T[] result = (T[]) new Object[numOfEntries]; // uncheck cast
        for (int index = 0; index < numOfEntries; index++)
        {
            result[index] = bagObject[index];
        }
        return result;
    }

    /**
     * This method does not alter either bag. The current bag and the second bag in the parameter
     * should be the same when the method ends.
     * @param secondBag
     * @return unionBag containing elements from 2 bags
     */
    @Override
    public BagInterface<T> union(BagInterface<T> secondBag)
    {
        BagInterface <T> unionBag = new ResizableArrayBag<>();
        ResizableArrayBag <T> otherBag = (ResizableArrayBag<T>) secondBag;

        int index;

        // add entries from this current object (bagObject) to the other bag
        for (index = 0; index < numOfEntries; index++)
            unionBag.add(bagObject[index]);

        // add entries from the second bag to the new bag
        for (index = 0; index < otherBag.getCurrentSize(); index++)
            unionBag.add(otherBag.bagObject[index]);

        return unionBag;
    }

    /**
     * Time Complexity: O(n * m) because we are iterating inside a nested loop
     * Space Complexity: O(n) because we are creating space for a new array from our bag
     * @param bag The bag we want to find the intersection with
     * @return a new bag containing the common items between both bags
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag)
    {

        // We must create a new bag to contain the intersection of both bags
        BagInterface<T> newBag = new ResizableArrayBag<T>(this.getCurrentSize());

        // Convert bag to array to get element at index
        T[] bagArray = bag.toArray();

        // Iterate through the given bag, and add the common items from the
        // current bag + passed bag into our new bag
        for (int i = 0; i < bag.getCurrentSize(); i++) {
            if (this.contains(bagArray[i])) {
                newBag.add(bagArray[i]);
            }
        }

        return newBag;
    }

    /**
     * Time Complexity: O(n * m) because we are iterating inside a nested loop
     * Space Complexity: O(n) because we are creating space for a new array from our bag
     * @param bag The bag we want to find the difference with
     * @return a new bag containing the difference of the items between both bags
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> bag) {

        // We must create a new bag to contain the difference of both bags
        BagInterface<T> newBag = this;

        // Convert bag to array to get element at index
        T[] bagArray = bag.toArray();

        // Iterate through the given bag, and add the common items from the
        // current bag + passed bag into our new bag
        for (int i = 0; i < bag.getCurrentSize(); i++) {
            if (this.contains(bagArray[i])) {
                newBag.remove(bagArray[i]);
            }
        }

        return newBag;
    }


    // Supplement methods:
    /**
     * Double the capacity of the array
     * Precondition: checkIntegrity has been called
     */
    private void doubleCapacity()
    {
        int newCapacity = 2* bagObject.length;
        checkCapacity(newCapacity);
        bagObject = Arrays.copyOf(bagObject, newCapacity);
    }


    /**
     * Locates a given entry within the array bag.
     * return the index of the entry, if located, or -1 otherwise
     * Precondition: checkIntegrity has been called
     */
    private int getIndexOf(T anEntry)
    {
        int indexLocation = -1;
        boolean found = false;
        int index = 0;

        while ((!found && index < numOfEntries))
        {
            if (anEntry.equals(bagObject[index]))
            {
                found = true;
                indexLocation = index;
            }
            index++;
        }
        return indexLocation;
    }

    /**
     * Removes and return the entry at a given index within the array bag
     * @param givenIndex
     * @return boolean value, if no such entry exits, return null.
     * preconditions: 0 <= givenIndex < numberOfEntries;
     * checkIntegrity has been called.
     */
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if(!isEmpty() && (givenIndex >= 0))
        {
            result = bagObject[givenIndex]; //entry to remove
            bagObject[givenIndex] = bagObject[numOfEntries - 1]; // replace entry with the last entry
            bagObject[numOfEntries - 1] = null; //remove last entry
            numOfEntries--;
        }
        return result;
    }

    /**
     * Throws an exception if this object is not initialized
     */
    private void checkIntegrity()
    {
        if(!initialized)
        {
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }

    /**
     * method to check the capacity of array
     * throw an exception if the capacity exceed MAX_CAPACITY
     */
    private void checkCapacity (int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException
                    ("Requested capacity exceeds maximum of " + MAX_CAPACITY + ".");
        }
    }
}
