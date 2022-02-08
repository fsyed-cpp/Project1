import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void getCurrentSize() {

        // Arrange
        int expectedBagSize = 3;

        // Act
        int bagSize = linkedBag.getCurrentSize();

        // Assert
        assertEquals(expectedBagSize, bagSize);
    }

    @Test
    void isEmpty() {

        // Arrange + Act
        boolean isBagEmpty = linkedBag.isEmpty();

        // Assert
        assertFalse(isBagEmpty);
    }

    @Test
    void add() {
        
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }

    @Test
    void getFrequencyOf() {
    }

    @Test
    void contains() {
    }

    @Test
    void toArray() {
    }

    @Test
    void union() {
    }

    @Test
    void intersection() {
    }

    @Test
    void difference() {
    }

    // TODO: Create test cases...
}