package com.example;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Main {
  public static Set<Character> VOWELS = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'y'));;

  public static void main(String[] args) {
    findVowelInARow("abciiidef", 3); // 3
    findVowelInARow("aeiou", 6); // 5
    findVowelInARow("bcdfgh", 5); // 0
  }

  public static int findVowelInARow(String word, int k) {
    int lastMax = 0;
    int rowVowels = 0;

    CharacterIterator iterator = new StringCharacterIterator(word);
    while (iterator.current() != CharacterIterator.DONE) {
      char current = iterator.current();
      if (VOWELS.contains(current)) {
        rowVowels += 1;

        if (rowVowels == k) {
          return k;
        }

        if (rowVowels > lastMax) {
          lastMax = rowVowels;
        }
      } else {
        rowVowels = 0;
      }

      iterator.next();
    }

    return lastMax;
  }
}
