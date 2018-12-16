package com.Tasks;

import java.util.ArrayList;
//import java.util.Arrays;

public class Sort {

    private int powOfTwo;
    private int binaryShift;
    private int sortCounter;
    private int[] array;
    private ArrayList<ArrayList<Integer>> tempArray;

    public void start(int powOfTwo, int arraySize, int[] array){
        setupSettings(powOfTwo, arraySize);
        initArrays(array);

        int counter = getCount();
        for (int i = 0; i < counter; i++) {
            sortArray();
//            System.out.println("Iteration: " + i + " Array: " + Arrays.toString(this.array));
        }
    }

    private void setupSettings(int powOfTwo, int arraySize){
        this.powOfTwo = powOfTwo;
        array = new int[arraySize];
        tempArray = new ArrayList<>();
        binaryShift = getBinaryShift();
        sortCounter = 0;
    }

    private void initArrays(int[] array) {
        System.arraycopy(array, 0, this.array, 0, array.length);
//        System.out.println("Array: " + Arrays.toString(array));

        for (int i = 0; i < powOfTwo; i++) {
            tempArray.add(new ArrayList<>());
        }
    }

    private int getBinaryShift() {
        String binValue = Integer.toBinaryString(powOfTwo - 1);
        return binValue.length();
    }

    private int getCount() {
        String binValue = Integer.toBinaryString(getMaxOfArray(array));
        return binValue.length() % binaryShift != 0 ?
                binValue.length() / binaryShift + 1:
                binValue.length() / binaryShift;
    }

    private int getMaxOfArray(int[] array) {
        int value = array[0];
        for (int num : array) {
            if (num > value) {
                value = num;
            }
        }
        return value;
    }

    private void sortArray() {
        //add current num from array into temp array by last bit's
        for (int num : array) {
            tempArray.get((num >> sortCounter) & powOfTwo - 1).add(num);
        }

        //add value by value in main array
        int arrayPos = 0;
        for (ArrayList<Integer> arrayList : tempArray) {
            if (!arrayList.isEmpty()) {
                for (int value : arrayList) {
                    array[arrayPos] = value;
                    arrayPos++;
                }
                arrayList.clear();
            }
        }

        sortCounter += binaryShift;
    }
}
