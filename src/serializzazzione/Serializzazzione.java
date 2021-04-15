/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializzazzione;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meregalli.amos
 */
public class Serializzazzione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome="Andrea";
        String cognome="Del Monte";
        int reg=12;
        Studente s=new Studente(nome,cognome,reg);
        
        try {
            FileOutputStream fos=new FileOutputStream("test.ser");
            ObjectOutputStream os=new ObjectOutputStream(fos);
            os.writeObject(9);
            os.writeObject("Ciao");
            os.writeObject((float) 0.345);
            os.writeObject(true);
            os.writeObject('c');
            os.flush();
            os.close();
            fos.close();
            FileInputStream fis=new FileInputStream("test.ser");
            ObjectInputStream is=new ObjectInputStream(fis);
            int v1=(int) is.readObject();
            String v2=(String) is.readObject();
            float v3=(float) is.readObject();
            System.out.println("v1: "+v1);
            System.out.println("v2: "+v2);
            System.out.println("v3: "+v3);
        } catch (FileNotFoundException ex) {
            System.err.println("Impossibile trovare il file");
        } catch (IOException ioe) {
            System.err.println("Hai rotto java. Bravo ritardato");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializzazzione.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
}
