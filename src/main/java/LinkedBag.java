/**
 * The Linked List representation of our bag that implements the Bag interface
 *
 * @param <T>
 */

public class LinkedBag<T> implements BagInterface<T>
{

    // MARK: - Properties
    private Node<T> firstNode;
    private int numberOfEntries;

    // MARL: - Constructor

    public LinkedBag(Node<T> firstNode)
    {
        numberOfEntries = 0;
        this.firstNode = firstNode;
    }

    // MARK: - Bag Interface methods

    /**
     * TODO -> Implement the logic for all the Linked Bag methods
     */

    @Override
    /** Gets the current number of entries in this bag.
     @return  The integer number of entries currently in the bag. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    @Override
    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or false if not. */
    public boolean add(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal was successful, or null. */
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    private Node<T> getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            } else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    @Override
    /** Removes one occurrence of a given entry from this bag, if possible.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null)
        {
            nodeN.setData((firstNode.getData()));
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    @Override
    /** Removes all entries from this bag. */
    public void clear()
    {
        while (!isEmpty())
            remove();
    }

    @Override
    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int counter = 0;
        Node<T> currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    @Override
    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to find.
     @return  True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            } else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    @Override
    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> otherBag)
    {
        BagInterface<T> unionBag = new LinkedBag<>(null);
        T[] firstBagContents = this.toArray();
        T[] secondBagContents = otherBag.toArray();
        /*for (int i = 0; i < firstBagContents.length; i++) {
            unionBag.add(firstBagContents[i]);
        }
        for (int i = 0; i < secondBagContents.length; i++) {
            unionBag.add(secondBagContents[i]);
        }*/
        Node<T> firstStart = this.firstNode;
        Node<T> secondStart = this.firstNode;
        int counter = 0;
        while (firstStart != null && counter < this.getCurrentSize()) {
            unionBag.add(firstStart.data);
        }
        while (secondStart != null && counter < this.getCurrentSize()) {
            unionBag.add(secondStart.data);
        }
        firstStart = firstStart.next;
        secondStart = secondStart.next;
        counter++;
        return unionBag;
    }

    /**
     * Time Complexity: O(n^2) because we are iterating through our second bag inside our first bag traversal
     * Space Complexity O(1) because we are creating a new bag with the collection of both items
     * @param bag The bag which we would like to find the common items with
     * @return a new bag object containing the common items from both bags
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag) {

        // Create a new bag to return with the common items
        BagInterface<T> newBag = new LinkedBag<T>(null);

        // Get the starting position for our current bag and use a counter to keep track + safeguard
        Node<T> current = this.firstNode;
        int counter = 0;

        // Traverse through our bag and for each value, check if the passed in bag contains this item
        while (current != null && counter < this.getCurrentSize()) {
            if (bag.contains(current.data)) {
                newBag.add(current.data);
            }
            current = current.next;
            counter++;
        }

        return newBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> bag)
    {
        return null;
    }
}
