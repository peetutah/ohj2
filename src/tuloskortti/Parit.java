package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * luokka partietojen hallinnoimiseen, vastaa tiedoston luvusta ja kirjoittamisesta sekä uusien parien lisäämisestä sekä poistamisesta
 * tahvpwzw@jyu.student.fi
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Parit implements Iterable<Par>{
    
    private String tiedosto;
    private final Collection<Par> alkiot = new ArrayList<Par>();
    
    private boolean muutoksia = false; // tallennustarpeen tarkistusta varten
    
    /**
     * tyhjä muodostaja
     */
    public Parit() {  }
    
        
    /** 
     * muodostaja joka asettaa tiedoston
     * @param tiedosto mitä luetaan
     */
    public Parit(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    
    @Override
    public Iterator<Par> iterator() {
        return alkiot.iterator();
    }
    
    
    /**
     * lisää uuden parin tietorakenteeseen
     * @param p Par joka lisätään
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit lisaKoe = new Parit();
     * Par juu = new Par (3,3,3);
     * Par ei = new Par (3,3,4);
     * lisaKoe.getMuutoksia() === false;
     * lisaKoe.lisaa(juu);
     * lisaKoe.getAlkiot().contains(juu) === true;
     * lisaKoe.getAlkiot().contains(ei) === false;
     * lisaKoe.lisaa(ei);
     * lisaKoe.getAlkiot().contains(juu) === true;
     * lisaKoe.getAlkiot().contains(ei) === true;
     * lisaKoe.getMuutoksia() === true;
     * </pre>
     */
    public void lisaa(Par p) {
        alkiot.add(p);
        muutoksia = true;
    }
    
    
    /** 
     * palauttaa Parien lukumäärän
     * @return Parien lukumäärä
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe2 = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * koe2.lisaa(b);
     * koe2.lisaa(e);
     * koe2.getlkm() === 2;
     * koe2.lisaa(c);
     * koe2.lisaa(d);
     * koe2.lisaa(a);
     * koe2.lisaa(f);
     * koe2.getlkm() === 6;
     * </pre>
     */
    public int getlkm() {
        return alkiot.size();
    }
        
    
    /** 
     * getteri tiedostonimelle
     * @return palauttaa tiedostonimen, jos tiedostonimeä ei ole asetettu palauttaa null
     * @example
     * <pre name="test">
     * Parit tKoe = new Parit("testitiedosto");
     * tKoe.getTdNimi() === "testitiedosto.dat";
     * Parit tyhjKoe = new Parit("");
     * tyhjKoe.getTdNimi() === ".dat";
     * Parit oletus = new Parit();
     * oletus.getTdNimi() === null;
     * </pre>
     */
    public String getTdNimi() {
        if (this.tiedosto == null) return null;
        return this.tiedosto + ".dat";
    }
    
    
    /** 
     * getteri varatiedostonimelle
     * @return palauttaa varatiedostonimen, jos tiedostonimeä ei ole asetettu palauttaa null
     * @example
     * <pre name="test">
     * Parit tKoe = new Parit("testitiedosto");
     * tKoe.getBkNimi() === "testitiedosto.bak";
     * Parit tyhjKoe = new Parit("");
     * tyhjKoe.getBkNimi() === ".bak";
     * Parit oletus = new Parit();
     * oletus.getBkNimi() === null;
     * </pre>
     */
    public String getBkNimi() {
        if (this.tiedosto == null) return null;
        return this.tiedosto + ".bak";
    }

    
    /** getteri muutoksille
     * @return true jos on, false jos ei ole muutoksia
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit mKoe = new Parit();
     * Par uusi = new Par (3,3,3);
     * mKoe.getMuutoksia() === false;
     * mKoe.lisaa(uusi);
     * mKoe.getMuutoksia() === true;
     * Parit mKoe2 = new Parit();
     * mKoe2.getMuutoksia() === false;
     * mKoe2.getTdNimi();
     * mKoe2.getAlkiot();
     * mKoe2.getlkm();
     * mKoe2.getMuutoksia() === false;
     * </pre>
     */
    public boolean getMuutoksia(){
        return this.muutoksia;
    }
    
    
    
    /**
     * ilmoittaa uusista muutoksista
     */
    public void setMuutoksia() {
       this.muutoksia = true;
    }
    
    
    /** Hakee annetusta Par-taulukosta vain väylien parit jos rataa ei ole palauttaa null
     * @param id on rataId jonka perusteella haetaan
     * @return palauttaa väylien par-luvut taulukossa ja oikeassa järjestyksessä: väylä 1 => 0 | 2 => 1...
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe2 = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * Par g = new Par(10, 1, 1);
     * Par h = new Par(10, 2, 2);
     * koe2.lisaa(b);
     * koe2.lisaa(e);
     * koe2.lisaa(c);
     * koe2.lisaa(d);
     * koe2.lisaa(a);
     * koe2.lisaa(f);
     * koe2.lisaa(h);
     * koe2.lisaa(g);
     * int[] koeLuku = new int[18];
     * koeLuku = koe2.getRadanParluvut(9);
     * Arrays.toString(koeLuku) === "[1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
     * </pre>     
     */
    public int[] getRadanParluvut(int id) {
        int[] rata = new int[18];
        List<Par> apuPar = getRadanPar(id);
        if (apuPar.size() <= 0) return null; 
        for (Par parluku : apuPar) {
            rata[parluku.getVayla()-1] = parluku.getPar();
        }
        return rata;
    }
    
    
    /** haetaan kaikki yhteen rataan liittyvät parit Par-listaan
     * @param id on rataId jonka perusteella haetaan
     * @return palauttaa parit listassa
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * Par g = new Par(10, 1, 1);
     * Par h = new Par(10, 2, 2);
     * koe.lisaa(b);
     * koe.lisaa(e);
     * koe.lisaa(c);
     * koe.lisaa(d);
     * koe.lisaa(a);
     * koe.lisaa(f);
     * koe.lisaa(h);
     * koe.lisaa(g);
     * List<Par> koeRata = koe.getRadanPar(9);
     * List<Par> koeRata2 = koe.getRadanPar(10);
     * Parit koe2 = new Parit();
     * koe2.lisaa(b);
     * koe2.lisaa(e);
     * koe2.lisaa(c);
     * koe2.lisaa(d);
     * koe2.lisaa(a);
     * koe2.lisaa(f);
     * koeRata.containsAll(koe2.getAlkiot()) === true;
     * Parit koe3 = new Parit();
     * koe3.lisaa(h);
     * koe3.lisaa(g);
     * koeRata2.containsAll(koe3.getAlkiot()) === true;
     * </pre>     
     */
    public List<Par> getRadanPar(int id) {
        List<Par> rata = new ArrayList<Par>();
        for (Par p : alkiot) {
            if(p.getRataId() == id) rata.add(p);
        }
        return rata;
    }
    
    
    /**
     *  lukee tiedoston ja lisää sen tiedot ohjelman käyttöön
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * #import java.util.*;
     * 
     * VertaaTiedosto.tuhoaTiedosto("pKoe.dat");
     * 
     * VertaaTiedosto.kirjoitaTiedosto("pKoe.dat",
     *      "; Kenttien järjestys tiedostossa on seuraava:\n;rataId | väylä | par"+
     *      "\n1|1|3" +
     *      "\n1|2|3" +
     *      "\n1|3|3" +
     *      "\n1|4|3" +
     *      "\n1|5|3" +
     *      "\n1|6|3" +
     *      "\n1|7|3" +
     *      "\n1|8|3" +
     *      "\n1|9|3" +
     *      "\n1|10|3" +
     *      "\n1|11|3" +
     *      "\n1|12|3" +
     *      "\n1|13|3" +
     *      "\n1|14|3" +
     *      "\n1|15|3" +
     *      "\n1|16|3" +
     *      "\n1|17|3" +
     *      "\n1|18|3");
     *  
     * Parit lukuKoe = new Parit("pKoe");
     * lukuKoe.getMuutoksia() === false;
     * lukuKoe.getlkm() === 0;
     * lukuKoe.lueTiedosto();
     * lukuKoe.getlkm() === 18;
     * lukuKoe.getMuutoksia() === true;
     * int[] tParit = new int[18];
     * tParit = lukuKoe.getRadanParluvut(1);
     * Arrays.toString(tParit) === "[3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]";
     * 
     * VertaaTiedosto.tuhoaTiedosto("pKoe.dat");
     * VertaaTiedosto.tuhoaTiedosto("pKoe.bak");
     * </pre>
     */
    public void lueTiedosto() {
        
        String rivi;
        try (Scanner fi = new Scanner(new FileInputStream(new File(getTdNimi())))){
            
            while(fi.hasNext()) {
                rivi = fi.nextLine();
                if (rivi.startsWith(";")) continue;
                
                Par par = new Par();
                par.parse(rivi);
                lisaa(par);
                
            }
        } catch (IOException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
    }

    
    /** 
     * tallennusmetodi pareille, tallentaa tiedot jos muutoksia tullut
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * 
     * VertaaTiedosto.tuhoaTiedosto("pKoe.dat");
     * 
     * String tulos =
     *      "; Kenttien järjestys tiedostossa on seuraava:\n;rataId | väylä | par"+
     *      "\n1|1|3" +
     *      "\n1|2|3" +
     *      "\n1|3|3" +
     *      "\n1|4|3" +
     *      "\n1|5|3" +
     *      "\n1|6|3" +
     *      "\n1|7|3" +
     *      "\n1|8|3" +
     *      "\n1|9|3" +
     *      "\n1|10|3" +
     *      "\n1|11|3" +
     *      "\n1|12|3" +
     *      "\n1|13|3" +
     *      "\n1|14|3" +
     *      "\n1|15|3" +
     *      "\n1|16|3" +
     *      "\n1|17|3" +
     *      "\n1|18|3";
     *  
     * Parit talKoe = new Parit("pKoe");
     * talKoe.getMuutoksia() === false;
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("pKoe.dat",tulos) === "Tiedosto ei aukea: pKoe.dat";
     * talKoe.perusParit(1);
     * talKoe.getMuutoksia() === true;
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("pKoe.dat",tulos) === null;
     * talKoe.getMuutoksia() === false;
     * Par uusi = new Par(5,6,7);
     * talKoe.lisaa(uusi);
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("pKoe.dat",tulos) === "Rivi 21: Jono loppui ensin, pKoe.dat on 5|6|7";
     * VertaaTiedosto.tuhoaTiedosto("pKoe.dat");
     * VertaaTiedosto.tuhoaTiedosto("pKoe.bak");
     * </pre>
     */
    public void tallenna() {
        if (!getMuutoksia()) return;
        
        File pBak = new File (getBkNimi());
        File pTied = new File(getTdNimi());
        pBak.delete();
        pTied.renameTo(pBak);
        
        try (PrintStream ulos = new PrintStream(new FileOutputStream(pTied, true))) {
            ulos.printf("; Kenttien järjestys tiedostossa on seuraava:\n;rataId | väylä | par");
            for(Par p : alkiot) {
                ulos.printf("\n" + p.toString());
            }
        }    catch (FileNotFoundException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
        muutoksia = false;
    }
    
    
    /**
     * poistaa partiedot alkioista id:n perusteella
     * @param id poistettavan id
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * Par g = new Par(10, 1, 1);
     * Par h = new Par(10, 2, 2);
     * koe.lisaa(b); koe.lisaa(e); koe.lisaa(c); koe.lisaa(d); 
     * koe.lisaa(a); koe.lisaa(f); koe.lisaa(h); koe.lisaa(g);
     * koe.getlkm() === 8;
     * koe.poista(1);
     * koe.poista(9);
     * koe.getlkm() === 2;
     * koe.getRadanParluvut(9) === null;
     * Arrays.toString(koe.getRadanParluvut(10)) === "[1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
     * </pre>
     */
    public void poista(int id) {

        List<Par> poisto = getRadanPar(id);
        if (poisto.size() <= 0) return;
        
        for(Par p : poisto) {
            alkiot.remove(p);
        }
        setMuutoksia();
    }
    
// ===================================================================================    
// testiä ja main
    
    /**
     * lisää oletusradan testausta varten
     * @param rataId id radalle
     */
    public void perusParit(int rataId) {
        for(int i = 0; i < 18; i++) {
            lisaa(new Par(rataId, i + 1, 3));
        }
    }
    
    
    /** 
     * getteri alkioille, testikäyttöön
     * @return palauttaa viitteen Par-alkioihin
     */
    public Collection<Par> getAlkiot(){
        return this.alkiot;
    }
        
    
    /** 
     * testipääohjelma
     * @param args ei kayt
    */
    public static void main(String[] args) {
    //
    }
}


