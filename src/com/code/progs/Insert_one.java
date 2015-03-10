package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/insertionsort1
 */
public class Insert_one {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));

        String input = in.readLine().trim();
        int s = Integer.parseInt(input);
        int arr[] = new int[s];
        input = in.readLine().trim();
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < s; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int v = arr[s - 1];
        int key,j;
        for(int i=1;i<s;i++){
            key=arr[i];
            j=i-1;
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j];
                j--;
                show(arr);
            }
            arr[j+1]=key;
        }
        show(arr);
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
