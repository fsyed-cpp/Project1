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
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    /* Sees whether this bag is empty.
     * @return True if this bag is empty, or false if not. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    @Override
    /* Adds a new entry to this bag.
     * @param newEntry the object to be added as a new entry
     * @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
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
    public void clear()
    {
        while (!isEmpty())
            remove();
    }

    @Override
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
        /*T[] firstBagContents = this.toArray();
        T[] secondBagContents = otherBag.toArray();
        BagInterface<T> unionBag = new LinkedBag<>(firstNode);
        for (int i = 0; i < firstBagContents.length; i++) {
            unionBag.add(firstBagContents[i]);
        }
        for (int i = 0; i < secondBagContents.length; i++) {
            unionBag.add(secondBagContents[i]);
        }
        return unionBag;*/
        BagInterface<T> bag1 = new LinkedBag<T>(null);
        T[] bag2 = otherBag.toArray();
        for (T elem : bag2)
        {
            bag1.add(elem);
        }
        T[] first = this.toArray();
        for (T elem: first){
            bag1.add(elem);
        }
        return bag1;
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
