import edu.duke.*;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author oleksandr.bevzyuk 
 * @version 16012015
 */
public class TestCaesarCipher {

    
    /**
     * Method count each common letter 
     * at the input string and return int array
     * where each letter is a value of index
     *
     * @param st   input string for counting common char
     */
    public int[] countLetters(String encrypted) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] freqs = new int[alphabet.length()];
        for(int i=0; i<encrypted.length();i++){
            char ch = Character.toLowerCase(encrypted.charAt(i));
            int dex = alphabet.indexOf(Character.toUpperCase(ch));
            if(dex !=-1){
                freqs[dex] +=1;
            }
        }
       /* for(int i=0; i< freqs.length;i++){
            System.out.println(freqs[i]);
        }*/
        return freqs;
    }
    
    /**
     * Method find out index of max value in the int array
     * and return it
     *
     * @param  values   input int array
     * @return index of max value in the array
     */
    public int maxIndex(int[] values) {
        int index = values[0];
       for(int i=0; i< values.length;i++){
       //     System.out.println("index: " + i + " value "+ values[i]);
        if (values[index]<values[i]){
            index=i;
           }
        }
      //  System.out.println("Max index:  " + index);
        return index;
    }
    
    public String breakCaesarCipher(String input){
        CaesarCipher cc;
        int[] freqs = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }
    
    public void simpleTest(){
        int key = 15;
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
    //     FileResource fr = new FileResource();
      //  String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted message with key "+ key+ " is: "+ encrypted);
        //String decrypted = breakCaesarCipher(encrypted); //
        String decrypted =cc.decrypt(encrypted);
         System.out.println("Decrypted message with key "+ (26-key)+ " is: "+ decrypted);
    }
}
