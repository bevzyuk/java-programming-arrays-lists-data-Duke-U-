
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {

    
    public void countWordLengths(FileResource resource, int[] counts) {
        for(String s: resource.words()){
            
            int length = s.length();
            if(!Character.isLetter(s.charAt(0))){
                length -=1;
            }
            if(!Character.isLetter((s.charAt(s.length()-1)))){
                length -=1;
            }
            counts[length]+=1;
        }
        int i=0;
        for(int j : counts){
            System.out.println("Index " + i + " length: "+ j);
            i++;
        }
    }    
        
        public void testCountWordLengths() {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
    }



}
