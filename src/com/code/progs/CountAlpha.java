package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CountAlpha {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			input = input.toUpperCase();
			char arr[] = input.toCharArray();
			int len = arr.length;
			int countalpha[] = count(arr, len);
			int count = 0;
			for (int i = 0; i < 26; i++) {
				if (countalpha[i] > 1)
					count++;
			}
			out.write(Integer.toString(count));
			out.write("\n");
		}
		out.flush();

	}

	private static int[] count(char str[], int len) {
		int alpha[] = new int[26];
		for (int i = 0; i < 26; i++) {
			alpha[i] = 0;
		}
		for (int i = 0; i < len; i++) {
			char at = str[i];
			switch (at) {
			case 'A':
				alpha[0]++;
				break;
			case 'B':
				alpha[1]++;
				break;
			case 'C':
				alpha[2]++;
				break;
			case 'D':
				alpha[3]++;
				break;
			case 'E':
				alpha[4]++;
				break;
			case 'F':
				alpha[5]++;
				break;
			case 'G':
				alpha[6]++;
				break;
			case 'H':
				alpha[7]++;
				break;
			case 'I':
				alpha[8]++;
				break;
			case 'J':
				alpha[9]++;
				break;

			case 'K':
				alpha[10]++;
				break;
			case 'L':
				alpha[11]++;
				break;
			case 'M':
				alpha[12]++;
				break;
			case 'N':
				alpha[13]++;
				break;
			case 'O':
				alpha[14]++;
				break;

			case 'P':
				alpha[15]++;
				break;
			case 'Q':
				alpha[16]++;
				break;
			case 'R':
				alpha[17]++;
				break;
			case 'S':
				alpha[18]++;
				break;
			case 'T':
				alpha[19]++;
				break;

			case 'U':
				alpha[20]++;
				break;
			case 'V':
				alpha[21]++;
				break;
			case 'W':
				alpha[22]++;
				break;
			case 'X':
				alpha[23]++;
				break;
			case 'Y':
				alpha[24]++;
				break;
			case 'Z':
				alpha[25]++;
				break;

			}
		}
		return alpha;
	}

}
