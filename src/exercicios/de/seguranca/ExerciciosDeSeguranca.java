/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios.de.seguranca;
import exercicios.de.seguranca.Providers;
import exercicios.de.seguranca.SecurityUtils;
import exercicios.de.seguranca.Simetric;
import java.security.Key;
import java.util.Base64;
/**
 *
 * @author rodri
 */
public class ExerciciosDeSeguranca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String message = "Hello world"; 
        System.out.println("----Criptografia simetrica----");
        Key key1 = SimetricAESKeyGen();  
        Key key2 = SimetricBlowfishKeyGen();
        
        byte[] secret1 = SimetricSecret(message, key1, key2);
        
        System.out.println("----Decifragem----");
        byte[] plainTextToByte = SimetricDecryption(secret1, "keys/key2.key", "keys/key1.key");
        System.out.println(new String(plainTextToByte));
        System.out.println("\n");     
    }
    
    //gera um secret com Simetric com input e chave
    public static byte[] SimetricSecret(String input, Key key1, Key key2) throws Exception{
        System.out.println("Chave secreta 1: " + Base64.getEncoder().encodeToString(key1.getEncoded()));
        System.out.println("Chave secreta 2: " + Base64.getEncoder().encodeToString(key2.getEncoded()));
        
        byte[] secret = Simetric.encrypt(input.getBytes(), key1);
        byte[] secret2 = Simetric.encrypt(secret, key2);
        System.out.println("Segredo encriptado 2 vezes: " + Base64.getEncoder().encodeToString(secret2));  
        return secret2;
    }
    
    //gera uma chave AES
    public static Key SimetricAESKeyGen() throws Exception{        
        //gerar e guardar a key
        Key key = Simetric.generateAESKey(256);
        return key;
    }
    
    //gera uma chave Blowfish
    public static Key SimetricBlowfishKeyGen() throws Exception{        
        //gerar e guardar a key
        Key key = Simetric.generateBlowfishKey(256);
        return key;
    }
    
    //desencripta com Simetric
    public static byte[] SimetricDecryption(byte[] secret, String keyPath2, String keyPath1) throws Exception{
        Key key2 = Simetric.loadKey(keyPath2, "Blowfish");
        byte[] plainTextToByte = Simetric.decrypt(secret, key2);
        
        Key key1 = Simetric.loadKey(keyPath1, "AES");
        byte[] plainTextToByte2 = Simetric.decrypt(plainTextToByte, key1);
       
        return plainTextToByte2;
    } 
}
