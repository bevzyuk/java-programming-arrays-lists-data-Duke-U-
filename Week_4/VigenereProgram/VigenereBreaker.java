import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        message = message.substring(whichSlice);
        for (int i = 0; i < message.length(); i++) {
            if (i % totalSlices == 0) {
               sb.append(message.charAt(i));
            }
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for (int i = 0; i < key.length; i++) {
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[i] = cc.getKey(sliceString(encrypted, i, key.length));
        }
        //printAllKeys(key);
        return key;
    }

    private void printAllKeys(int[] key) {
        System.out.print("PRINT KEYS:");
        for (int i : key) {
            System.out.print(i + ",");
        }
    }

    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dicrionary = new HashSet<>();
        for (String word : fr.lines()) {
            dicrionary.add(word.toLowerCase());
        }
        return dicrionary;
    }

    public char mostCommonCharIn(HashSet<String> dictionary) {
        char mostCommonChar='0';
        HashMap<Character, Integer> map = new HashMap<>();
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            int maxIdx = 0;
            for (Character s : map.keySet()) {
                if (map.get(s) > maxIdx) {
                    maxIdx = map.get(s);
                    mostCommonChar = s;
                }
            }
        }
        return mostCommonChar;
    }

    public void testMostCommonCharIn() {
        FileResource fr = new FileResource();
        HashSet<String> dict = readDictionary(fr);
        System.out.println("Most common char is "+ mostCommonCharIn(dict));
    }

    public String breakForAllLanguages(String encrypted, HashMap<String, HashSet<String>> languages) {
        String decrypted;
        int maxWord = 0;
        String realLanguage="";
        for (String language : languages.keySet()) {
            HashSet<String> dictionary = languages.get(language);
            decrypted = breakForLanguage(encrypted, dictionary);
            int realWords = countWords(decrypted, dictionary);
            if (maxWord < realWords) {
                maxWord = realWords;
                realLanguage = language;
            }
        }
        decrypted = breakForLanguage(encrypted, languages.get(realLanguage));
        System.out.println("Real language is: "+ realLanguage);
        System.out.println("Word in dictionary: " + maxWord);
        System.out.println("Key length: "+countWords(decrypted,languages.get(realLanguage)));
        return decrypted;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        String[] words = message.split("\\W");
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted, HashSet<String> dicrionary) {
        String dectypted = "";
        int key = 0;
        int k = 0;
        char commonChar = mostCommonCharIn(dicrionary);
        for (int i = 1; i < 100; i++) {
            VigenereCipher vc = new VigenereCipher(tryKeyLength(encrypted, i, commonChar));
            dectypted = vc.decrypt(encrypted);
            if (k < countWords(dectypted, dicrionary)) {
                k = countWords(dectypted, dicrionary);
                key = i;
            }
        }
        VigenereCipher vc = new VigenereCipher(tryKeyLength(encrypted, key, commonChar));
      //  printAllKeys(tryKeyLength(encrypted,key, commonChar));
        System.out.println("Key length is: " + key);
     //   System.out.println("\nWord in dictionary: "+ k);
        dectypted = vc.decrypt(encrypted);
        return dectypted;
    }

    public void breakVigenere () {
        System.out.println("Select dictionary...");
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> languages = new HashMap<>();
        for (File language : dr.selectedFiles()) {
            System.out.println("Read dictionary for "+ language.getName()+" language.");
            HashSet<String> dictionary = readDictionary(new FileResource(language));
            languages.put(language.getName(), dictionary);
        }
        System.out.println("Select crypted file");
        FileResource fr = new FileResource();
        System.out.println("Break for all language: \n"+breakForAllLanguages(fr.asString(),languages));

     /*   // for one dictionary
        HashSet<String> dictionary = readDictionary(new FileResource());
        FileResource fr = new FileResource();
        String message = fr.asString();
        // FileResource rawDictionary = new FileResource();
        System.out.println("\nBreak for Language:\n" + breakForLanguage(message, dictionary));*/

        // TEST
     /*   System.out.println("TEST");
        VigenereCipher vc = new VigenereCipher(tryKeyLength(message, 38, 'e'));
        System.out.println("Valid words with key 38: " + countWords(vc.decrypt(message), dictionary));*/
        //  VigenereCipher vigenereCipher = new VigenereCipher();
        //  System.out.println("Encrypted message:\n"+message);
     /*   int[] key = tryKeyLength(message, 4, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        System.out.println("Decrypt message with VigevereBreaker:\n");
        System.out.println(vc.decrypt(message));*/
    }
    
}
