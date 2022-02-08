import java.util.ArrayList;

public class ResizableArrayBag<T> implements BagInterface<T> {

    // MARK: - Properties

    ArrayList<T> objects;

    // MARK: Constructor

    public ResizableArrayBag(ArrayList<T> objects) {
        this.objects = objects;
    }

    // MARK: - Bag Interface Methods

    @Override
    public int getCurrentSize() {
        return this.objects.size();
    }

    @Override
    public boolean isEmpty() {
        return this.objects.size() == 0;
    }

    @Override
    public boolean add(T newEntry)
    {
        this.objects.add(newEntry);
      return true;
    }

    /**
     * TODO -> Implement the logic for the following Resizable Array Bag methods
     */

    @Override
    public T remove()
    {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> bag)
    {

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

    // TODO...
    // CODE FOR THROW EXCEPTIONS IN DIFFERENT CASES:

    private void checkIfInitialized()
    {

    }




}
