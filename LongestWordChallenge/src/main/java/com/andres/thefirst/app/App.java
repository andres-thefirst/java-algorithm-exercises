package com.andres.thefirst.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    
  public static void main(String args[]) {
    String S = "abppplee";
    List<String> D = new ArrayList<>();
    D.add("able");
    D.add("ale");
    D.add("apple");
    D.add("bale");
    D.add("kangaroo");
    FindLongestWord findLongestWord = new FindLongestWord(S, D);
    String longestWord = findLongestWord.find();
    System.out.println(longestWord);
  }
}

class FindLongestWord {
  String S;
  List<String> D;
  public FindLongestWord(String S, List<String> D) {
    this.S = S;
    this.D = D;
  }

  public String find() {
    String longestWord = "";
    int countCharacters;
    for(Object wordItem: D.toArray()) {
      String word = (String) wordItem;
      int startFromNextCharacterIndex = 0;
      countCharacters = 0;
      for (int i = 0; i < word.length(); i++) {
        int foundInIndex = S.indexOf(word.charAt(i), startFromNextCharacterIndex);
        if (foundInIndex != -1) {
          startFromNextCharacterIndex = foundInIndex + 1;
          countCharacters += 1;
        }
      }
      if (longestWord.length() < countCharacters) {
        longestWord = word;
      }
    }

    return longestWord;
  }
}
