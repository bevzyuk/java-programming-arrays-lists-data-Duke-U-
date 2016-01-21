package GladLib;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.*;

public class GladLibMap {

    private ArrayList<String> usedList = new ArrayList<String>();
    private ArrayList<String> usedCategory = new ArrayList<>();
    private HashMap<String, ArrayList<String>> myMap;

    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap() {
        myMap = new HashMap<>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();

    }

    public GladLibMap(String source){
        myMap = new HashMap<>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
    String[] category = {"adjective","noun","color","country", "name","animal","timeframe","verb","fruit"};
        for (String cat : category) {
            ArrayList<String> list = readIt(source + "/" + cat + ".txt");
            myMap.put(cat, list);
        }

    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (myMap.containsKey(label)) {
            if (!usedCategory.contains(label)) {
                usedCategory.add(label);
            }
            return randomFrom(myMap.get(label));
        }
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
            return "**UNKNOWN**";

    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedList.contains(sub)){
            sub = getSubstitute(w.substring(first+1,last));
        }

        usedList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private int totalWordsConsidered() {
        int total = 0;
        for (String key : usedCategory) {
            total += myMap.get(key).size();
        }
        return total;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    private int totalWotdsInMap() {
        int totalWords = 0;
        for (String set : myMap.keySet()) {
            totalWords += myMap.get(set).size();
        }
                   return totalWords;
    }

    public void makeStory(){
        usedList.clear();
        usedCategory.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\nReplaced " + usedList.size() + " words");
        System.out.println("Total word in HashMap is "+totalWotdsInMap());

        System.out.println("Total words considered is " + totalWordsConsidered());
    }
    


}
