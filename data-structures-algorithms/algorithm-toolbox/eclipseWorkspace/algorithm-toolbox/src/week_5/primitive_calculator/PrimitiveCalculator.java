package week_5.primitive_calculator;

import java.util.*;

public class PrimitiveCalculator {
    private static Scanner scanner;

    private static List<Integer> greedy_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    static List<Integer> min(List<Integer> a, List<Integer> b) {
        int m, v;
        List<Integer> l = new ArrayList<Integer>();
        if(a.get(0) > b.get(0)) {
            m = b.get(0);
            v = b.get(1);
        }
        else {
            m = a.get(0);
            v = a.get(1);
        }
        l.add(m);
        l.add(v);
        return l;
    }
    
    static List<Integer> min(List<Integer> a, List<Integer> b, List<Integer> c) {
        return min(min(a, b), c);
    }
    
    static int min(int a, int b) {
        return (a > b)?b:a;
    }
    
    static int min(int a, int b, int c) {
        return min(min(a, b), c);
    }
    
    private static List<Integer> dp_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int [] c = new int[n+1];
        int a1, a2, a3;
        c[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            a1 = 1000000;
            a2 = 1000000;
            a3 = 1000000;
            if(i%2 == 0) {
                a1 = c[i/2]+1;
            }
            if(i%3 == 0) {
                a2 = c[i/3]+1;
            }
            a3 = c[i-1]+1;
            int m = min(a1, a2, a3);
            c[i] = m;
        }
        System.out.println(c[n]);
        for(int i = n; i > 1; ) {
            a1 = 1000000;
            a2 = 1000000;
            a3 = 1000000;
            if(i%2 == 0) {
                a1 = c[i/2]+1;
            }
            if(i%3 == 0) {
                a2 = c[i/3]+1;
            }
            a3 = c[i-1]+1;
            int m = min(a1, a2, a3);
            if(m == a1) {
                sequence.add(i/2);
                i /= 2;
            }
            else if(m == a2) {
                sequence.add(i/3);
                i /= 3;
            }
            else {
                sequence.add(i-1);
                i--;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dp_sequence(n);
        sequence.add(n);
        //System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

