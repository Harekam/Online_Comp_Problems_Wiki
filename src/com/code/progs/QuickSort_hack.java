package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by hsingh79 on 3/10/2015.
 */
public class QuickSort_hack {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));

        String input = in.readLine().trim();
        int n = Integer.parseInt(input);
        int arr[] = new int[n];
        int[] lessp = new int[n];
        int[] morep = new int[n];
        input = in.readLine().trim();
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sort(arr);

        /*int p = arr[0];
        int l = 0, m = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < p)
                lessp[l++] = arr[i];
            else
                morep[m++] = arr[i];
        }
        int j = 0, x = 0, y = 0;

        while (x < l && j < n) {
            arr[j++] = lessp[x++];
        }
        arr[j++] = p;

        while (y < m && j < n)
            arr[j++] = morep[y++];*/


    }

    public static void show(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void sort(int[] arr) {
        //shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);

        sort(arr, j + 1, hi);

    }

    private static int partition(int arr[], int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++i] < arr[lo])
                if (i == hi) break;
            while (arr[lo] < arr[--j])
                if (j == lo) break;
            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, lo, j);

        return j;
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shuffle(int arr[]) {
        int n = arr.length;
        Random randomGenerator = new Random();
        for (int i = 0; i < n; i++) {
            int r = randomGenerator.nextInt(i + 1);
            exchange(arr, i, r);
        }
    }

}
