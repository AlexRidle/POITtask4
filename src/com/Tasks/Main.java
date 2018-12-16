package com.Tasks;

import java.util.Random;

public class Main {

    private static int maxRandomValue = 100000000;
    private static int arraySize = 20000000;
    private static int[] array = new int[arraySize];

    public static void main(String[] args) {
        initArray();
        runSortAndGetStats(2,arraySize,array);
        runSortAndGetStats(4,arraySize,array);
        runSortAndGetStats(8,arraySize,array);
        runSortAndGetStats(16,arraySize,array);
        runSortAndGetStats(32,arraySize,array);
        runSortAndGetStats(64,arraySize,array);
        runSortAndGetStats(128,arraySize,array);
        runSortAndGetStats(256,arraySize,array);
        runSortAndGetStats(512,arraySize,array);
        runSortAndGetStats(1024,arraySize,array);
        runSortAndGetStats(2048,arraySize,array);
    }

    private static void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxRandomValue);
        }
    }

    private static void runSortAndGetStats(int powOfTwo, int arraySize, int[] array){
        long startTime = System.currentTimeMillis();

        new Sort().start(powOfTwo,arraySize,array);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        printStats(powOfTwo, elapsedTime, memory);
    }

    private static void printStats(int powOfTwo, long elapsedTime, long memory) {
        System.out.println("Pow of two: " + powOfTwo);
        System.out.println("Elapsed time: " + elapsedTime);
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory) + "\n");
    }

    private static long bytesToMegabytes(long bytes) {
        //time and memory usage
        long MEGABYTE = 1024L * 1024L;
        return bytes / MEGABYTE;
    }
}