package week_2.lcm;

import java.util.*;

public class LCM {
  private static Scanner scanner;

  private static int gcd_fast(int a, int b) {      
      if (b == 0) {
          return a;
      }
      else {
          return gcd_fast(b, a%b);
      }
    }

  
  private static long lcm(int a, int b) {
    return (((long)a)*((long)b))/gcd_fast(a, b);
  }

  public static void main(String args[]) {
    scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
