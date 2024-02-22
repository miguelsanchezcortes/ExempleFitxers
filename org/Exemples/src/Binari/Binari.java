/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binari;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author super
 */
public class Binari {

    public static void main(String[] args) {
        FitxerBinari fb = new FitxerBinari();
        fb.llegir();
        int[] fitxerLlegit = fb.llegirIGuardarEnArray();
        fb.escriure(fitxerLlegit);
        //fb.afegirAlFinal();
    }
}

class FitxerBinari {

    String rutaOrigen = "src/Binari/silbato_1.mp3";
    String rutaDesti = "src/Binari/silbato_2.mp3";

    void llegir() { //llegeix un fitxer binari byte a byte

        try {
            FileInputStream fis = new FileInputStream(rutaOrigen);
            //FileInputStream fis = new FileInputStream(new File(rutaOrigen));
            int byteLlegit = 0;
            while ((byteLlegit = fis.read()) != -1) {
                System.out.print(byteLlegit);
            }
            System.out.println("");

            fis.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    int[] llegirIGuardarEnArray() { //llegeix un fitxer binari byte a byte i el guarda a un array, retorna el array

        try {
            FileInputStream fis = new FileInputStream(rutaOrigen);
            int[] fitxerLlegit = new int[fis.available()];
            int byteLlegit = 0;
            int comptador = 0;
            while ((byteLlegit = fis.read()) != -1) {
                System.out.println(byteLlegit);
                fitxerLlegit[comptador] = byteLlegit;
                comptador++;
            }
            System.out.println("");
            System.out.println("Comptador: " +comptador);

            fis.close();
            return fitxerLlegit;
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    void escriure(int[] fitxerLlegit) {//escriu en un fitxer binari byte a byte
        try {
            FileOutputStream fos = new FileOutputStream(rutaDesti);
          

            for(int i=0; i<fitxerLlegit.length;i++){
                fos.write(fitxerLlegit[i]);
            }

            fos.write('\n');
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    void afegirAlFinal() {//escriu en un fitxer binari byte a byte
        try {
            FileOutputStream fos = new FileOutputStream(rutaDesti, true);
            String cadena = "afegir al final";

            for (int i = 0; i < cadena.length(); i++) {
                fos.write(cadena.charAt(i));
            }
            fos.write('\n');
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
