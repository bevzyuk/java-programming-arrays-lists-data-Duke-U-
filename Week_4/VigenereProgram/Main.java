/**
 * Created by oleksandr on 31.01.16.
 */
public class Main {
    public static void main(String[] args) {
       /* FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher(5);
        System.out.println("Encrypted CaesarChipher message:\n");
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted  CaesarChipher message:\n");
        System.out.println(decrypted);

        // Test CaesarCracker
        CaesarCracker caesarCracker = new CaesarCracker('a');
        FileResource fr2 = new FileResource();
        String enctypted2 = fr2.asString();
        System.out.println("Encrypted CaesarCracker message:\n"+ enctypted2);
        System.out.println("Decrypted CaesarCracker message:\n"+ caesarCracker.decrypt(enctypted2));
*/
        // test Vigenere Cipher
     /*   FileResource fr3 = new FileResource();
        String message3 = fr3.asString();
        int[] key = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(key);
        String enc = vc.encrypt(message3);
        System.out.println("Encrypted VigenereCipher message:\n" + enc);
        String dec = vc.decrypt(enc);
        System.out.println("Decrypted VigenereCipher message:\n" + dec);
*/
        // test VidenereBreaker
        //test Slise method
        VigenereBreaker vb = new VigenereBreaker();
     //   vb.breakVigenere();

        // test mostCommonCharIn
       // vb.testMostCommonCharIn();

        vb.breakVigenere();


    }
}
