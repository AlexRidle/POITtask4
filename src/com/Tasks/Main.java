package com.Tasks;

import java.util.Random;

public class Main {

    private static int maxRandomValue = 2147483647;
    private static int arraySize = 10000000;
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
        runSortAndGetStats(4096,arraySize,array);
        runSortAndGetStats(8192,arraySize,array);
        runSortAndGetStats(16384,arraySize,array);
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
        printStats(powOfTwo, elapsedTime, runtime);
    }

    private static void printStats(int powOfTwo, long elapsedTime, Runtime runtime) {
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long memory = totalMemory - freeMemory;
        System.out.println("Sorting by: " + powOfTwo + " bits.");
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds (" + elapsedTime / 1000 + " seconds).");
        System.out.println("Total memory: " + totalMemory + " bytes (" + bytesToMegabytes(totalMemory) + " MB).");
        System.out.println("Free memory: " + freeMemory + " bytes (" + bytesToMegabytes(freeMemory) + " MB).");
        System.out.println("Used memory is bytes: " + memory + " bytes (" + bytesToMegabytes(memory) + " MB).\n");
    }

    private static long bytesToMegabytes(long bytes) {
        //time and memory usage
        long MEGABYTE = 1024L * 1024L;
        return bytes / MEGABYTE;
    }
}