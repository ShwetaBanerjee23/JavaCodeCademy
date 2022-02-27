public class SinoTibetan extends Language {
  
  // Sino-Tibetan languages have some traits in common
  SinoTibetan (String name, int numSpeakers) {
    
    // The Chinese languages switched the object and verb order so there is a split 
    // in the Sino-Tibetan family - one tactic is to check if the language's name 
    // field contains "Chinese"
    super(name, numSpeakers, "Asia", "subject-object-verb");
    
    if (this.name.contains("Chinese")) {
      
      this.wordOrder = "subject-verb-object";
      
    }
  
  }
}
