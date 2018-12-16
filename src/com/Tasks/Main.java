package com.Tasks;

import java.util.Random;

public class Main {

    private static int maxRandomValue = 8000; //2147483647 for 4th task
    private static int arraySize = 50; // 10000000 for 4th task
    private static int[] array = new int[arraySize];
    private static boolean arrayOutput = true;

    public static void main(String[] args) {
        initArray();
        if (arraySize > 100) arrayOutput = false;
        runSortAndGetStats(2, arraySize, array, arrayOutput);
        runSortAndGetStats(4, arraySize, array, arrayOutput);
        runSortAndGetStats(8, arraySize, array, arrayOutput);
        runSortAndGetStats(16, arraySize, array, arrayOutput);
        runSortAndGetStats(32, arraySize, array, arrayOutput);
        runSortAndGetStats(64, arraySize, array, arrayOutput);
        runSortAndGetStats(128, arraySize, array, arrayOutput);
        runSortAndGetStats(256, arraySize, array, arrayOutput);
        runSortAndGetStats(512, arraySize, array, arrayOutput);
        runSortAndGetStats(1024, arraySize, array, arrayOutput);
        runSortAndGetStats(2048, arraySize, array, arrayOutput);
        runSortAndGetStats(4096, arraySize, array, arrayOutput);
        runSortAndGetStats(8192, arraySize, array, arrayOutput);
        runSortAndGetStats(16384, arraySize, array, arrayOutput);
    }

    private static void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxRandomValue);
        }
    }

    private static void runSortAndGetStats(int powOfTwo, int arraySize, int[] array, boolean arrayOutput) {
        long startTime = System.currentTimeMillis();
        System.out.println("Sorting by: " + powOfTwo + " bits...");

        new Sort().start(powOfTwo, arraySize, array, arrayOutput);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        printStats(elapsedTime, runtime);
    }

    private static void printStats(long elapsedTime, Runtime runtime) {
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long memory = totalMemory - freeMemory;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds (" + elapsedTime / 1000 + " seconds).");
        System.out.println("Total memory: " + totalMemory + " bytes (" + bytesToMegabytes(totalMemory) + " MB).");
        System.out.println("Free memory: " + freeMemory + " bytes (" + bytesToMegabytes(freeMemory) + " MB).");
        System.out.println("Used memory: " + memory + " bytes (" + bytesToMegabytes(memory) + " MB).\n");
    }

    private static long bytesToMegabytes(long bytes) {
        long MEGABYTE = 1024L * 1024L;
        return bytes / MEGABYTE;
    }
}