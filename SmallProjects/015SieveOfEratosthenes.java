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
