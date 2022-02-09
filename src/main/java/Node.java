/**
 * Stores the raw value that will be stored and tracked in our Bag implementations
 * @param <T> Represents the generic data type that will hold the value of our Node
 */
public class Node<T>
{

    // MARK: - Properties

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
