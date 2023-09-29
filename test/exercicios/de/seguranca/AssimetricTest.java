/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package exercicios.de.seguranca;

import java.security.KeyPair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rodri
 */
public class AssimetricTest {
    
    public AssimetricTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testDecryption() throws Exception{
        // TODO review the generated test code and remove the default call to fail.
        String msg = "Hello world";
        String expResult = "Hello world";
        
        KeyPair keyGen = Assimetric.generateKeyPair(1024);
        
        byte[] secret = Simetric.encrypt(msg.getBytes(), keyGen.getPublic());
        
        System.out.println("Encrypted -> " + new String(secret));
        
        byte[] tempResult = Simetric.decrypt(secret, keyGen.getPrivate());
        String result = new String(tempResult);
        
        assertEquals(expResult, result);
    }
    
}
