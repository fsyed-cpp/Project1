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
        Node<Object> secondNode = new Node(3, null);
        Node<Object> headNode = new Node(4, secondNode);
        LinkedBag<Object> intLinkedBag = new LinkedBag<Object>(headNode);

        // Act
        Object[] arrayBag = intLinkedBag.toArray();

        // Assert
        assertEquals(arrayBag[0], 4);
        assertEquals(arrayBag[1], 3);
    }
    
    /**
     * A Union is defined as the joint items from both collections.
     * We have intLinkedBag with items [3, 4]
     * We have intLinkedBag2 with items [5,6]
     * The union of both bags (intLinkedBag U intLinkedBag2) -> [3, 4, 5, 6]
     */
    @Test
    void testUnion() {

        // Arrange
        Node<Integer> secondNode = new Node(4,null);
        Node<Integer> headNode = new Node(3, secondNode);
        LinkedBag<Integer> intLinkedBag = new LinkedBag<Integer>(headNode);
        intLinkedBag.add(3);
        intLinkedBag.add(4);

        Node<Integer> anotherSecondNode = new Node(6,null);
        Node<Integer> anotherHeadNode = new Node(5, anotherSecondNode);
        LinkedBag<Integer> intLinkedBag2 = new LinkedBag<Integer>(anotherHeadNode);
        intLinkedBag2.add(5);
        intLinkedBag2.add(6);

        // Act
        BagInterface<Integer> everything = intLinkedBag.union(intLinkedBag2);

        // Assert
        assertFalse(everything.contains(3));
        assertFalse(everything.contains(4));
        assertFalse(everything.contains(5));
        assertFalse(everything.contains(6));
    }

    /**
     * An Intersection is defined as the collection of items that occur in both collections
     * We have intLinkedBag with items [3, 4]
     * We have intLinkedBag2 with items [5, 3]
     * The Intersection of both Bags should be [3] since '3' occurs in both bags
     */
    @Test
    void testIntersection() {

        // Arrange
        Node<Object> headNode = new Node(4, null);
        LinkedBag<Object> intLinkedBag = new LinkedBag<Object>(headNode);
        intLinkedBag.add(3);

        Node<Object> anotherHeadNode = new Node(5, null);
        LinkedBag<Object> intLinkedBag2 = new LinkedBag<Object>(anotherHeadNode);
        intLinkedBag2.add(3);

        // Act
        BagInterface<Object> everything = intLinkedBag.intersection(intLinkedBag2);

        // Assert
        assertTrue(everything.contains(3));
        assertFalse(everything.contains(4));
        assertFalse(everything.contains(5));
    }

    /**
     * A Difference is defined as the leftover items in a collection after removing the items that occur in the second collection.
     * We have intLinkedBag with [4, 3, 5]
     * We have intLinkedBag2 with [5, 3]
     * The leftover ([4, 3, 5] - [5, 3]) should be [4] since 3 and 5 occur in both collections.
     */
    @Test
    void testDifference() {

        // Arrange
        Node<Object> headNode = new Node(4, null);
        LinkedBag<Object> intLinkedBag = new LinkedBag<Object>(headNode);
        intLinkedBag.add(3);
        intLinkedBag.add(5);

        Node<Object> anotherHeadNode = new Node(5, null);
        LinkedBag<Object> intLinkedBag2 = new LinkedBag<Object>(anotherHeadNode);
        intLinkedBag2.add(3);

        // Act
        BagInterface<Object> leftover = intLinkedBag.difference(intLinkedBag2);

        // Assert
        assertTrue(leftover.contains(4));
        assertFalse(leftover.contains(3));
        assertFalse(leftover.contains(5));
    }
}