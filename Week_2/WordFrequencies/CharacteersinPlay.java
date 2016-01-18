import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharacteersinPlay here.
 * 
 * @author Oleksandr.bevzyuk@gmail.com
 * @version 17.01.2016
 */
public class CharacteersinPlay {
    private ArrayList<String> myPerson = new ArrayList<String>();
    private ArrayList<Integer> myPersonCount = new ArrayList<Integer>();
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private void update(String person) {
        person = person.toLowerCase().trim();
        //person = person.toLowerCase();
        int index = myPerson.indexOf(person);
        if(index == -1){
            myPerson.add(person);
            myPersonCount.add(1);
        }else{
            int idx = myPersonCount.get(index);
            myPersonCount.set(index, idx+1);
        }
    }

    /**
     * Method find out all Character at the text
     * 
     */
    public void findAllCharacters() {
        myPerson.clear();
        myPersonCount.clear();
        FileResource resource = new FileResource();
        for(String s : resource.lines()){
            int index = s.indexOf(".");
         
            if(index !=-1){
            String subst = s.substring(0, index);
            update(subst);
           // System.out.println(subst);
            }
        }
    }

    /**
     * Method print out Character that apears in the text
     * with between specific times
     *
     * @param num1   min  time apears(include)
     * @param num2 max time apears(include)
     */
    private void charactersWithNumParts(int num1, int num2) {
        // Check if num1 less ur equals than num2
        if(num1<=num2){
            // Loop all Person in the ArrayList
            for(int i = 0; i< myPerson.size(); i++){
                // Get count of Person apears
                int count = myPersonCount.get(i);
                // Check if count greater or equal than num1 OR less or equal than num2
                if(count>=num1 & count <= num2){
                    // Print out this Person and apears time
                    System.out.println("Person:\t " + myPerson.get(i).toUpperCase() +
                    " apears " + myPersonCount.get(i) + " times");
                }
            }
        }else{
            // Print out if num2 less than num2
            System.out.println("num2 less than num1");
        }
    }

    /**
     * Method print all Person and it apears time in the text
     *
     */
    private void printCharacters() {
        for(int i=0;i<myPerson.size();i++){
            // Loop all person at the arrayList Person
            // and print how many time it apears at the text
            System.out.println("Main character: " + myPerson.get(i) + " has " + myPersonCount.get(i) + " speaking parts");
            
        }
    }

    /**
     * Test method for the class
     * 
     */
    public void tester() {
        int num1 = 10;
        int num2 = 15;
        findAllCharacters();
            
        System.out.println("Character between " + num1 + " and " + num2);
    
        charactersWithNumParts(num1, num2);
        //printCharacters();
        
    }

}
