import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents a list of integers.
 *
 * @author Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Nov, 2023
 * @assignment PA6
 * @version 1.0
 */
public class ArrayIntList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] EMPTY_ELEMENTDATA = {};
    private static final int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient int[] elementData;
    private int size;

    public ArrayIntList(int capacity) {
        if (capacity > 0) {
            this.elementData = new int[capacity];
        } else if (capacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ capacity);
        }
        this.size = 0;
    }

    public ArrayIntList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        this.size = 0;
    }

    public void add(int value) {
        add(value, elementData, size);
    }
    /**
     * @param value the value to be added
     * @param elementData the array to be added
     * @param size the size of the array
     */
    private void add(int value, int[] elementData, int size) {
        if (size == elementData.length)
            elementData = grow();
        elementData[size] = value;
        this.size = size + 1;
    }

    private int[] grow() {
        return grow(size + 1);
    }
    /**
     * @param minCapacity the desired minimum capacity
     * @return the new capacity
     */
    private int[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity =  oldCapacity + 1;
//            elementData = Arrays.copyOf(elementData, newCapacity);
            int[] newElementData = new int[newCapacity];
            for(int i = 0; i < oldCapacity; i++){
                newElementData[i] = elementData[i];
            }
            return elementData = newElementData;
//            return elementData;
        } else {
            return elementData = new int[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    /**
     * @param index the index to be added
     * @param value the value to be added
     */
    public void add(int index, int value) {
        rangeCheckForAdd(index);
        final int s;
        int[] elementData;
        //Enlarging the array
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        //System.arraycopy(elementData, index, elementData, index + 1, s - index);
        for (int i = s; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        size = s + 1;
    }
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public int get(int index) {
        checkIndex(index, size-1);
        return elementData(index);
    }

    int elementData(int index) {
        return elementData[index];
    }

    public int indexOf(int value) {
        return indexOfRange(value, size);
    }
    /**
     * @param value the value to be searched
     * @param end the end of the array
     * @return the index of the value
     */
    int indexOfRange(int value, int end) {
        int[] es = elementData;
        for(int i = 0; i < end; i++){
            if (value == es[i]) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        final int[] es = elementData;
        fastRemove(es, index);
    }
    /**
     * @param es the array to be removed
     * @param i the index to be removed
     */
    private void fastRemove(int[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
//            System.arraycopy(es, i + 1, es, i, newSize - i);
            for(int j = i; j < newSize; j++){
                es[j] = es[j+1];
            }
        es[size = newSize] = 0;
    }

    public int size() {
        return size;
    }

    public String toString(){
        return Arrays.toString(Arrays.stream(elementData).limit(size).toArray());
    }

    public void clear() {
        final int[] es = elementData;
        for (int i = 0; i < size; i++)
            es[i] = 0;
        size = 0;
    }

    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            grow(capacity);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index, int max) {
        if (index < 0 || index > max) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size());
        }
    }

}
