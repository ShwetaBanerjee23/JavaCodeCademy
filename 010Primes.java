/* 
This program creates an ArrayList of all primes from a given array of numbers 

Concepts used: Loops, arrays, and ArrayLists
*/

import java.util.ArrayList;

class PrimeDirective {

  public boolean isPrime(int number) {
    if (number > 1) {
      if (number == 1) { // edge case
        return false;
      } else if (number == 2){ // edge case
        return true;
      } else {
        for (int i = 2; i < number; i++) {
          if (number % i == 0) {
            return false;
          }
        }
        return true;
      }
    }
  return false;  
  }

  public ArrayList<Integer> onlyPrimes(int[] numbers) {
      ArrayList<Integer> primes = new ArrayList<Integer>();

      for (int number : numbers) {
        if (isPrime(number)) {
          primes.add(number);
        }
      }
      return primes;
    }

  
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    int[] numbers = {1, 2, 3, 6, 100, 26, 37, 662, 63, 717};

    // tests isPrime
    System.out.println(pd.isPrime(1));
    System.out.println(pd.isPrime(2));
    System.out.println(pd.isPrime(109379));

     // tests onlyPrime
    System.out.println(pd.onlyPrimes(numbers));
  }  
}
