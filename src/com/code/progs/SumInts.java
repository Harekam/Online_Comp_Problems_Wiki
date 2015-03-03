package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SumInts {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			char arr[] = input.toCharArray();
			int len = arr.length;

			int sum = 0;

			for (int i = 0; i < len; i++) {
				int temp = 0;

				while ((arr[i] >= '0') && (arr[i] <= '9')) {
					temp = temp * 10 + arr[i] - '0';
					++i;
					if (i >= len)
						break;
				}
				sum = sum + temp;
			}
			out.write(Integer.toString(sum));
			out.write("\n");
		}
		out.flush();

	}
}
