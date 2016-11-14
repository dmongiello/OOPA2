/*
 * File name : PositiveWords.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  This class implements a singleton arraylist to hold positive words
 */
package OOPA2.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidmongiello
 */
public class PositiveWords
{
  public final static PositiveWords INSTANCE = new PositiveWords();
  private ArrayList<String> words = new ArrayList<>();
  // Add words to this and they will be included in the count of positive words
  // in tweets. The percentage will then be calculated. 
  public PositiveWords()
  {
    words.add("good");
    words.add("positive");
    words.add("david");
    words.add("pure");
    words.add("nuke");
    words.add("cat");
  }
  
  public ArrayList<String> getWords()
  {
    return words; 
  }
}
