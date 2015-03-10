package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class BobGirl {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {

			input = in.readLine().trim();
			input = input.toUpperCase();

			char[] orignal = input.toCharArray();
			input = in.readLine().trim();
			input = input.toUpperCase();
			char[] messed = input.toCharArray();
			
			int lenOrig = orignal.length, lenMess = messed.length;
			int op = 0;
			if (lenMess == lenOrig) {
				for (int i = 0; i < lenOrig; i++) {
					if (orignal[i] != messed[i])
						op++;
				}
			} else if (lenOrig > lenMess)
				op = lenOrig - lenMess;
			else if (lenMess > lenOrig)
				op = lenMess - lenOrig;
			out.write(Integer.toString(op));
			out.write("\n");
		}
		out.flush();
	}

}
