/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binari;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author super
 */
public class BinariBuffer {

    public static void main(String[] args) {
        FitxerBinariBuffered fbb = new FitxerBinariBuffered();
        fbb.llegir();
        int[] fitxerLlegit = fbb.llegirIGuardarEnArray();
        fbb.escriure(fitxerLlegit);
        //fbb.afegirAlFinal();
        //fbb.llegirAmbScanner();
    }
}

class FitxerBinariBuffered {

    String rutaOrigen = "src/Binari/silbato_1.mp3";
    String rutaDesti = "src/Binari/silbato_2.mp3";

    void llegir() {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(rutaOrigen));
            int byteLlegit = 0;
            while ((byteLlegit = bis.read()) != -1) {
                System.out.print(byteLlegit);
            }
            System.out.println("");

            bis.close();
        } catch (IOException ex) {
        }
    }

    int[] llegirIGuardarEnArray() { //llegeix un fitxer binari byte a byte i el guarda a un array, retorna el array

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(rutaOrigen));
            int[] fitxerLlegit = new int[bis.available()];
            int byteLlegit = 0;
            int comptador = 0;
            while ((byteLlegit = bis.read()) != -1) {
                System.out.println(byteLlegit);
                fitxerLlegit[comptador] = byteLlegit;
                comptador++;
            }
            System.out.println("");
            System.out.println("Comptador: " + comptador);

            bis.close();
            return fitxerLlegit;
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    void escriure(int[] fitxerLlegit) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(rutaDesti));

            for (int i = 0; i < fitxerLlegit.length; i++) {
                bos.write(fitxerLlegit[i]);
            }

            bos.write('\n');
            bos.flush();
            bos.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    void afegirAlFinal() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(rutaDesti, true));
            String cadena = "Afegir al final ppppppp";

            for (int i = 0; i < cadena.length(); i++) {
                bos.write(cadena.charAt(i));
            }

            bos.write('\n');
            bos.flush();
            bos.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    void llegirAmbScanner() {

        try {
            Scanner sc = new Scanner(new File(rutaOrigen));
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

}
