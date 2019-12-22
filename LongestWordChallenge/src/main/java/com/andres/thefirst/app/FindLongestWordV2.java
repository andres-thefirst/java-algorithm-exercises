package com.andres.thefirst.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindLongestWordV2 {
  String S;
  List<String> D;

  public FindLongestWordV2(String S, List<String> D) {
    this.S = S;
    this.D = D;
  }

  public String find() {
    Map<String, Integer> wordMap = getMapFromString(this.S);
    String result = "";

    for(Object wordItem: D.toArray()) {
      HashMap<String, Integer> shallowWordMap = new HashMap<String, Integer>(wordMap);
      String word = (String) wordItem;
      int counter = 0;
      boolean finish = true;
      
      for (int i = 0; i < word.length(); i++) {
        Integer value = shallowWordMap.get(Character.toString(word.charAt(i)));
        if (value == null) {
          finish = false;
          i = word.length();
          continue;
        }
        if (value > 0) {
          counter++;
          value -= 1;
          shallowWordMap.put(Character.toString(word.charAt(i)), value);
        }
      }

      if (result.length() < counter && finish) {
        result = word;
      }
    }

    return result;
  } 

  public Map<String, Integer> getMapFromString(String S) {
    Map<String, Integer> wordMap = new HashMap<>();
    String[] secuence = S.split(""); 
    for (String item: secuence) {
      Integer count = wordMap.get(item);
      if (count == null) {
        wordMap.put(item, 1);
      } else {
        wordMap.replace(item, count + 1);
      }
    }

    return wordMap;
  }
}
