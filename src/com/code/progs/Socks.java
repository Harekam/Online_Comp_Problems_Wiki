package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Socks {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			int n = Integer.parseInt(input);
			n = n + 1;
			out.write(n + "\n");

		}
		out.flush();
	}
}
