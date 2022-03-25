/* This program identifies and returns a list of all prime numbers less 
than and equal to a given value n. There are two versions, the above was my 
first attempt and below it I have added my optimized solution */


/***FIRST VERISON***/
import java.util.*;

class SieveOfEratosthenes {
    void sieveOfEratosthenes(int n) {
      // all elements false by default
      boolean[] isPrime = new boolean[n + 1];
      // change all elements to true
      Arrays.fill(isPrime, true);

      List<Integer> res = new ArrayList<>();

      for (int i = 2; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
          // if value is already false, it cannot be prime so 
          // we ignore these values
          if (!(isPrime[i] == false || isPrime[j] == false)) {
            if (j % i == 0) {
              isPrime[j] = false;
            }
          }
        }
      }

      for (int k = 2; k <= n; k++) {
        if (isPrime[k] == true) {
          res.add(k);
        }
      }
      System.out.println(res);
    }

    public static void main(String[] args) {
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(100);
    }
}


/*

***OPTIMIZED VERSION***

import java.util.*;

class SieveOfEratosthenes {
    void sieveOfEratosthenes(int n) {
      // all elements false by default
      boolean[] isPrime = new boolean[n + 1];
      // change all elements to true
      Arrays.fill(isPrime, true);

      List<Integer> res = new ArrayList<>();

      // The inner loop marks multiples of a base value, 
      // so we only need to check numbers lower than the square 
      // root of n
      for (int i = 2; i <= Math.pow(n, 0.5); i++) {
        // Some checks can be skipped as they are already 
        // marked by values before
        for (int j = (int) Math.pow(i, 2); j <= n; j++) {
          // if value is already false, it cannot be prime 
          // so we ignore these values
          if (!(isPrime[i] == false || isPrime[j] == false)) {
            if (j % i == 0) {
              isPrime[j] = false;
            }
          }
        }
      }

      for (int k = 2; k <= n; k++) {
        if (isPrime[k] == true) {
          res.add(k);
        }
      }
      System.out.println(res);
    }

    public static void main(String[] args) {
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(7);
    }
}
*/
