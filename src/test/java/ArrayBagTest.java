import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is responsible for testing all the functionality of the ResizableArray implementation of the Bag
 * setup() is responsible for creating the stub array for some test methods below
 * We use an Integer implementation of our Bag for the array
 */
class ArrayBagTest {

    // MARK: - Setup

    ResizableArrayBag<Integer> arrayBag;

    @BeforeEach
    void setup() {
        arrayBag = new ResizableArrayBag<Integer>(10);
    }

    // MARK: - Test Cases

    @Test
    void testGetCurrentSize() {

        // Arrange
        for (Integer i = 0; i < 3; i++) {
            arrayBag.add(i);
        }

        // Act
        int arrayCount = arrayBag.getCurrentSize();

        // Assert
        assertEquals(arrayCount, 3);
    }

    @Test
    void testIsEmpty() {

        // Arrange
        ResizableArrayBag emptyArrayBag = new ResizableArrayBag(0);
        ResizableArrayBag nonEmptyArrayBag = new ResizableArrayBag(10);
        nonEmptyArrayBag.add(3);

        // Act
        boolean isEmptyArrayBagEmpty = emptyArrayBag.isEmpty();
        boolean isNonEmptyArrayBagEmpty = nonEmptyArrayBag.isEmpty();

        // Assert
        assertTrue(isEmptyArrayBagEmpty);
        assertFalse(isNonEmptyArrayBagEmpty);
    }

    @Test
    void testIsFull() {

        // Arrange
        ResizableArrayBag fullArrayBag = new ResizableArrayBag(2);
        fullArrayBag.add(1);
        fullArrayBag.add(2);

        // Act
        boolean isFull = fullArrayBag.isFull();

        // Assert
        assertTrue(isFull);
    }

    @Test
    void testAdd() {

        // Arrange
        arrayBag.add(5);
        arrayBag.add(2);
        arrayBag.add(3);

        // Act
        boolean contains2 = arrayBag.contains(2);

        // Assert
        assertTrue(contains2);
    }

    @Test
    void testRemove() {

        // Arrange
        arrayBag.add(2);
        arrayBag.add(3);

        // Act
        arrayBag.remove(3);
        arrayBag.remove(2);

        // Assert
        assertTrue(arrayBag.isEmpty());
    }

    @Test
    void testClear() {

        // Arrange
        arrayBag.add(1);
        arrayBag.add(2);
        arrayBag.add(3);

        // Act
        arrayBag.clear();

        // Assert
        assertTrue(arrayBag.isEmpty());
    }

    @Test
    void testGetFrequencyOf() {

        // Arrange
        arrayBag.add(1);
        arrayBag.add(2);
        arrayBag.add(2);
        arrayBag.add(3);

        // Act
        int frequencyOf2 = arrayBag.getFrequencyOf(2);

        // Assert
        assertEquals(frequencyOf2, 2);
    }

    @Test
    void testContains() {

        // Arrange
        arrayBag.add(1);
        arrayBag.add(6);
        arrayBag.add(2);

        // Act
        boolean contains6 = arrayBag.contains(6);

        // Assert
        assertTrue(contains6);
    }

    @Test
    void testToArray() {

        // Arrange
        arrayBag.add(1);
        arrayBag.add(2);
        arrayBag.add(3);

        // Act
        Object[] toArray = arrayBag.toArray();

        // Assert
        assertEquals(arrayBag.getCurrentSize(), toArray.length);
        assertTrue(toArray[0].equals(1));
        assertTrue(toArray[1].equals(2));
        assertTrue(toArray[2].equals(3));
    }

    /**
     * A Union is defined as the joint items from both collections.
     * We have intArrayBag with items [3, 4]
     * We have intArrayBag2 with items [5,6]
     * The union of both bags (intArrayBag U intArrayBag2) -> [3, 4, 5, 6]
     */
    @Test
    void testUnion() {

        // Arrange
        ResizableArrayBag<Integer> intArrayBag = new ResizableArrayBag<>(2);
        intArrayBag.add(3);
        intArrayBag.add(4);
        ResizableArrayBag<Integer> intArrayBag2 = new ResizableArrayBag<>(2);
        intArrayBag2.add(5);
        intArrayBag2.add(6);

        // Act
        BagInterface<Integer> everything = intArrayBag.union(intArrayBag2);

        // Assert
        assertTrue(everything.contains(3));
        assertTrue(everything.contains(4));
        assertTrue(everything.contains(5));
        assertTrue(everything.contains(6));
    }

    /**
     * An Intersection is defined as the collection of items that occur in both collections
     * We have intArrayBag with items [3, 4]
     * We have intArrayBag2 with items [5, 3]
     * The Intersection of both Bags should be [3] since '3' occurs in both bags
     */
    @Test
    void testIntersection() {

        // Arrange
        ResizableArrayBag<Object> intArrayBag = new ResizableArrayBag<>(2);
        intArrayBag.add(3);
        intArrayBag.add(4);
        ResizableArrayBag<Object> intArrayBag2 = new ResizableArrayBag<>(2);
        intArrayBag2.add(5);
        intArrayBag2.add(3);

        // Act
        BagInterface<Object> intersection = intArrayBag.intersection(intArrayBag2);

        // Assert
        assertTrue(intersection.contains(3));
        assertFalse(intersection.contains(5));
        assertFalse(intersection.contains(4));
    }

    /**
     * A Difference is defined as the leftover items in a collection after removing the items that occur in the second collection.
     * We have intArrayBag with [4, 3, 5]
     * We have intArrayBag2 with [5, 3]
     * The leftover ([4, 3, 5] - [5, 3]) should be [4] since 3 and 5 occur in both collections.
     */
    @Test
    void testDifference() {

        // Arrange
        ResizableArrayBag<Integer> intArrayBag = new ResizableArrayBag<>(2);
        intArrayBag.add(4);
        intArrayBag.add(3);
        intArrayBag.add(5);
        ResizableArrayBag<Integer> intArrayBag2 = new ResizableArrayBag<>(2);
        intArrayBag2.add(5);
        intArrayBag2.add(3);

        // Act
        BagInterface<Integer> leftover = intArrayBag.difference(intArrayBag2);

        // Assert
        assertTrue(leftover.contains(4));
        assertFalse(leftover.contains(3));
        assertFalse(leftover.contains(5));
    }
}