/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directoris;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author super
 */
public class Directoris {

    public static void main(String[] args) {
        String cadenaRuta = "/home/super/Escriptori/";

        try {
            File directori = new File(cadenaRuta + "carpeta/");
            if (!directori.exists()) {
                directori.mkdir();
            }

            System.out.println("Ruta absoluta: " + directori.getAbsolutePath());
            System.out.println("Ruta canonica: " + directori.getCanonicalPath());
            System.out.println("Nom directori: " + directori.getName());
            System.out.println("Directori pare: " + directori.getParent());
            System.out.println("Ruta: " + directori.getPath());
            System.out.println("És fitxer?: " + directori.isFile());
            System.out.println("És directori: " + directori.isDirectory());
            System.out.println("Ocult: " + directori.isHidden());
            System.out.println("Absolut: " + directori.isAbsolute());
            System.out.println("Bytes: " + directori.length());
            System.out.println("Path Separador segons S.O.: " + File.pathSeparator);
            System.out.println("Separador segons S.O.: " + File.separator);

            //creem uns quants fitxers
            File fitxer1 = new File(directori.getAbsolutePath() + "/fitxer1.txt");
            fitxer1.createNewFile();
            File fitxer2 = new File(directori.getAbsolutePath() + "/fitxer2.txt");
            fitxer2.createNewFile();
            File fitxer3 = new File(directori.getAbsolutePath() + "/fitxer3.txt");
            fitxer3.createNewFile();

            fitxer3.renameTo(new File(directori.getAbsolutePath() + "/fitxer4.txt"));

            //Obtenim el nom dels fitxers del directori
            String[] fitxers = directori.list();
            //llistem els fitxers del directori
            for (String fitxer : fitxers) {
                System.out.println("Nom fitxer: " + fitxer.toString());
            }

            //Obtenim els fitxer
            File[] arrayFitxers = directori.listFiles();
            for (File fitxer : arrayFitxers) {
                System.out.println("Eliminant el fitxer: " + fitxer.getName());
                fitxer.delete();
            }

            if (!directori.delete()) {
                System.out.println("El directori no és buit");
            } else {
                System.out.println("Directori eliminat");
            }

        } catch (IOException ex) {
            ex.toString();
        }

    }
}
