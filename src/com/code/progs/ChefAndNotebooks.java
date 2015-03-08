package com.code.progs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * http://www.codechef.com/MARCH15/problems/CNOTE
 */
class ChefAndNotebooks {
    public static void main(String[] args) throws IOException {
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
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int p[] = new int[n];
            int c[] = new int[n];
            for (int i = 0; i < n; i++) {
                input = in.readLine().trim();
                st = new StringTokenizer(input);
                p[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            boolean flag = false;
            for (int i = 0; i < n; i++)
                if ((p[i] >= x - y) && c[i] <= k) {
                    flag = true;
                    break;
                }
            if (flag)
                out.write("LuckyChef" + "\n");
            else
                out.write("UnluckyChef" + "\n");
        }
        out.flush();
    }
}
