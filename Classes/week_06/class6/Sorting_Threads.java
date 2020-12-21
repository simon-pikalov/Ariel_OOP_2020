//package class5;
/**
 * This demo class presents a multi-threaded sorting algorithm - 
 * which is 20-40% faster than a single threaded sorting -
 * with the same code (using run(), and not start()) 
 * Source: https://stackoverflow.com/questions/3466242/multithreaded-merge-sort
 */

import java.util.Random;
public class Sorting_Threads {
    public static void finalMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i=0;
        int j=0;
        int r=0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r]=a[i];
                i++;
                r++;
            } else {
                result[r]=b[j];
                j++;
                r++;
            }
            if (i==a.length) {
                while (j<b.length) {
                    result[r]=b[j];
                    r++;
                    j++;
                }
            }
            if (j==b.length) {
                while (i<a.length) {
                    result[r]=a[i];
                    r++;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        double t1 = paralell_sort();
        double t2 = serial_sort();
        double pr = 100*t1/t2;
        System.out.println("The parallel version took "+pr+"% of the serial one!");
    }

    public static long paralell_sort() {
        int[][] arr = init();
        long startTime = System.currentTimeMillis();
        Worker runner1 = new Worker(arr[0]);
        Worker runner2 = new Worker(arr[1]);
        runner1.start();  // runner1.run();
        runner2.start();  // runner2.run();
        try{
            runner1.join();
            runner2.join();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finalMerge (runner1.getInternal(), runner2.getInternal());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("2-thread MergeSort takes: " + (float)elapsedTime/1000 + " seconds");
        return elapsedTime;
    }

    public static long serial_sort() {
        int[][] arr = init();
        long startTime = System.currentTimeMillis();
        Worker runner1 = new Worker(arr[0]);
        Worker runner2 = new Worker(arr[1]);
        runner1.run();
        runner2.run();
        //runner1.join();
        //runner2.join();
        finalMerge (runner1.getInternal(), runner2.getInternal());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Single-thread MergeSort takes: " + (float)elapsedTime/1000 + " seconds");
        return elapsedTime;
    }

    public  static int[][] init() {
        Random rand = new Random();
        int[] original = new int[10000000];
        for (int i=0; i<original.length; i++) {
            original[i] = rand.nextInt(1000);
        }
        long startTime = System.currentTimeMillis();
        int[] subArr1 = new int[original.length/2];
        int[] subArr2 = new int[original.length - original.length/2];
        System.arraycopy(original, 0, subArr1, 0, original.length/2);
        System.arraycopy(original, original.length/2, subArr2, 0, original.length - original.length/2);
        int[][] ans = new int[2][0];
        ans[0] = subArr1;
        ans[1] = subArr2;
        return ans;
    }
}

class Worker extends Thread {
    private int[] internal;
    public int[] getInternal() {
        return internal;
    }

    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }
    Worker(int[] arr) {
        internal = arr;
    }

    public void run() {
        mergeSort(internal);
    }
}