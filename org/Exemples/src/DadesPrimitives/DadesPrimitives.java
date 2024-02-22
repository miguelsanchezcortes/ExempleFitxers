/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadesPrimitives;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author super
 */
public class DadesPrimitives {

    public static void main(String[] args) {
        FitxerAmbDadesPrimitives fadp = new FitxerAmbDadesPrimitives();
        fadp.escriu();
        fadp.llegir();
    }

}
// prova
class FitxerAmbDadesPrimitives {

    String rutaOrigen = "src/DadesPrimitives/persones.dat";
    String rutaDesti = "src/DadesPrimitives/persones.dat";

    void escriu() {
        //dades d'una persona
        String nom = "Pep";
        String cognom = "Rovira";
        int edat = 25;
        double saldo = 1523.45;
        double dni = 65844152;
        char lletraDni = 'X';

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaDesti));
            dos.writeUTF(nom);
            dos.writeUTF(cognom);
            dos.writeInt(edat);
            dos.writeDouble(saldo);
            dos.writeDouble(dni);
            dos.writeChar(lletraDni);

            System.out.println(dos.size() + " bytes");

            dos.flush();
            dos.close();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    void llegir() {

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(rutaDesti));
            
            //dades d'una persona
            String nom = dis.readUTF();
            String cognom = dis.readUTF() ;
            int edat = dis.readInt();
            double saldo = dis.readDouble();
            double dni = dis.readDouble();
            char lletraDni = dis.readChar();
            
            System.out.print("Nom: " + nom + " ");
            System.out.print("Cognom: " + cognom + " ");
            System.out.print("Edat: " + edat + " ");
            System.out.print("Saldo: " + saldo + " ");
            System.out.print("DNI: " + dni + " ");
            System.out.print("Lletra DNI: " + lletraDni + " ");

            //Quin problema tenim?
            
        } catch (IOException ex) {
            System.out.println(ex.toString());

        }
    }
}
