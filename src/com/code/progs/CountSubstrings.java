package com.code.progs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * http://www.codechef.com/MARCH15/problems/STRSUB
 */
class CountSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String input = in.readLine().trim();
        int testCases = Integer.parseInt(input);
        while (testCases-- > 0) {
            input = in.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String str = in.readLine().trim();
            String substr;
            int numOfStr, zero, one;
            boolean is_q_One = false;
            if (q == 1)
                is_q_One = true;
            while (q-- > 0) {
                input = in.readLine().trim();
                st = new StringTokenizer(input);
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                substr = str.substring(left - 1, right);
                numOfStr = numberOfSubStrings(substr.length());
                int kToBeUsed = k;
                if (is_q_One)
                    kToBeUsed = min(5, n);
                int not = countZeroOne(substr, kToBeUsed);
                int result = numOfStr - not;
                out.write(result + "\n");

            }
        }
        out.flush();
    }

    public static int min(int a, int b) {
        return (a < b ? a : b);
    }

    public static int countZeroOne(String str, int k) {
        int zero = 0, one = 0, not = 0;
        int len = str.length();
        for (int j = 0; j < len; j++) {
            for (int i = j; i < len; i++) {
                if (str.charAt(i) == '0')
                    zero++;
                else
                    one++;
                if (zero > k || one > k)
                    not++;

            }
            zero = one = 0;
        }

        return not;
    }

    public static int numberOfSubStrings(int n) {
        return n * (n + 1) / 2;
    }
}
