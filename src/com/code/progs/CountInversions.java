package com.code.progs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountInversions {
    public static final int SIZE = 100000;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\IntegerArray.txt"))) {

            String sCurrentLine;
            long arr[] = new long[SIZE];
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                // System.out.println(sCurrentLine.trim());
                sCurrentLine = sCurrentLine.trim();
                long temp = Long.parseLong(sCurrentLine);

                arr[i] = temp;
                i++;
            }
            long result = mergeSort(arr, SIZE);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static long mergeSort(long arr[], int len) {
        int mid, i, j;
        long invCount = 0;
        long[] L, R;
        if (len < 2)
            return 0;// do nothing
        mid = len / 2;
        L = new long[mid];
        R = new long[len - mid];
        for (i = 0; i < mid; i++)
            L[i] = arr[i];
        for (j = mid; j < len; j++)
            R[j - mid] = arr[j];
        invCount = mergeSort(L, mid); // sorting the left subarray
        invCount += mergeSort(R, len - mid); // sorting the right subarray
        invCount += merge(arr, L, mid, R, len - mid);
        return invCount;
    }

    public static long merge(long[] arr, long[] L, int leftSize, long[] R,
                             int rightSize) {
        long invCount = 0;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (L[i] < R[j])
                arr[k++] = L[i++];
            else {
                invCount += leftSize - i;
                arr[k++] = R[j++];

            }

        }
        while (i < leftSize)
            arr[k++] = L[i++];
        while (j < rightSize)
            arr[k++] = R[j++];
        return invCount;
    }
}
