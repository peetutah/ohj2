package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/** Pääluokka ohjelmalle
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Tuloskortti {

    /**Parsii tekstirivin taulukkoon erotinmerkkien kohdalta, poistaa kaikki ylimääräiset whitespacet
     * @param jono mikä pätkitään
     * @return  palauttaa pätkityn merkkijonotaulukon
     */
    public String[] patki(String jono){
        String[] valmis = new String[4];
        String rivi = jono.strip();
        int a = 0;
        int b = 0;
        
        for (int i = 0; i <= valmis.length; i++){
            b = rivi.indexOf("|", a);
            if (b == -1) { valmis[i] = rivi.substring(a).strip(); break; }
            valmis[i] = rivi.substring(a, b).strip();
            a = b + 1;
        }
        return valmis;
    }
    
    
    /**
     * @param tiedosto tiedosto mitä luetaan.
     * @return palauttaa tiedoston kaksiulotteisessa String taulukossa muodossa => String[rivin nro][ rivin sisältö]
     */
    public String[][] tiedostoLuku(String tiedosto) {
      
        String rivi;
        String [][] tulos = new String[270][4];
        int i = 0;
        
        try (Scanner fi = new Scanner(new FileInputStream(new File(tiedosto)))){
            
            while(fi.hasNext()) { // TODO oikeat silmukat
                rivi = fi.nextLine();
                if (rivi.startsWith(";")) continue;
                tulos[i] = patki(rivi);
                i++;
                
                
            }
        } catch (IOException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
        return tulos;
    }
    
    
    /**metodi tallennusta varten
     * @param tiedosto tiedosto minne tallennetaan
     * @param tallennettava tallennettava olio merkkijonona
     */
    public void talletus(String tiedosto, String tallennettava) {
        try (PrintStream ulos = new PrintStream(new FileOutputStream(tiedosto, true))) {
            ulos.printf("\n" + tallennettava);
        }    catch (FileNotFoundException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
    }
    
    /** testis
     * @param args ei kay
     
    public static void main(String[] args) {
        Tuloskortti ok = new Tuloskortti();
        ok.tiedostoLuku("nimikoe.txt");
        ok.tiedostoLuku("parkoe.txt");
    }
    */
}
