/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objectes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author super
 */
public class Objectes {

    public static void main(String[] args) {

        Adreca adreca1 = new Adreca("Vic", "Nou", 20);
        Adreca adreca2 = new Adreca("Manlleu", "Riu", 5);
        Adreca adreca3 = new Adreca("Torelló", "Avda Roma", 13);

        Persona persona1 = new Persona("Joan", "Foix", 25, adreca1);
        Persona persona2 = new Persona("Miquel", "Climent", 24, adreca2);
        Persona persona3 = new Persona("Mari", "Garcia", 21, adreca3);

        Persona[] persones = new Persona[3];
        
        persones[0]=persona1;
        persones[1]=persona2;
        persones[2]=persona3;

        FitxerAmbObjectes fao = new FitxerAmbObjectes();
        fao.escriu(persones);
        System.out.println("");
        fao.llegir();

    }
}

class FitxerAmbObjectes { 

    String rutaOrigen = "src/Objectes/persones.dat";
    String rutaDesti = "src/Objectes/persones.dat";

    void escriu(Persona[] persones) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaDesti));

            //Escriurem objecte a objecte (persona) al fitxer.
            for (Persona persona : persones) {
                oos.writeObject(persona);
                oos.flush();
                System.out.println("Escriure: " + persona.toString());
            }
            //posem al final una marca per saber que ja no hi han més objectes del tipus persona
            oos.writeObject(null);

//            Millor opció: escriurem directament una colecció de persones, en lloc de un en un
//            així els podrem recuperar tots al mateix temps i no de un en un.
//            oos.writeObject(persones);
            oos.flush();
            oos.close();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    void llegir() {
        Persona[] persones = new Persona[3];
        Persona persona = new Persona();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaOrigen));

            //Llegir persona a persona
            persona = (Persona) ois.readObject();
            while (persona != null) { // aques null l'hem posat nosaltres al final quant hem escrit el fitxer
                System.out.println("Llegir: " + persona.toString());
                persona = (Persona) ois.readObject();
            }

            //Llegim un objecte que és una colecció, per tant llegim tots els objectes al mateix temps.
            //Millor opció perquè a cada fitxer tindrem només un tipus d'objecte.
//            persones = (ArrayList<Persona>) ois.readObject();
//            for (Persona persona : persones) {
//                System.out.println("Llegir: " + persona.toString());
//            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}

class Persona implements Serializable {

    private String nom;
    private String cognom;
    private int edat;
    private transient int campCalculat; //camp que es calcula quant es crea la persona
    private Adreca adreca; //també podria ser un "ArrayList<Adreca> adreces"
    
    //Un altre exemple d'ús de transcient: imagina que tenim una classe imatge que té
    //un atribut imatge, i un atribut miniatura. La miniatura es crea amb un mètode i per 
    //tant no cal guardar a un fitxer la miniatura, sinó que s'ha de calcular en recuperar
    //l'objecte imatge cridant per exemple a un mètode.

    public Persona() {

    }

    public Persona(String nom, String cognom, int edat, Adreca adreca) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.adreca = adreca;
        this.campCalculat = edat + 1;
    }

    @Override
    public String toString() {
        return ("Nom: " + nom + " Cognom: " + cognom + " Edat: " + edat + " "
                + adreca.toString() + " Camp calculat: " + campCalculat);
    }

}

class Adreca implements Serializable {

    private String poblacio;
    private String carrer;
    private int numero;

    public Adreca(String poblacio, String carrer, int numero) {
        this.poblacio = poblacio;
        this.carrer = carrer;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return ("Poblacio: " + poblacio + " Carrer: " + carrer + " Numero: " + numero);
    }
}
