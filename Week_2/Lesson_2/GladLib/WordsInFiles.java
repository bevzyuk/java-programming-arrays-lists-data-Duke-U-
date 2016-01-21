package GladLib;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by oleksandr on 21.01.16.
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> myWords;

    public WordsInFiles() {
        myMap = new HashMap<>();
        }

    private void addWordsFromFiles(File file) {
        FileResource fileResourse = new FileResource(file);
        for (String word: fileResourse.words()) {
                if (!myMap.containsKey(word)) {
                    myWords = new ArrayList<>();
                    myWords.add(file.getName());
                    myMap.put(word, myWords);
                } else {
                    if (!myMap.get(word).contains(file.getName())) {
                        myMap.get(word).add(file.getName());
                    }
                }
        }
    }

    private void  buildWordFileMap() {
        DirectoryResource dr = new DirectoryResource();
        if (!myMap.isEmpty()) {
            myMap.clear();
        }
        for (File file : dr.selectedFiles()) {
            addWordsFromFiles(file);
        }
    }

    private int maxNumber() {
        int maxNumber = 0;
        for (String key : myMap.keySet()) {
            int currSize = myMap.get(key).size() ;
            if ( currSize> maxNumber) {
                maxNumber = currSize;
            }
        }
        return maxNumber;
    }

    private ArrayList<String> wordsInNymFiles(int number) {
        ArrayList<String> listFiles = new ArrayList<>();
        for (String key : myMap.keySet()) {
            if (myMap.get(key).size() == number) {
                listFiles.add(key);
            }
        }
        return listFiles;
    }

    private void printFilesIn(String word) {
        ArrayList<String> fileList = new ArrayList<>();
        if (myMap.containsKey(word)) {
            if (!fileList.contains(word)) {
                fileList = myMap.get(word);
            }
        }
        System.out.println("Word "+ word + " contain in next files: ");
        for (String file : fileList) {
            System.out.println(file);
        }
    }

    public void tester(){
        buildWordFileMap();
        int max = maxNumber();
    // max = 4;
        System.out.println("Max number of files:" + max);
        for (String word : wordsInNymFiles(max)) {
          //  System.out.println("Word in all files: " + word );
        }
        System.out.println("Word appears in each "+ max+" files: "+wordsInNymFiles(max).size());
        String key = "tree";
      printFilesIn(key);
    }

}
