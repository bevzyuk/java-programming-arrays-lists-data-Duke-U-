
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    
    public void countWordLengths(FileResource resource, int[] counts) {
        int countWord=0;
        for(String s: resource.words()){
            countWord++;
       //     System.out.println("Word: " + s + " length " + s.length());
            int length = s.length();
          if(length != 1 && Character.isLetter(s.charAt(0))){  
            if(!Character.isLetter(s.charAt(0))){
                length -=1;
            }
            if(!Character.isLetter((s.charAt(s.length()-1)))){
                length -=1;
            }
            counts[length]+=1;}
        }
        System.out.println("Загальна кількість слів: "+ countWord);
       /* for(int i= 0 ; i< counts.length; i++){
            System.out.println("Index " + i + " length: "+ counts[i]);
           
        }*/
    }    
        
    
    public int indexOfMax(int[] values) {
       int index = values[0];
       for(int i=0; i< values.length;i++){
        if (values[index]<values[i]){
            index=i;
        }
        }
        return index;
    }

    public void testCountWordLengths() {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        System.out.println("Max index: " + indexOfMax(counts));
    }



}
