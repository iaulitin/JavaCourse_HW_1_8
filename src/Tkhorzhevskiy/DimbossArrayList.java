package Tkhorzhevskiy;

import java.util.*;


public class DimbossArrayList<E> implements List<E> {
    public static  void main(String [] args){
        DimbossArrayList<Integer> testList=new DimbossArrayList<>();
        testList.add(2);
        testList.add(2);
        testList.add(8);
        System.out.println(testList.get(0));
        System.out.println(testList.size());
        System.out.println(testList.isEmpty());
        System.out.println(testList.contains(7));
        System.out.println(testList.remove(2));
        System.out.println(testList.contains(1));
        testList.set(1,6);
        System.out.println(testList.indexOf(6));
        Object[] arr=testList.toArray();
        System.out.println(Arrays.toString(arr));
    }


    private E[] listArr;
    private int size;
    private static final int DEFAULT_SIZE=10;

    public DimbossArrayList() {
        listArr = (E[]) new Object[10];
        size = 0;
    }


    public void ensureCapacity(int minCapcity) {
        int currentCapacity = listArr.length;
        if (minCapcity > currentCapacity) {
            E[] oldListArr = listArr;
            listArr = (E[]) new Object[minCapcity];
            for (int i = 0; i < size; i++)
                listArr[i] = oldListArr[i];
            oldListArr = null;
        }
    }


    public void rangeCheck(int index, String msg, int upperBound) {
        if (index < 0 || index >= upperBound + 1)
            throw new IndexOutOfBoundsException(msg + " индекс" + index + " находится за границей массива");
    }


    public void add(int index, E element) {
        rangeCheck(index, "Arraylist add()", size);
        if (listArr.length == size)
            ensureCapacity(2 * listArr.length);
        for (int j = size - 1; j >= index; j--) {
            listArr[j + 1] = listArr[j];
        }
        listArr[index] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++)
            if (listArr[i] == o)
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
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
    public <E1> E1[] toArray(E1[] a) {
        Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = get(i);
        }
        return (E1[]) arr.clone();
    }

    @Override
    public boolean add(E t) {
        add(size, t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i;
        for (i = 0; i < size; i++)
            if (listArr[i] == o)
                break;
        if (i == size)
            return false;
        for (int j = i - 1; j < size; j++)
            listArr[j] = listArr[j + 1];
        size--;
        return true;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        listArr = (E[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public E get(int index) {
        return listArr[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index, " установить индекс ", size - 1);
        listArr[index] = element;
        return element;
    }

    @Override
    public E remove(int index) {

        rangeCheck(index, " удалить индекс ", size - 1);
        E r = listArr[index];
        for (int i = index; i < size; i++)
            listArr[i] = listArr[i + 1];
        size--;
        return r;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (listArr[i] == o)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
