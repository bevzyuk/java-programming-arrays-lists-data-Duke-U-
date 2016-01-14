
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class WordPlay {
    private char[] vowel = new String("aeiou").toCharArray();
    
    public boolean isVowel(Character ch) {
       
     for(int i=0; i<vowel.length;i++){
        if (ch.equals(Character.toLowerCase(vowel[i]))){
            return true;
        }
     }
        return false;
    }

    
    public String emphasize(String phrase, Character ch) {
       StringBuilder sb = new StringBuilder(phrase);
        for(int i = 0;i< phrase.length();i++){
            //Use additional variable to store char in lowerCase
         //  char ch2 = Character.toLowerCase(phrase.charAt(i));
            if(ch.equals(Character.toLowerCase(phrase.charAt(i))) ){
                if(i%2 == 0){
                    sb.setCharAt(i,'*');
                // sb.append('*');
                }else {
                    sb.setCharAt(i,'+');
                // sb.append('+');
                }
            }
            /*else{sb.append(phrase.charAt(i));}*/
        }
      return sb.toString();
    }

    
    public String replaceVowels(String phrase, Character ch) {
         StringBuilder sb = new StringBuilder(phrase);
        for(int i = 0;i< phrase.length();i++){             
            if(isVowel(phrase.charAt(i))){
                sb.setCharAt(i, ch);
             //   sb.append(ch);
            }
            //else{sb.append(phrase.charAt(i));}
        }
        return sb.toString();
    }

    public void testVowel() {
       String st = "This is test string";
       for(int i=0; i<st.length();i++){
           Character ch = st.charAt(i);
           System.out.println(ch + " is vowel: " + isVowel(ch));
       }
       //Test replaceVowels method
       System.out.println(replaceVowels("Hello World",'*'));
       
       //Test emphaseze method
       System.out.println(emphasize("dna ctgaaactga", 'a'));
       
       System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
}

}
