import edu.duke.*;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        shiftedAlphabet = alphabet.substring(mainKey)+
        alphabet.substring(0,mainKey);
    }
    
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
              
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            int idx;
            char newChar;
            //Look at the ith character of encrypted (call it currChar)
         
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)){
               idx = alphabet.indexOf(Character.toUpperCase(currChar)); 
            }else{
            //Find the index of currChar in the alphabet (call it idx)
             idx = alphabet.indexOf(currChar);}
            //If currChar is in the alphabet
            if(idx != -1){
                if(Character.isLowerCase(currChar)){
               newChar = Character.toLowerCase(shiftedAlphabet.charAt(idx));
            }else{
            //Find the index of currChar in the alphabet (call it idx)
            newChar = shiftedAlphabet.charAt(idx); }
                //Get the idxth character of shiftedAlphabet (newChar)
                
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
       StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabetKey1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);

        String shiftedAlphabetKey2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
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
                        newChar = Character.toLowerCase(shiftedAlphabetKey1.charAt(idx));
                    }else{
                       newChar = Character.toLowerCase(shiftedAlphabetKey2.charAt(idx));
                    }
                      
            //Find the index of currChar in the alphabet (call it idx)
             }else{
                newChar = encrypted.charAt(i);
                }
                //Get the idxth character of shiftedAlphabet (newChar)
                
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted);
        System.out.println(decrypted);
    }
        
    public void testCaesarLowUpper() {
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!"));
    }
    
     public void testCaesarTwoKey() {
         String ste ="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
         String st = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8, 21);
         System.out.println(st);
        
    }

}

