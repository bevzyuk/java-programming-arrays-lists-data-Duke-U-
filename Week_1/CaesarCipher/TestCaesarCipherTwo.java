import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    
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
        int dkey1=0; int dkey2=0;
        for(int i=0; i<2;i++){
          String st = halfOfString(input, i);
      //  System.out.println(input);
      //  System.out.println("St 0: " + st);
        int[] freqs = countLetters(st);
        int maxDex = maxIndex(freqs);  
        int dkey = maxDex-4;
        if(maxDex<4){
            dkey = 26 - (4-maxDex);
        }
        if(i%2==0){
            dkey1 = dkey;
        }else{dkey2 = dkey;}
        }
              
        System.out.println("Key1; "+ dkey1 + " key2; "+ dkey2);
        return new CaesarCipherTwo(dkey1,dkey2).decrypt(input);
    }
    
    public void simpleTest(){
        int key1 = 14;
        int key2 = 24;
        FileResource fr = new FileResource();
        String message = fr.asString();
      // String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
      //  CaesarCipherTwo ct = new CaesarCipherTwo(key1, key2);
      //  String encryptedTwo = ct.encryptTwoKeys(message);
      //  System.out.println("Encrypted message with two keys: " + encryptedTwo);
      //  String decryptedTwo = ct.decrypt(message);
      //  String decryptedTwo = ct.decrypt(encryptedTwo);
      //  System.out.println("Decrypted message with two keys: " + decryptedTwo);
       
      String  decryptedTwo = breakCaesarCipher(message);
      //   System.out.println("Encrypted message with two keys: " + encryptedTwo);
         System.out.println("Decrypted message with two keys in auto mode: \n" + decryptedTwo);
    }

}
