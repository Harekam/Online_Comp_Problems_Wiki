package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountingSort {
	private int arr[], orig[];
	private String sarr[];
	private static int index;

	public CountingSort(int n) {
		index = 0;
		arr = new int[100];
		orig = new int[n];
		sarr = new String[n];
		for (int i = 0; i < 100; i++)
			arr[i] = 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();

		int n = Integer.parseInt(input);
		int len = n;
		CountingSort cs = new CountingSort(n);
		while (n-- > 0) {
			input = in.readLine().trim();
			StringTokenizer st = new StringTokenizer(input);
			int val = Integer.parseInt(st.nextToken());
			String strVal = st.nextToken();
			cs.count(val);
			cs.addToOrignal(val, strVal);
		}

		String srr[] = cs.build(len);

		for (int i = 0; i < len; i++) {
			out.write(srr[i] + " ");
		}
		out.flush();
	}

	private void addToOrignal(int val, String strVal) {
		orig[index] = val;
		sarr[index] = strVal;
		index++;
	}

	private void count(int val) {
		arr[val]++;
	}

	private static int startingPoint = 0;

	private String[] build(int len) {
		String[] resultantStrArray = new String[len];
		int x = 0;
		for (int i = 0; i < 100; i++) {
			int k = arr[i];
			while (k-- > 0) {
				resultantStrArray[x++] = associatedStr(i);
			}
			startingPoint = 0;

		}
		return resultantStrArray;
	}

	private String associatedStr(int i) {

		int len = orig.length;

		String res = null;

		for (int j = startingPoint; j < len; j++) {
			if (orig[j] == i) {
				if (j <= (len / 2) - 1)
					res = "-";
				else
					res = sarr[j];
				startingPoint = j + 1;
				break;
			}
		}

		return res;
	}

}
