/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracters;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author super
 */
public class Caracters {

    public static void main(String[] args) {
        FitxerCaracters fc = new FitxerCaracters();
        fc.llegir();
//        fc.escriure();
//        fc.llegir();
//        fc.afegeixAlFinal();
//        fc.llegir();
    }
}

class FitxerCaracters {

    String ruta = "src/Caracters/fitxerCaracters.txt";

    public void llegir() {//llegeix un fitxer de text caràcter a caràcter (un caràcter és un byte)
        try {

            FileReader fr = new FileReader(ruta);
            int caracter = 0;
            while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
            }
            fr.close();
            System.out.println("");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void escriure() {//escriu en un fitxer de text caràcter a caràcter (un caràcter és un byte)
        try {

            FileWriter fw = new FileWriter(ruta);
            String cadena = "Una altra frase";
            for (int i = 0; i < cadena.length(); i++) {
                fw.write(cadena.charAt(i));
            }
//            for (char c='A';c<='Z';c++){
//                fw.write(c);
//            }
            fw.write('\n');
            fw.flush();
            fw.close();
            System.out.println("");

        } catch (IOException ex) {
            System.out.print(ex.toString());
        }
    }

    public void afegeixAlFinal() {//afegeix a un fitxer de text caràcter a caràcter (un caràcter és un byte)
        try {

            FileWriter fw = new FileWriter(ruta,true);
            String cadena = "Afegit al final";
            for (int i = 0; i < cadena.length(); i++) {
                fw.write(cadena.charAt(i));
            }
            fw.write("\n");
            fw.flush();
            fw.close();
            System.out.println("");

        } catch (IOException ex) {
            System.out.print(ex.toString());
        }
    }
}
