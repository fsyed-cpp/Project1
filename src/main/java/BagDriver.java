
public class BagDriver {

    /**
     * This class is responsible for providing the demo code for some bags.
     * We will showcase bags that perform the following:
     * union, intersection, and difference methods
     * @param args
     */
    public static void main(String[] args) {

        // Create 2 Bags that hold type Integer
        BagInterface<Integer> intArrayBag = new ResizableArrayBag<>(3);
        intArrayBag.add(1);
        intArrayBag.add(2);
        intArrayBag.add(3);
        BagInterface<Integer> intArrayBag2 = new ResizableArrayBag<>(4);
        intArrayBag2.add(2);
        intArrayBag2.add(3);
        intArrayBag2.add(5);
        intArrayBag2.add(6);

        // Display Union, Intersection, and Difference
        BagInterface<Integer> union = intArrayBag.union(intArrayBag2);
        BagInterface<Integer> difference = intArrayBag.difference(intArrayBag2);
        BagInterface<Integer> intersection = intArrayBag.intersection(intArrayBag2);

        System.out.println("Union of Integer Bag:");
        printBagDetails(union);

        System.out.println("Difference of Integer Bag:");
        printBagDetails(difference);

        System.out.println("Intersection of Integer Bag:");
        printBagDetails(intersection);

        // Error Handling -> Catch a null bag
        try {
            intArrayBag.union(null);
        } catch (NullPointerException exception) {
            System.out.println("We caught an exception attempting to union our array bag with a null bag " + exception);
        }

        // Same bags but using LinkedBag
        BagInterface<Integer> intLinkedBag = new LinkedBag<>(null);
        intLinkedBag.add(1);
        intLinkedBag.add(2);
        intLinkedBag.add(3);
        BagInterface<Integer> intLinkedBag2 = new LinkedBag<>(null);
        intLinkedBag2.add(2);
        intLinkedBag2.add(3);
        intLinkedBag2.add(5);
        intLinkedBag2.add(6);

        // Display Union, Intersection, and Difference
        BagInterface<Integer> union2 = intLinkedBag.union(intLinkedBag2);
        BagInterface<Integer> difference2 = intLinkedBag.difference(intLinkedBag2);
        BagInterface<Integer> intersection2 = intLinkedBag.intersection(intLinkedBag2);

        System.out.println("Union of Linked Bag:");
        printBagDetails(union2);

        System.out.println("Difference of Linked Bag:");
        printBagDetails(difference2);

        System.out.println("Intersection of Linked Bag:");
        printBagDetails(intersection2);
    }

    private static void printBagDetails(BagInterface bag) {
        Object[] bagArray = bag.toArray();
        int length = bag.getCurrentSize();
        for (int i = 0; i < length; i++) {
            System.out.print(bagArray[i] + " ");
        }
        System.out.println();
    }
}
