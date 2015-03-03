package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringSub {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		StringTokenizer st = new StringTokenizer(input);
		String s1 = st.nextToken().toLowerCase();
		String s2 = st.nextToken().toLowerCase();
		char sarr1[] = s1.toCharArray();
		char sarr2[] = s2.toCharArray();

		int count = 0;
		int len1 = sarr1.length;
		int len2 = sarr2.length;

		count = lcs(sarr1, sarr2, len1, len2);

		out.write(Integer.toString(count));
		out.flush();

	}

	private static int lcs(char[] sarr1, char[] sarr2, int s1, int s2) {
		int L[][] = new int[s1 + 1][s2 + 1];
		int i, j;

		for (i = 0; i <= s1; i++) {
			for (j = 0; j <= s2; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (containsVowel(sarr1[i - 1])
						|| containsVowel(sarr2[j - 1]))
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
				else if (sarr1[i - 1] == sarr2[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;

				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}

		return L[s1][s2];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static boolean containsVowel(char x) {
		char vowel[] = { 'a', 'e', 'i', 'o', 'u' };
		int len = vowel.length;
		int r = len - 1;
		int l = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;

			if (vowel[m] == x)
				return true; // Check if x is present at mid

			if (vowel[m] < x)
				l = m + 1; // If x greater, ignore left half

			else
				r = m - 1; // If x is smaller, ignore right half
		}
		return false;
	}
}