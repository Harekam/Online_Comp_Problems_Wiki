package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Kadane {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			int n = Integer.parseInt(input);
			input = in.readLine().trim();
			StringTokenizer st = new StringTokenizer(input);
			int arr[] = new int[n];
			for (int i = 1; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int max_so_far = arr[0], i;
			int curr_max = arr[0];
			int maxSum=Integer.MIN_VALUE;
			for (i = 1; i < n; i++) {
				
				curr_max = max(arr[i], curr_max + arr[i]);
				max_so_far = max(max_so_far, curr_max);
			}
			out.write(max_so_far+" "+maxSum);
			out.write("\n");
		}
		out.flush();
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return (i > j ? i : j);
	}

}
