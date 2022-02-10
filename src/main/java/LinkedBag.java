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

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    /** Sees whether this bag is empty.
     * @return True if this bag is empty, or false if not. */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    /** Adds a new entry to this bag.
     * @param newEntry the object to be added as a new entry
     * @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
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
    public void clear() {
        while (!isEmpty())
            remove();
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
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
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = (T) currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
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
