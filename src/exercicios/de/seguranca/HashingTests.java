/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.de.seguranca;
import exercicios.de.seguranca.Hash;
import java.util.Base64;
/**
 *
 * @author rodri
 */
public class HashingTests {
    public static void main(String[] args) throws Exception{
        String data = "Hello world";
        
        String algorithm = "SHA-256";
        
        byte[] hash = generateHash(data);
        Hash.saveHash(hash, "test");
               
        System.out.println("Test: " + verifyHash(data, algorithm));
    }
    
    public static byte[] generateHash(String data) throws Exception{
        return Hash.getHash(data.getBytes(), "SHA-256");
    }
    
    public static boolean verifyHash(String data, String algorithm)throws Exception{
        byte[] hash = Hash.loadHash("hashes/test.hash");
        return Hash.verifyHash(data.getBytes(), hash, algorithm);
    }
}
