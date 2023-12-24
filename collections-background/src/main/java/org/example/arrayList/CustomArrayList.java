package org.example.arrayList;


// Arraylist add uchun avantajlidir.
public class CustomArrayList <T> {

    private int size;
    private int capacitance;

    private Object[] array;

    public CustomArrayList() {
        this.capacitance = 10;
        this.array = new Object[capacitance];
    }

    // 0(1)
    public T get(int index) {
        return (T) this.array[index];
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacitance() {
        return this.capacitance;
    }

    public void add(T value) {
        if(size == capacitance) {
            reSizeArray();
        }

        array[size] = value;
        size++;
    }

    public void reSizeArray() {
        increase();
        Object[] newArray = new Object[capacitance];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public void increase() {
        capacitance = (capacitance * 3) / 2 + 1;
    }
}
