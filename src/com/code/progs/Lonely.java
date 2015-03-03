package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lonely {
	private int arr[];

	public Lonely() {
		arr = new int[100];
		for (int i = 0; i < 100; i++)
			arr[i] = 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String input = in.readLine().trim();

		int n = Integer.parseInt(input);
		input = in.readLine().trim();
		StringTokenizer st = new StringTokenizer(input);
		int result = new Lonely().findLonely(st, n);

		out.write(result + "\n");

		out.flush();
	}

	private int findLonely(StringTokenizer st, int n) {
		int res = -1;
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[val]++;

		}
		for (int i = 0; i < 100; i++) {
			if (arr[i] == 1) {
				res = i;
				break;
			}
		}
		return res;

	}
}
