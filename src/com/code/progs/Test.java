package com.code.progs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine().trim();
		StringTokenizer st = new StringTokenizer(input);
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int fact;
		int sn;
		ArrayList<Integer> rsums = new ArrayList<Integer>();
		for (int i = n1; i <= n2; i++) {
			if (i < 6) {
				fact = factorial(i);
				sn = sum(fact);
				while (sn >= 10) {
					sn = sum(sn);
				}
				rsums.add(sn);

			} else {
				rsums.add(9);
			}
		}
		// System.out.println("Factorial is " + fact);
		long sum = 0;
		for (Integer temp : rsums) {
			sum += temp;
		}

		System.out.println("Sum: " + sum);

	}

	public static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static int sum(int i) {
		int a = 0, sum = 0;

		while (i != 0) {
			a = i % 10;
			i = i / 10;
			sum = sum + a;
		}
		return sum;
	}
}
