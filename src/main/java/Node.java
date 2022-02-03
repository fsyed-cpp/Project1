/**
 * Stores the raw value that will be stored and tracked in our Bag implementations
 * @param <T> Represents the generic data type that will hold the value of our Node
 */
public class Node<T> {

    // MARK: - Properties

    T value;
    Node<T> next;

    // MARK: - Constructor

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
