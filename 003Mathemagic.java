/*
This program performs a series of calculations on a variable integer (myNumber) 
and returns 3 as a result each time, regardless of what myNumber is.
*/

public class Magic {
	public static void main(String[] args) {
    // Referred to as original number from now on.
    int myNumber = 9;
    int stepOne = myNumber * myNumber;
    int stepTwo = stepOne + myNumber;
    int stepThree = stepTwo / myNumber;
    int stepFour = stepThree + 17;
    int stepFive = stepFour - myNumber;
    int stepSix = stepFive / 6;

    System.out.println(stepSix);

	}
}
