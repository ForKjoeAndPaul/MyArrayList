
public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    public Object[] elementData;

    private int size;

    public MyArrayList() {
       this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0){
            this.elementData = new Object[initialCapacity];
        }
        else throw new IllegalStateException("Размер списка не может меньше 0");
    }

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    private Object[] increaseCapacity(){
        Object[] elementData = new Object[this.elementData.length * 2];
        System.arraycopy(this.elementData, 0, elementData, 0, this.elementData.length);
        return elementData;
    }

    public boolean add(E element){
        increaseCapacityForAdd();
        elementData[size] = element;
        size++;
        return true;
    }

    public void addByIndex(int index, E element){
        rangeCheck(index);
        increaseCapacityForAdd();
        System.arraycopy(elementData, index , elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    private void increaseCapacityForAdd(){
        if (elementData.length == size){
            elementData = increaseCapacity();
        }
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }


    public Object remove(int index){
        rangeCheck(index);
        Object[] elementData = this.elementData;
        this.elementData = new Object[elementData.length - 1];
        Object element = elementData[index];
        System.arraycopy(elementData, 0, this.elementData, 0, index); //копируем левую часть массива до указанного индекса
        System.arraycopy(elementData, index + 1, this.elementData, index, elementData.length - index - 1); //копируем правую часть массива после указанного индекса
        size--;
        return element;
    }
}
