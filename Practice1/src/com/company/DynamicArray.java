package com.company;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        // TODO: добавить элемент в конец массива
        int[] tempArray = new int[size + 1];
        if (size + 1 > array.length) {
            tempArray = new int[(int) (array.length * GROW_FACTOR)];
        }
        System.arraycopy(array, 0, tempArray, 0, size);
        tempArray[size] = value;
        size++;
        array = tempArray;
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        int[] tempArray = new int[size + 1];
        if (size + 1 > array.length) {
            tempArray = new int[(int) (array.length * GROW_FACTOR)];
        }
        System.arraycopy(array, 0, tempArray, 0, index);
        tempArray[index] = value;
        System.arraycopy(array, index + 1, tempArray, index + 1, size - index - 1);
        size++;
        array = tempArray;
    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
        int[] tempArray = new int[size + array.size()];
        System.arraycopy(this.array, 0, tempArray, 0, size);
        for (int i = size, j = 0; i < tempArray.length; i++) {
            tempArray[i] = array.get(j);
            j++;
        }
        size += array.size();
        this.array = tempArray;
    }

    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива
        // Удаляет все value найденные
        if (!this.contains(value)) {
            return false;
        }
        int[] tempArray = new int[array.length];
        int i = 0;
        for (int current : array) {
            if (current != value) {
                tempArray[i] = current;
                i++;
            } else {
                size--;
            }
        }
        array = tempArray;
        return true;
    }

    @Override
    public boolean removeAll(int[] values) {
        // TODO: удалить все указанные элементы из массива
        for (int current : values) {
            if (!this.contains(current)) {
                return false;
            }
        }
        for (int current : values) {
            if (this.remove(current)) {
                this.remove(current);
            }
        }
        return true;
    }

    @Override
    public int removeOf(int index) {
        // TODO: удалить элемент по индексу
        // Функция возвращает 0 если удалось удалить, -1 если какая-то ошибка
        // Ну или нужен Exeption если index=-1 или > size
        if (index == -1 || index > size) {
            return -1;
        }
        int[] tempArray = new int[array.length];
        if (index == 0) {
            System.arraycopy(array, 1, tempArray, 0, size - 1);
            size--;
        } else if (index == (size - 1)) {
            System.arraycopy(array, 0, tempArray, 0, size - 1);
            size--;
        } else {
            System.arraycopy(array, 0, tempArray, 0, index);
            System.arraycopy(array, index + 1, tempArray, index, size - index - 1);
            size--;
        }
        array = tempArray;
        return 0;
    }
}

