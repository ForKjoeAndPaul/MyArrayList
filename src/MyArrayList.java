import java.util.Arrays;

/**
 * Resizable list based on array.
 * <p>
 * The array is used to place elements in the list.
 * <p>
 *
 * @param <E> the Type of elements in this list
 * @author Derevenskikh Roman
 */

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;

    private int size;

    /**
     * Constructs an empty list with an initial capacity of DEFAULT_CAPACITY.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with an initial capacity
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException - if the specified initial capacity is wrong
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = new Object[initialCapacity];
        } else throw new IllegalStateException("Размер списка не может быть меньше 0");
    }

    /**
     * Getter of elementData for Quicksort method "quicksort"
     */
    public Object[] getElementData() {
        return elementData;
    }

    /**
     * Get size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the element at the position in this list.
     *
     * @param index
     * @return - the element at the position in this list
     * @throws IndexOutOfBoundsException - if index is wrong
     */
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * Resize base array.
     * Create the new array with new capacity * 2. Copy all elements to the new array.
     */
    private Object[] increaseCapacity() {
        Object[] elementData = new Object[this.elementData.length * 2];
        System.arraycopy(this.elementData, 0, elementData, 0, this.elementData.length);
        return elementData;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element - to be appended to list.
     */
    public void add(E element) {
        increaseCapacityForAdd();
        elementData[size] = element;
        size++;
    }

    /**
     * Inserts the element at the specified position in list.
     * Shifts the element currently at that position to the right.
     * If insert in last position of the list. Adding new element to end of list.
     *
     * @param index   - position to insertion
     * @param element - to be inserted
     * @throws IndexOutOfBoundsException - if index is wrong
     */
    public void insert(int index, E element) {
        rangeCheck(index);
        increaseCapacityForAdd();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * Checks size of elementData and add new element
     */
    private void increaseCapacityForAdd() {
        if (elementData.length == size) {
            elementData = increaseCapacity();
        }
    }

    /**
     * Checks bounds of elementData by index
     */
    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left.
     *
     * @param index - of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException - if index is wrong
     */
    public Object remove(int index) {
        rangeCheck(index);
        Object[] elementData = this.elementData;
        this.elementData = new Object[elementData.length - 1];
        Object element = elementData[index];
        System.arraycopy(elementData, 0, this.elementData, 0, index); //копируем левую часть массива до указанного индекса
        System.arraycopy(elementData, index + 1, this.elementData, index, elementData.length - index - 1); //копируем правую часть массива после указанного индекса
        size--;
        return element;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }
}
