package org.example.cryptography;

import org.apache.commons.lang3.ArrayUtils;
import org.example.cryptography.KeyCreator.KeyAccess;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;


//TODO Refactor
public class AsymmCrypto {


    private Cipher cipher;

    public AsymmCrypto() {
        try {
            cipher = Cipher.getInstance(Configuration.RSA_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String encrypt( String input, String userName) throws Exception{
        String hashUserName = Hasher.hashSHA256(userName);
        PublicKey publicKey = KeyAccess.getPublicKey(hashUserName);
        String cipherText = null;
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        //encrypt
        byte[] enBytes = null;
        for (int i = 0; i < input.length(); i += 64) {  
          byte[] cipherBytes = cipher.doFinal(ArrayUtils.subarray(input.getBytes(), i,i + 64));  
          enBytes = ArrayUtils.addAll(enBytes, cipherBytes);  
        }
        cipherText = Base64.getEncoder().encodeToString(enBytes);

        return cipherText;
    }


    /**
     * decrypt(String, PrivateKey)
     */
    //todo
    public String decrypt( String cipherText, String hashUserName ) throws Exception{
      PrivateKey privateKey = KeyAccess.getPrivateKey(hashUserName);
      cipher.init(Cipher.DECRYPT_MODE, privateKey);
      
      byte[] byteArray = Base64.getDecoder().decode( cipherText.getBytes() ) ;
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < byteArray.length; i += 128) {
          byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(byteArray, i, i + 128));
          sb.append(new String(doFinal));
      }
      return sb.toString();
    }
}
