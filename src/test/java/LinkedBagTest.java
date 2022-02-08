import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is responsible for testing all the functionality of the LinkedList implementation of the Bag
 * @param <T> We use generic type since the class uses Generic type T
 * setup() is responsible for creating stub data for some test methods below
 * We use an Integer implementation of our Bag and Node for other test cases
 */
class LinkedBagTest<T> {

    // MARK: - Setup

    LinkedBag<T> linkedBag;

    @BeforeEach
    void setup() {

        // Stub data
        Node<T> thirdNode = new Node(3, null);
        Node<T> secondNode = new Node(3, thirdNode);
        Node<T> headNode = new Node(4, secondNode);

        linkedBag = new LinkedBag<T>(headNode);
    }

    // MARK: - Test Cases

    @Test
    void testGetCurrentSize() {

        // Arrange
        int expectedBagSize = 3;

        // Act
        int bagSize = linkedBag.getCurrentSize();

        // Assert
        assertEquals(expectedBagSize, bagSize);
    }

    @Test
    void testIsEmpty() {

        // Arrange + Act
        boolean isBagEmpty = linkedBag.isEmpty();

        // Assert
        assertFalse(isBagEmpty);
    }

    @Test
    void testAdd() {

        // Arrange
        Node<Integer> secondNode = new Node(3, null);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        intLinkedBag.add(5);

        // Assert
        assertTrue(intLinkedBag.contains(5));
    }

    @Test
    void testRemove() {

        // Arrange
        Node<Integer> secondNode = new Node(3, null);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        intLinkedBag.remove(3);

        // Assert
        assertFalse(intLinkedBag.contains(3));
    }

    @Test
    void testClear() {

        // Arrange
        Node<Integer> secondNode = new Node(3, null);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        intLinkedBag.clear();

        // Assert
        assertTrue(intLinkedBag.isEmpty() == true);
        assertTrue(intLinkedBag.getCurrentSize() == 0);
    }

    @Test
    void testGetFrequencyOf() {

        // Arrange
        Node<Integer> lastNode = new Node(3, null);
        Node<Integer> thirdNode = new Node(1, lastNode);
        Node<Integer> secondNode = new Node(3, thirdNode);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        int frequencyOf3 = intLinkedBag.getFrequencyOf(3);

        // Assert
        assertEquals(frequencyOf3, 2);
    }

    @Test
    void testContains() {

        // Arrange
        Node<Integer> secondNode = new Node(3, null);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        boolean bagContains3 = intLinkedBag.contains(3);

        // Assert
        assertTrue(bagContains3);
    }

    @Test
    void testToArray() {

        // Arrange
        Node<Integer> secondNode = new Node(3, null);
        Node<Integer> headNode = new Node(4, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);

        // Act
        Integer[] arrayBag = intLinkedBag.toArray();

        // Assert
        assertEquals(arrayBag[0], 4);
        assertEquals(arrayBag[1], 3);
    }

    // TODO: Create test cases...

    @Test
    void union() {
    }

    @Test
    void intersection() {
    }

    @Test
    void difference() {
    }

}