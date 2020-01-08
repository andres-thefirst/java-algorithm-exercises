package com.andres.thefirst.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;

class FindLongestWordV3 {
  String S;
  List<String> D;

  public FindLongestWordV3(String S, List<String> D) {
    this.S = S;
    this.D = D;
  }

  public String find() {
    String result = "";
    String[] secuence = S.split(""); 
    List<String> foundWords = new ArrayList<>();
    Map<String, List<Tuple<String, Integer>>> alphabetMap = generateMapOfAlphabet();
    for (String word: D) {
      List<Tuple<String, Integer>> listByLetter = alphabetMap.get(String.valueOf(word.charAt(0)));
      listByLetter.add(new Tuple<String, Integer>(word, 0));
    }

    for(String letter: secuence) {
      List<Tuple<String, Integer>> listByLetter = alphabetMap.get(letter);
      while(listByLetter.size() > 0) {
        Tuple<String, Integer> tuple = ((LinkedList<Tuple<String, Integer>>)listByLetter).pop();
        tuple.index += 1;
        if (tuple.word.length()-1 == tuple.index) {
          foundWords.add(tuple.word);
        } else {
          List<Tuple<String, Integer>> listByLetterNext = alphabetMap.get(String.valueOf(tuple.word.charAt(tuple.index)));
          listByLetterNext.add(tuple);
        }
      }
    }

    for (String word: foundWords) {
      if (word.length() > result.length()) {
        result = word;
      }
    }

    return result;
  }  

  public Map<String, List<Tuple<String, Integer>>> generateMapOfAlphabet() {
    Map<String, List<Tuple<String, Integer>>> wordMap = new HashMap<>();
    for(char c = 'a'; c <= 'z'; c+=1) {
        wordMap.put(String.valueOf(c), new LinkedList<Tuple<String, Integer>>());
    }

    return wordMap;
  }
}

class Tuple<X, Y> {
  public X word;
  public Y index;
  public Tuple(X word, Y index) {
    this.word = word;
    this.index = index;
  }
}
