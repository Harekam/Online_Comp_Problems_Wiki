package com.code.progs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by harekam singh on 3/3/2015.
 */
public class SpiralMatrix {
    private int matrix[][];

    SpiralMatrix(int row, int col) {
        matrix = new int[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String input = in.readLine().trim();
        StringTokenizer st = new StringTokenizer(input);
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        SpiralMatrix spiralMatrix = new SpiralMatrix(row, col);


        for (int i = 0; i < row; i++) {
            input = in.readLine().trim();
            st = new StringTokenizer(input);
            for (int j = 0; j < col; j++) {
                spiralMatrix.matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuffer sb = new StringBuffer("");
        int r = 0, c = 0;
        while (r < row && c < col) {
            //first row
            for (int i = c; i < col; i++)
                sb.append(spiralMatrix.matrix[r][i] + " ");
            r++;
            //last col
            for (int i = r; i < row; i++)
                sb.append(spiralMatrix.matrix[i][col - 1] + " ");
            col--;
            if (r < row) {
                for (int i = col - 1; i >= c; i--)
                    sb.append(spiralMatrix.matrix[row - 1][i] + " ");
                row--;
            }
            if (c < col) {
                for (int i = row - 1; i >= r; i--)
                    sb.append(spiralMatrix.matrix[i][c] + " ");
                c++;
            }
        }
        out.write(sb.toString());
        out.flush();
    }
}
