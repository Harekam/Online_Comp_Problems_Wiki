package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class PrimeDiv {
	

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String input = in.readLine().trim();
		int testCases = Integer.parseInt(input);
		while (testCases-- > 0) {
			input = in.readLine().trim();
			StringTokenizer st = new StringTokenizer(input);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (n > 5)
				out.write("0");
			else {
				int result = prime(x, y, n);

				out.write(Integer.toString(result));
			}
			out.write("\n");
		}
		out.flush();
	}

	private static int prime(int x, int y, int n) {
		int primeDivisors = 0;
		for (int i = x; i <= y; i++) {
			int temp = countPrime(i);
			 System.out.println("i: " + i + " c: " + temp);
			if (temp == n)
				primeDivisors++;
		}
		return primeDivisors;
	}

	private static int countPrime(int n) {
		// Print the number of 2s that divide n
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int count = 0;
		while (n % 2 == 0) {
			if (count == 0)
				count++;
			else
				n = n / 2;
		}

		// n must be odd at this point. So we can skip one element (Note i = i
		// +2)

		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				// primes.add(i);
				if (!primes.contains(i)) {
					primes.add(i);
					count++;
				}
				n = n / i;
			}

		}

		// This condition is to handle the case whien n is a prime number
		// greater than 2
		if (n > 2)
			count++;
		return count;

	}

}
