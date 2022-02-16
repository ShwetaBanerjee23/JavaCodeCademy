/*
This program determines whether there is a protein in a strand of DNA

Concepts used: String methods
*/

public class DNA {
  public void hasProtein(String dna) {
    int begin = dna.indexOf("ATG");
    String firstThree = dna.substring(begin,begin + 3);
    int end = dna.indexOf("TGA");
    String finalThree = dna.substring(end, end + 3);
    int len = end - begin - 3;

    // indexOf() returns -1 if substring is not found
    if (begin != -1 && end != -1) {
        
        // a codon is 3 nucleotides so number of nucleotides between ATG 
        // and TGA must be divisible by 3
        if(len % 3 == 0) {
          String protein = dna.substring(begin, end + 3);
          System.out.println(protein);
        } else {
          System.out.println("No protein.");
        }
    }
  }

  public static void main(String[] args) {
    DNA d = new DNA();
    String dna1 = "ATGCGATACGCTTGA";
    String dna2 = "ATGCGATACGTGA";
    String dna3 = "ATTAATATGTACTGA";
    
    // testing hasProtein()
    d.hasProtein(dna1);
    d.hasProtein(dna2);
    d.hasProtein(dna3);

  }
}
