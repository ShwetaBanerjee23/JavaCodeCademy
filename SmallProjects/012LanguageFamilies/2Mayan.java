public class Mayan extends Language {

  // Mayan languages have some common traits
  Mayan (String name, int numSpeakers) {
    super(name, numSpeakers, "Central America", "verb-object-subject");
  }

  // Mayan languages have an interesting grammatical feature: ergativity
  @Override
  public void getInfo() {
    super.getInfo();
    System.out.println("Fun fact: " + this.name + " is an ergative language.");
  }
}
