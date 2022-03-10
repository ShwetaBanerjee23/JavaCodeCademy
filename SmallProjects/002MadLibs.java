public class MadLibs {
  /*
  This program generates passages that are generated in mad-lib format. 
  It prints the story with the previously declared variables matched to the right places. 

Author: Shweta Banerjee
  */
  	public static void main(String[] args){
      
      String name1 = "Shweta";

      String adjective1 = "red";
      String adjective2 = "pretty";
      String adjective3 = "shiny";

      String verb1 = "dance";

      String noun1 = "pen";
      String noun2 = "fruit";
      String noun3 = "fish";
      String noun4 = "piano";
      String noun5 = "computer";
      String noun6 = "sky";

      String name2 = "Adi";

      int number = 9;

      String place1 = "New York";

      
      //The template for the story
      String story = "This morning "+name1+" woke up feeling "+adjective1+". 'It is going to be a "+adjective2+" day!' Outside, a bunch of "+noun1+"s were protesting to keep "+noun2+" in stores. They began to "+verb1+" to the rhythm of the "+noun3+", which made all the "+noun4+"s very "+adjective3+". Concerned, "+name1+" texted "+name2+", who flew "+name1+" to "+place1+" and dropped "+name1+" in a puddle of frozen "+noun5+". "+name1+" woke up in the year "+number+", in a world where "+noun6+"s ruled the world.";
       System.out.println(story);
    }
}
