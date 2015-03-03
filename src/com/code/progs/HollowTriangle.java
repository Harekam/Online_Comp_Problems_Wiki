package com.code.progs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HollowTriangle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the rows: ");
		int rows = Integer.parseInt(in.readLine().trim());
		int cols = rows * 2 - 1;
		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= cols; j++) {
				if (i == rows || (j == rows && i == 1)||j==i+rows-1||j==rows-i)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();

		}
	}

}
