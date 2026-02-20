/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
       alphabet = new char[26];
       shifted = new char[26];
       shift = 0;
        
       String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < alphabet.length; i++)
        {
            alphabet[i] = alpha.charAt(i);
        }

        shifter(0);
    }

    public CaesarCipher(int num){
       alphabet = new char[26];
       shifted = new char[26];
       shift = num;  
        
       String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < alphabet.length; i++)
        {
            alphabet[i] = alpha.charAt(i);
        }

        shifter(num);
    }

    public String encrypt(String message){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String decrypted = message;
        String encrypted = "";
        
        boolean punctuation = false;

        for(int i = 0; i < decrypted.length(); i++)
        {
            if(alpha.indexOf(decrypted.substring(i,i+1)) < 0)
            {
                encrypted += decrypted.charAt(i);
            }
            else
            {
                for(int x = 0; x < alphabet.length; x++)
                {
                    if(decrypted.charAt(i) == alphabet[x])
                    {
                        encrypted += shifted[x];
                    }
                }
            }    
        }

        return "" + encrypted;
    }

    public String decrypt(String message){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String encrypted = message;
        String decrypted = "";

        boolean punctuation = false;

        for(int i = 0; i < encrypted.length(); i++)
        {
            if(alpha.indexOf(encrypted.substring(i,i+1)) < 0)
            {
                decrypted += encrypted.charAt(i);
            }
            else
            {
                for(int x = 0; x < shifted.length; x++)
                {
                    if(encrypted.charAt(i) == shifted[x])
                    {
                        decrypted += alphabet[x];
                    }
                }
            }    
        }

        return "" + decrypted;
    }

    public void shifter(int num){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        shift = num;

        for(int i = 0; i < shifted.length; i++)
        {
            int shiftedSpot = (i + num) % 26;
            shifted[i] = alpha.charAt(shiftedSpot);
        }
    }



}
