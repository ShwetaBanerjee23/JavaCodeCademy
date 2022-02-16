/* This program calculates the monthly car payment a user should expect to make 
after taking out a car loan given the following:
- The cost of the car
- The length of the loan
- The interest rate
- The down payment

Concepts used: Conditionals, Boolean Expressions, Arithmetic Expressions */

public class CarLoan {
	public static void main(String[] args) {
    int carCost = 10000;
    int loanLength = 3; // in years
    int interestRate = 5; // percentage
    int downPayment = 2000;

    if (loanLength <= 0 || interestRate <= 0) {
      System.out.println("Invalid input: Check input for loanLength/interestRate.");
    } else if (downPayment > carCost) {
      System.out.println
        ("Invalid input: Car can be paid in full, check input for carCost and downPayment");
    } else {
      int remainingBalance = carCost - downPayment;
      int months = loanLength * 12;
      int monthlyBalance = remainingBalance 
      / months;
      int interest = monthlyBalance 
      * interestRate / 100;
      int monthlyPayment = monthlyBalance 
      + interest;

      System.out.println("The monthly payment is: " + monthlyPayment);

    }
	}
}
