/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.de.seguranca;

import java.security.Key;
import java.security.KeyPair;

/**
 *
 * @author rodri
 */
public class AssimetricTets {
    public static void main(String[] args) throws Exception{
        // TODO review the generated test code and remove the default call to fail.
        String msg = "Hello world";
        String expResult = "Hello world";
        
        KeyPair keyPair = generateKeyPair(1024);
        saveKey(keyPair.getPublic(), "keys/key.pubkey");
        saveKey(keyPair.getPrivate(), "keys/key.privkey");
        
        byte[] secret = encrypt(msg);
        
        System.out.println("Encrypted -> " + new String(secret));
        
        byte[] tempResult = decrypt(secret);
        
        System.out.println(new String(tempResult));       
    }
    
    public static void saveKey(Key key, String filePath) throws Exception{
        Assimetric.saveKey(key, filePath);
    }
    
    public static KeyPair generateKeyPair(int keySize) throws Exception{
        return Assimetric.generateKeyPair(keySize);
    }
    
    public static byte[] encrypt(String data) throws Exception{
        Key publicKey = Assimetric.getPublicKey("keys/key.pubkey");
        byte[] secret = Simetric.encrypt(data.getBytes(), publicKey);
        return secret;
    }
    
    public static byte[] decrypt(byte[] secret) throws Exception{
        Key privateKey = Assimetric.getPrivateKey("keys/key.privkey");
        byte[] decryptedBytes = Simetric.decrypt(secret, privateKey);
        return decryptedBytes;
    }
    
    
}
