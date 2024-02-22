/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alternatives;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class Alternatives {

    //Font d'informació dels exemples
    //https://www.delftstack.com/es/howto/java/read-file-in-java/
    public static void main(String[] args) {

        String ruta = "src/Alternatives/dades.txt";

        //EXEMPLE 1
        //Lectura de dades amb Scanner 
        System.out.println("Exemple 1");
        File fitxer1 = new File(ruta);
        Scanner lector1;
        try {
            lector1 = new Scanner(fitxer1);
            while (lector1.hasNextLine()) {
                System.out.println(lector1.nextLine());
            }
            lector1.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fitxer no trobat");
        }

        //EXEMPLE 2
        //Lectura de fitxer1 amb Scanner però li passem un Stream
        System.out.println("\nExemple 2");
        InputStream fis;
        try {
            fis = new FileInputStream(ruta);
            Scanner lector2 = new Scanner(fis);
            while (lector2.hasNextLine()) {
                System.out.println(lector2.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fitxer no trobat");
        }

        //EXEMPLE 3
        /**
         * BufferedReader lee el texto de un flujo de entrada basado en
         * caracteres. El almacenamiento en búfer se realiza para la lectura
         * eficiente de matrices, líneas y caracteres. Si no se especifica el
         * tamaño del búfer, se usa el tamaño predeterminado, que es lo
         * suficientemente grande para el uso. Podemos usarlo para leer archivos
         * en Java.
         *
         * BufferedReader proporciona una lectura rápida mediante el
         * almacenamiento en búfer de datos.
         *
         */
        System.out.println("\nExemple 3");
        File fitxer2 = new File(ruta);

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fitxer2));
            String cadena;
            while ((cadena = br.readLine()) != null) {
                System.out.println(cadena);
            }
        } catch (FileNotFoundException ex) {//aquest catch és pel FileReader (línea 75)
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {//aquest catch és pel br.readLine (línea 77)
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }

        //EXEMPLE 4
        /**
         * La clase FileReader ofrece una forma conveniente de leer texto sin
         * formato en Java. En esta clase, el método constructor toma el tamaño
         * de búfer de bytes predeterminado y la codificación de caracteres
         * predeterminada como más apropiado.
         */
        System.out.println("\nExemple 4");
        File fitxer3 = new File(ruta);
        try {
            //La función createNewFile() crea un nuevo archivo vacío. Después de la
            //llamada a la función, si el archivo no existe, devolverá True y creará
            //un archivo vacío con un nombre especificado.
            fitxer3.createNewFile();
            FileReader fr = new FileReader(fitxer3);
            char[] arrayDeChar = new char[100];
            fr.read(arrayDeChar);
            for (char element : arrayDeChar) {
                System.out.print(element);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }

        //RESUM
        //************
        //0RIENTAT A CARÀCTER  
        //************
        //SENSE BUFFER
        try {
            File f1 = new File(ruta);
            FileReader fr1 = new FileReader(f1);
            int caracter1 = fr1.read();
            while (caracter1 != -1) {
                System.out.print((char) caracter1);
                caracter1 = fr1.read();
            }
            fr1.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AMB BUFFER
        try {
            File f2 = new File(ruta);
            FileReader fr2;
            fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);
            String linea = br2.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br2.readLine();
            }
            br2.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }

        //************
        //0RIENTAT A BYTE  
        //************
        //SENSE BUFFER
        try {
            File f3 = new File(ruta);
            FileInputStream fis3;
            fis3 = new FileInputStream(f3);
            int byteLlegit3 = fis3.read();
            while (byteLlegit3 != -1) {
                System.out.print(byteLlegit3);
                byteLlegit3 = fis3.read();
            }
            fis3.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AMB BUFFER

        try {
            File f4 = new File(ruta);
            FileReader fr4 = new FileReader(f4);
            FileInputStream fis4 = new FileInputStream(f4);
            BufferedInputStream bis4 = new BufferedInputStream(fis4);
            int byteLlegit4 = bis4.read();
            while (byteLlegit4 != -1) {
                System.out.println(byteLlegit4);
                byteLlegit4 = bis4.read();
            }
            bis4.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alternatives.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
