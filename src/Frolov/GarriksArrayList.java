package Frolov;

import java.util.*;

public class GarriksArrayList implements List {
    private Object[] realArr;
    private int elemsCount;

    public GarriksArrayList() {
        this.elemsCount = 0;
        this.realArr = new Object[10];
    }

    public GarriksArrayList(int elemsCount, Object[] realArr) {
        this.elemsCount = elemsCount;
        this.realArr = realArr;
    }

    @Override
    public int size() {
        return elemsCount;
    }

    @Override
    public boolean isEmpty() {
        return elemsCount <= 0;
    }

    // тут лучше использовать == или equals? Я понимаю, что equals вернет true в отличии от ==, если экзмепляры разные, но все поля одинаковые.
    @Override
    public boolean contains(Object o) {
        int i = 0;
        while (i < elemsCount) {
            if (o.equals(realArr[i++])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new GarriksIterator(this);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = get(i);
        }
        return arr.clone();
    }

    @Override
    public boolean add(Object o) {
        guaranteedLength(realArr.length + 1);
        realArr[elemsCount++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elemsCount; i++) {
            if (realArr[i] == o) {
                Object[] tempArr = new Object[realArr.length];
                System.arraycopy(realArr, 0, tempArr, 0, i);
                System.arraycopy(realArr, i + 1, tempArr, i, elemsCount - i - 1);
                realArr = tempArr;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        //сложна, как можно объеденить две коллекции в одну и потом привести к array
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        //сложна, как можно объеденить две коллекции в одну и потом привести к array
        return false;
    }

    @Override
    public void clear() {
        // допускается ли так писать?
        realArr = new Object[]{null, null, null, null, null, null, null, null, null, null};
        elemsCount = 0;
    }

    @Override
    public Object get(int i) {
        return realArr[i];
    }

    @Override
    public Object set(int i, Object o) {
        realArr[i] = o;
        return o;
    }

    @Override
    public void add(int i, Object o) {
        guaranteedLength(realArr.length + 1);
        Object[] tempArr = new Object[realArr.length];
        System.arraycopy(realArr, 0, tempArr, 0, i);
        tempArr[i] = o;
        System.arraycopy(realArr, i, tempArr, i + 1, elemsCount - i);
        realArr = tempArr;
    }

    @Override
    public Object remove(int i) {
        Object result = realArr[i];
        Object[] tempArr = new Object[realArr.length];
        System.arraycopy(realArr, 0, tempArr, 0, i);
        System.arraycopy(realArr, i + 1, tempArr, i, --elemsCount - i);
        realArr = tempArr;
        guaranteedLength(realArr.length);
        return result;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elemsCount; i++) {
            if (realArr[i] == o) {
                return i;
            }
        }
        // в питоновском аналогичном методе, если объект не найден, то возвращается -1, как принято в java?
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = elemsCount - 1; i >= 0; i--) {
            if (realArr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return new GarriksListIterator(this);
    }

    // я же правильно понял, что этот метод возвращает итератор, начиная от указанного индекса i?
    @Override
    public ListIterator listIterator(int i) {
        return new GarriksListIterator(this, i);
    }

    @Override
    public List subList(int i, int i1) {
        List resultList = new GarriksArrayList();
        for (int j = i; j < i1; j++) {
            resultList.add(realArr[j]);
        }
        return resultList;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean result = false;
        for (Object elem : collection) {
            if (!this.contains(elem)) {
                this.remove(elem);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean result = false;
        for (Object elem : collection) {
            if (this.contains(elem)) {
                this.remove(elem);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object elem : collection) {
            if (!this.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    //
    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(realArr);
    }

    private void guaranteedLength(int newLength) {
        if (elemsCount + 1 >= newLength) {
            Object[] tempArr = new Object[(realArr.length * 3 / 2) + 1];
            System.arraycopy(realArr, 0, tempArr, 0, realArr.length);
            realArr = tempArr;
            return;
        }
        if (realArr.length > 10 && newLength > elemsCount * 3 / 2 + 1) {
            Object[] tempArr = new Object[Math.max(elemsCount, 10)];
            System.arraycopy(realArr, 0, tempArr, 0, Math.max(elemsCount, 10));
            realArr = tempArr;
        }
    }
}
