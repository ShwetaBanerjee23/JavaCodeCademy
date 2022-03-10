public class Language {
  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder;

  public Language (String name, int numSpeakers, String regionsSpoken, String wordOrder) {
    this.name = name;
    this.numSpeakers = numSpeakers;
    this.regionsSpoken = regionsSpoken;
    this.wordOrder = wordOrder;
  }

  public void getInfo() {
    System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " 
                       + regionsSpoken + ". The language follows the word order: " + wordOrder);
  }

  public static void main(String[] args) {

    // Testing Language class
    Language spanish = 
      new Language("Spanish", 555000000, "Spain, Latin America, and Equatorial Guinea", 
                                    "subject-verb-object");
    spanish.getInfo();
  
  // Testing Mayan class
  Language mayan = new Mayan("Ki'che'", 2330000);
  mayan.getInfo();

  // Testing SinoTibetan class
  Language mandarinChinese = new SinoTibetan("Mandarin Chinese", 1117000);
  mandarinChinese.getInfo();

  Language burmese = new SinoTibetan("Burmese", 33000000);
  burmese.getInfo();
  }
  
}
