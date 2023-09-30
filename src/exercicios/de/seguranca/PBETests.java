/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicios.de.seguranca;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author rodri
 */
public class PBETests {
    public static void main(String[] args) throws Exception{
        String msg = "Hello world";
        String password = "test1234";
        
        byte[] encrypted = encrypt(msg, password);
        
        Files.write(Paths.get("pbeEncrypted/file2.pbe"), encrypted);
        System.out.println("Encrypted: " + new String(encrypted));
        
        byte[] decrypted = decrypt("pbeEncrypted/file2.pbe", password);
        System.out.println("Decrypted: " + new String(decrypted));
    }
    
    public static byte[] encrypt(String data, String password) throws Exception{
        return PasswordBasedEncryption.encrypt(data.getBytes(), password);
    }
    
    public static byte[] decrypt(String filePath, String password) throws Exception{
        byte[] file = Files.readAllBytes(Paths.get(filePath));
        return PasswordBasedEncryption.decrypt(file, password);
    }
}
