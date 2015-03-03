package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class RankList {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			long s = Long.parseLong(st.nextToken());
			long sum = s;
			long count = 0;
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = 1;
				sum--;
			}
			int k = 1;
			int i = 1;
			while (sum > 0) {
				arr[i] += k;
				sum -= k;
				if (sum > k)
					k++;
				if (i < n - 1)
					i++;
			}

			// System.out.println(Arrays.toString(arr));
			Arrays.sort(arr);
			// System.out.println(Arrays.toString(arr));
			for (int j = 1; j < n; j++) {
				if (arr[j] - arr[j - 1] != 1)
					count++;
			}
			out.write(count + "");
			out.write("\n");
		}
		out.flush();
	}
}
