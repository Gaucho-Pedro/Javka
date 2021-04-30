package com.company;

import java.util.Arrays;

/**
 * Сортированный статический массив (по возрастанию).
 *
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            super.sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        array[index] = value;
        if (!isAscSorted()) {
            super.sort();
        }
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        if (!isAscSorted()) {
            super.sort();
        }
        return -1;
    }

    @Override
    public void sort() { }

    @Override
    public void sort(ArraySort sort) { }

    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слиянеие двух сортированных массивов
        int[] result = new int[array.length + other.array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(other.array, 0, result, array.length, other.array.length);
        return new SortedArray(result);
    }

    public SortedArray mergeAll(SortedArray... others) {
        // TODO: произвести слиянеие N + 1 сортированных массивов
        SortedArray temp = others[0];
        for (int i = 1; i < others.length; i++) {
            temp = temp.merge(others[i]);
        }
        return temp;
    }
}
