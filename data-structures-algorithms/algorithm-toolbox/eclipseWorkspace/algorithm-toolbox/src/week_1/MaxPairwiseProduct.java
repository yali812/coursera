package week_1;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	static int getNaiveMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

	static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        int m1, m2;
        m1 = (numbers[0] > numbers[1])?(numbers[0]):(numbers[1]);
        m2 = (numbers[0] > numbers[1])?(numbers[1]):(numbers[0]);
        for (int i = 2; i < n; ++i) {
        	if(numbers[i] > m2) {
        		if(numbers[i] > m1) {
        		    m2 = m1;
        		    m1 = numbers[i];
        		}
        		else {
        		    m2 = numbers[i];
        		}
        	}
        }
        //System.out.println(m1 + " " + m2);
        long result = ((long)m1)*((long)m2);
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}