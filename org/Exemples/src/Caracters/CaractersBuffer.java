/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author super
 */
public class CaractersBuffer {
    public static void main(String[] args) {
        FitxerCaractersBuffer fcb = new FitxerCaractersBuffer();
        fcb.llegir();
        // fcb.escriure();
        // fcb.afegirAlFinal();
    }
}

class FitxerCaractersBuffer {

    String ruta = "src/Caracters/fitxerCaracters.txt";

    public void llegir() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void escriure() {// sobre escriu el fitxer
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            String coses = "coses";
            // bw.write(coses);
            // bw.newLine();
            bw.write("Hola bon dia \n");
            bw.write("Hola bon dia \n");
            bw.write("Hola bon dia \n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public void afegirAlFinal() {
        try {
            String coses = "coses";
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
            // bw.write(coses);
            // bw.newLine();
            bw.write("Afegir al final \n");
            bw.write("Afegir al final \n");
            bw.write("Afegir al final \n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}