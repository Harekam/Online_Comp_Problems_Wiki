package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConnectingTowns {
	private final static int MODULO = 1234567;

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
			long result = 1;
			for (int i = 0; i < n - 1; i++) {
				int val = Integer.parseInt(st.nextToken());
				result = (result * val) % MODULO;
			}

			out.write(result + "\n");

		}
		out.flush();
	}
}
