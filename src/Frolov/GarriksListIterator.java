package Frolov;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GarriksListIterator implements ListIterator {

    private final GarriksArrayList arr;
    private final int startElemIndex;
    private int currElemIndex;

    public GarriksListIterator(GarriksArrayList arr, int i) {
        this.arr = arr;
        this.startElemIndex = i;
        this.currElemIndex = i;
    }

    public GarriksListIterator(GarriksArrayList arr) {
        this.arr = arr;
        this.startElemIndex = 0;
        this.currElemIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return (currElemIndex + 1 <= arr.size());
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Garriks list iterator can't see more elements :)");
        }
        return arr.get(++currElemIndex);
    }

    @Override
    public boolean hasPrevious() {
        return (currElemIndex - 1 >= startElemIndex);
    }

    @Override
    public Object previous() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException("Garriks list iterator can't see more elements :)");
        }
        return arr.get(--currElemIndex);
    }

    @Override
    public int nextIndex() {
        return this.hasNext() ? currElemIndex + 1 : -1;
    }

    @Override
    public int previousIndex() {
        return this.hasPrevious() ? currElemIndex - 1 : -1;
    }

    @Override
    public void remove() {
        arr.remove(currElemIndex);
    }

    @Override
    public void set(Object o) {
        arr.set(currElemIndex, o);
    }

    @Override
    public void add(Object o) {
        arr.add(currElemIndex + 1, o);
    }
}
