package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Population {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			StringTokenizer st = new StringTokenizer(input);
			char[] sarr1 = st.nextToken().toCharArray();
			char[] sarr2 = st.nextToken().toCharArray();
			int len1 = sarr1.length, len2 = sarr2.length;

			if (len1 == len2) {
				int result = anagram(sarr1, sarr2, len1, len2);
				if (result == len1 && result == len2)
					out.write("YES");
			} else
				out.write("NO");
			out.write("\n");
		}
		out.flush();
	}

	private static int anagram(char sarr1[], char sarr2[], int len1, int len2) {
		int sz[] = new int[len2];
		int i, j;

		for (j = 0; j < len2; j++)
			sz[j] = 0;

		for (i = 0; i < len1; i++) {
			for (j = 0; j < len2; j++) {

				if (sz[j] == 0 && (sarr1[i] == sarr2[j])) {
					sz[j] = 1;
					break;
				}
			}
		}
		int sum = 0;
		for (j = 0; j < len2; j++)
			sum += sz[j];

		return sum;
	}

}
