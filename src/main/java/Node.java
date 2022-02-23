/**
 * Stores the raw value that will be stored and tracked in our Bag implementations
 * @param <T> Represents the generic data type that will hold the value of our Node
 */
public class Node<T>
{
    // MARK: - Properties

    public T data;
    public Node<T> next;

    // MARK: - Constructor

    Node(T dataPortion) {
        this(dataPortion, null);
    }
    Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }
    T getData() {
        return data;
    }
    void setData(T newData) {
        data = newData;
    }
    Node<T> getNextNode() {
        return next;
    }
    void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }
}
