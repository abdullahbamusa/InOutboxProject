/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inoutbox;

import inoutbox.Domain.Outbox;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah
 */
public class InOutbox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testSave();
    }
    private static void testSave()
    {
        try {
            Outbox box = new Outbox("14360100", "14360101", "Test from  java", "Abdullah");
            boolean success = box.save();
            System.out.println("Expected: true" + "Actual: " + success );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
