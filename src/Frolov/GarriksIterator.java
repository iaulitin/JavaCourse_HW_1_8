package Frolov;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GarriksIterator implements Iterator {

    private final GarriksArrayList arr;
    private int currElemIndex;

    public GarriksIterator(GarriksArrayList arr) {
        this.arr = arr;
        this.currElemIndex = -1;
    }

    @Override
    public boolean hasNext() {
        return (currElemIndex + 1 <= arr.size());
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("Garriks iterator can't see more elements :)");
        }
        return arr.get(++currElemIndex);
    }
}
