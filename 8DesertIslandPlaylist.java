/*
This program creates a playlist of 5 songs

Concepts used: ArrayLists
*/

import java.util.ArrayList;

class Playlist {
  
  public static void main(String[] args) {
    ArrayList<String> desertIslandPlaylist = new ArrayList<String>();

    desertIslandPlaylist.add("Bad habits");
    desertIslandPlaylist.add("Stay");
    desertIslandPlaylist.add("Nobody but you");
    desertIslandPlaylist.add("Right here");
    desertIslandPlaylist.add("I wanna go");
    desertIslandPlaylist.add("Outline");

    System.out.println(desertIslandPlaylist);
    System.out.println(desertIslandPlaylist.size());

    // removing songs to reduce size to 5
    desertIslandPlaylist.remove("Bad habits");

    System.out.println(desertIslandPlaylist);
    System.out.println(desertIslandPlaylist.size());

    // swapping the order of songs
    int i = desertIslandPlaylist.indexOf("Nobody but you");
    int j = desertIslandPlaylist.indexOf("Stay");
    String tmp = desertIslandPlaylist.get(i);
    desertIslandPlaylist.set(i, desertIslandPlaylist.get(j));
    desertIslandPlaylist.set(j, tmp);

    System.out.println(desertIslandPlaylist);
  }
}
