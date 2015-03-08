package com.code.progs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by harekam on 03/07/2015.
 */
class DipInterNum {
    private  long prime[] = new long[1000];
    DipInterNum(){
        for (int i = 0; i < 1000; i++)
            prime[i] = 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String input = in.readLine().trim();
        int testCases = Integer.parseInt(input);
        while (testCases-- > 0) {
            input = in.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            long L =Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long mul = 1, odd = 0;
            StringBuffer sb = new StringBuffer("");
            for (long i = L; i <= R; i++) {
                DipInterNum pd=new DipInterNum();
               pd.primeFactor(i);

                for (int j = 0; j < 1000; j++) {
                    if (pd.prime[j] > 0) {
                        mul *= (pd.prime[j] + 1);
                    }
                }
                System.out.println("fact of "+i+" is "+mul);
                if (mul % 2 != 0)
                    odd++;
                mul = 1;

            }
            out.write(odd + "\n");
        }
        out.flush();
    }

    public void primeFactor(long n) {

        while (n % 2 == 0) {
            prime[2]++;

            n = n / 2;
        }

        // n must be odd at this point.  So we can skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                prime[i]++;

                n = n / i;
            }
        }

        // This condition is to handle the case whien n is a prime number
        // greater than 2
        if (n > 2)
            prime[((int) n)]++;
    }

}

