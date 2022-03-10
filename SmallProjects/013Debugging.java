/*
This program had many syntax errors. I debugged the program.

Concepts used: Debugging
*/

import java.lang.Math;

class Fortune {

  public int generateRandom() {
    
    return (int)(Math.random() * 10);
    
  }
// Syntax error: Main written instead of main
  public static void main(String[] args) {

    Fortune fortuneCookie = new Fortune();
    int fortune = fortuneCookie.generateRandom();
 // Syntax error: Used = instead of ==   
    if (fortune == 0) {

      System.out.println("Flattery will go far tonight.");
    
    } else if (fortune == 1) {
// Syntax error: Missing ;  
      System.out.println("Don't behave with cold manners.");
    
    } else if (fortune == 2) {
        
      System.out.println("May you someday be carbon neutral");
        
    } else if (fortune == 3) {
        
      System.out.println("You have rice in your teeth.");
        
    } else if (fortune == 4) {
        
      System.out.println("A conclusion is simply the place where you got tired of thinking.");
// Syntax error: else if (fortune ==) {
    } else if (fortune == 5) {
        
      System.out.println("No snowflake feels responsible in an avalanche.");
        
    } else if (fortune == 6) {
        
      System.out.println("He who laughs last is laughing at you.");
        
    } else if (fortune == 7) {
        
      System.out.println("If you look back, you'll soon be going that way.");
        
    } else if (fortune == 8) {
        
      System.out.println("You will die alone and poorly dressed.");
// Syntax error: Missing ')'
    } else if (fortune == 9) {
        
      System.out.println("The fortune you seek is in another cookie.");
        
    }
    
  }
  
}
