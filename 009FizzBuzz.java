/* 
This program prints "Fizz" instead of multiples of 3, "Buzz" instead 
of multiples of 5, and "FizzBuzz" instead of multiples of 3 and 5 

Concepts used: Loops
*/


public class FizzBuzz {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
