/* This program implements some of the basic arithmetic functions as methods within a class */

public class Calculator {
  public Calculator() {}

  public int add(int x, int y) {
    return (x + y);
  }

  public int subtract(int x, int y) {
    return (x - y);
  }

  public int multiply(int x, int y) {
    return (x * y);
  }

  public int divide(int x, int y) {
    return (x / y);
  }

  public int modulo(int x, int y) {
    return (x % y);
  }

  public static void main(String[] args) {
    Calculator myCalculator = new Calculator();

    // adding two integers
    System.out.println(myCalculator.add(5, 7));

    // subtracting two integers
    System.out.println(myCalculator.subtract(45, 11));

    // multiplying two integers
    System.out.println(myCalculator.multiply(4, 9));

    // finding the quotient when dividing two integers
    System.out.println(myCalculator.divide(17, 3));

    // finding the remainder when dividing two integers
    System.out.println(myCalculator.modulo(17, 3));
  }
}
