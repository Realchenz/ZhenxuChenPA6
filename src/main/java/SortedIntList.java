import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * This class represents a list of sorted integers.
 * @author Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Nov, 2023
 * @assignment PA6
 * @version 1.0
 */
public class SortedIntList extends ArrayIntList {
    boolean unique = false;
    public SortedIntList(int Capacity) {
        super(Capacity);
    }
    public SortedIntList() {
        super();
    }
    public SortedIntList(boolean unique) {
        super();
        this.unique = unique;
    }
    public SortedIntList(boolean unique, int capacity){
        super(capacity);
        this.unique = unique;
    }
    /**
     * @param value the value to be added
     */
    @Override
    public void add(int value) {
        if (unique && contains(value)) {
            return;
        }
        int index = 0;
        // find the index to insert
        while (index < size() && get(index) < value) {
            index++;
        }
        super.add(index, value);
    }
    @Override
    public void add(int index, int value){
        throw new UnsupportedOperationException();
    }
    public boolean getUnique() {
        return unique;
    }
    @Override
    public int indexOf(int value) {
        return Arrays.binarySearch(elementData, 0, size(), value); // O(log n)
    }
    public int max() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size() - 1);
    }
    public int min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }
    public void setUnique(boolean unique) {
        this.unique = unique;
        // remove duplicates
        if(unique){
            for(int i = 0; i < size(); i++){
                if(indexOf(get(i)) != i){
                    remove(i);
                    i--;
                }
            }
        }
    }
    @Override
    public String toString() {
        return "S:" + super.toString() + "U";
    }
}
