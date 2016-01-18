import edu.duke.*;
/**
 * class will use for decrypth Ceasar Chipher with one key
 * 
 * @author alexandr.bevzyuk@gmail.com 
 * @version 15.01.2016
 */
public class CaesarBreaker {

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
            System.out.println("index: " + i + " value "+ values[i]);
        if (values[index]<values[i]){
            index=i;
           }
        }
      //  System.out.println("Max index:  " + index);
        return index;
    }
    
    /**
     * Main method that decrypt message
     *
     * @param  encrypted is a decrypted message
     * @return  String  encrypted string
     */
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }

    /**
     * Devide input message to half part
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i=start; i< message.length(); i+=2){
            
                sb.append(message.charAt(i));
              //  System.out.println(sb.toString());
            
        }
        return sb.toString();
    }

    /**
     * Method find out most common letter in the string
     *
     * @param  s   Input string
     * @return     return the index of letter from alphabet
     */
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex  - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
       // System.out.println("dkey: "+ dkey);*/
        return dkey;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String st = halfOfString(encrypted, 0);
        System.out.println(encrypted);
        System.out.println("St 0: " + st);
        
        int key1 = getKey(st);
        st = halfOfString(encrypted, 1);
        System.out.println("St 1: " + st);
        int key2 = getKey(st);
        System.out.println("Key1; "+ key1 + " key2; "+ key2);
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }

    /**
     * Method for testing dectypting
     *
     */
    public void testDecrypt() {
     /*   String encrypted = "WIVV TRBV ZE KYV TFEWVIVETV IFFD!";
        System.out.println("Encrypted massage: " + encrypted);
        String decr = decrypt(encrypted);
        System.out.println("Decrypted massage: " + decr);
         
        System.out.println(halfOfString("Qbkm Zgis", 1));
      */  
      /*  System.out.println("Decrypted with two key ");*/
      // String encrypted = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
       //String encrypted = "Top ncmy qkff vi vguv vbg ycpx"; 
      // System.out.println(decryptTwoKeys(encrypted));
        
        FileResource fr = new FileResource();
        String message = fr.asString();
         System.out.println(decryptTwoKeys(message));
    }

}
