package week_2.fibonacci;

import java.util.Scanner;

public class Fib {
  private static Scanner in;

  @SuppressWarnings("unused")
  private static long calc_fib(int n) {
      if (n <= 1)
        return n;

      return calc_fib(n - 1) + calc_fib(n - 2);
    }

  private static long calc_fib_lin(int n) {
      if (n <= 1)
        return n;

      int i = 1;
      long a = 0, b = 1, c = a+b;
      
      while(i < n) {
          c = a+b;
          a = b;
          b = c;
          i++;
      }
      
      return c;
    }

  public static void main(String args[]) {
    in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_lin(n));
  }
}
