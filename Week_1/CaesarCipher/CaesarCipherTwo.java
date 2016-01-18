
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo(int _key1, int _key2){
        key1 = _key1;
        key2 = _key2;
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        shiftedAlphabet1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);

        shiftedAlphabet2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public String decrypt(String input) {
        
        return new CaesarCipherTwo(26-key1, 26-key2).encryptTwoKeys(input);
    }

    public String encryptTwoKeys(String input) {
       StringBuilder encrypted = new StringBuilder(input);
        
        for(int i = 0; i < encrypted.length(); i++) {
            int idx;
            char newChar= (char) 0;
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            idx = alphabet.indexOf(Character.toUpperCase(currChar)); 
            //If currChar is in the alphabet
            
            if(idx != -1 ){
             //  char newChar;
                    if(i%2==0){
                        newChar = Character.toLowerCase(shiftedAlphabet1.charAt(idx));
                    }else{
                       newChar = Character.toLowerCase(shiftedAlphabet2.charAt(idx));
                    }
                      
            //Find the index of currChar in the alphabet (call it idx)
             }else{
                newChar = encrypted.charAt(i);
                }
                //Get the idxth character of shiftedAlphabet (newChar)
             if(Character.isUpperCase(currChar)) {
                 encrypted.setCharAt(i, Character.toUpperCase(newChar));
                }else{
                encrypted.setCharAt(i, newChar);
                }  
                //Replace the ith character of encrypted with newChar
                
            }
            //Otherwise: do nothing
        
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
}
