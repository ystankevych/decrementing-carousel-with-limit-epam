package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private int[] array;
    private int index;
    private boolean isRun;

    public DecrementingCarousel(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity is negative");
        }
        array = new int[capacity];
        index = -1;
    }

    public boolean addElement(int element) {
        if (element > 0 && !isRun && !isFull()) {
            array[++index] = element;
            return true;
        }
        return false;
    }

    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new CarouselRun(this);
        }
        return null;
    }

    private boolean isFull() {
        return index >= array.length - 1;
    }

    public int[] getArray() {
        return array;
    }

    public int getIndex() {
        return index;
    }
}
