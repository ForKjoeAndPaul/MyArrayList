public class QuickSort {

    /**
     * Статический метод сортировки, принимает на вход обхект класса MyArrayList, элементы которого имплементируют класс Comparable.
     */

    public static void sort(MyArrayList<? extends Comparable> list) {
        quickSort(0, list.getSize() - 1, list);
    }

    /**
     * Реализация QuickSort
     * @param low        - нижняя граница массива
     * @param high       - верхняя граница массива
     */
    private static void quickSort(int low, int high, MyArrayList<? extends Comparable> list) {
        Object[] elementData = list.getElementData();

        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        Object opor = elementData[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while ((((Comparable)elementData[leftBound]).compareTo(opor)) < 0) {
                leftBound++;
            }
            while ((((Comparable)elementData[rightBound]).compareTo(opor)) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                Object temp = elementData[leftBound];
                elementData[leftBound] = elementData[rightBound];
                elementData[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, list);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, list);
        }
    }
}
