package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * luokka nimien hallinnoimiseen
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimet{
    

    private static final int maxNimia = 2; 
    private int lkm;
    private String tiedosto;
    private Nimi alkiot[] = new Nimi[maxNimia];
    
    private boolean muutoksia = false; //tallennusta varten
    
    
    /**
     * Tyhjä muodostaja luokalle
     */
    public Nimet(){
    // attribuutit alustuu luokkaa luodessa
    }
    
    
    /**
     * muodostaa nimet ja lisää sinne tiedot tiedostosta
     * @param tiedosto mitä luetaan
     */
    public Nimet(String tiedosto) {
        this.tiedosto = tiedosto;
    }
    
    
    /**
     * Kuormittaa tavallisen kloonauksen, kloonaa taulukon lisäten sinne yhden lisäpaikan
     * @return palauttaa sisällöltään identtisen taulukon jossa yksi paikka enemmän
     * @example
     * <pre name="test">
     * #THROWS IndexOutOfBoundsException
     * Nimet koe = new Nimet();
     * Nimi n3 = new Nimi(3, "Kolmas");
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * koe.lisaa(n1);
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * Nimi[] koeAlkiot = koe.getAlkiot();
     * koeAlkiot[0].toString() === "1|eka";
     * koeAlkiot[1].toString() === "3|Kolmas";
     * koeAlkiot[2].toString() === "2|toinen";
     * koeAlkiot[3] === null; #THROWS IndexOutOfBoundsException
     * koeAlkiot.length === 3;
     * Nimi[] klooni = koe.clone();
     * klooni[0].toString() === "1|eka";
     * klooni[1].toString() === "3|Kolmas";
     * klooni[2].toString() === "2|toinen";
     * klooni[3] === null;
     * klooni.length === 4;
     * </pre>
     */
    @Override
    public Nimi[] clone(){
        int koko = alkiot.length;
        Nimi[] klooni = new Nimi[koko + 1];
        for (int i = 0; i < koko; i++) {
            Nimi n = this.alkiot[i];
            klooni[i] = n;
        }
        return klooni;
    }
    
    
    /** 
     * lisää uuden nimen tietoihin
     * @param n uusi nimi
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi n3 = new Nimi(3, "Kolmas");
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * koe.getlkm() === 0;
     * koe.lisaa(n1);
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * koe.anna(0).toString() === "1|eka";
     * koe.anna(1).toString() === "3|Kolmas";
     * koe.anna(2).toString() === "2|toinen";
     * koe.getlkm() === 3;
     * </pre>
     */
    public void lisaa(Nimi n){
        if(lkm >= alkiot.length) {
           this.alkiot = clone();
        }
        alkiot[lkm] = n;
        lkm++;
        muutoksia = true;
    }
    
    /** 
     * getteri nimien lukumäärälle
     * @return palauttaa tämänhetkisten nimien lukumäärän
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi f = new Nimi(6, "F");
     * Nimi c = new Nimi(2, "C");
     * Nimi d = new Nimi(4, "D");
     * Nimi a = new Nimi(1, "A");
     * Nimi e = new Nimi(5, "E");
     * Nimi b = new Nimi(2, "B");
     * Nimi g = new Nimi(7, "G");
     * Nimi h = new Nimi(8, "H");
     * koe.getlkm() === 0;
     * koe.lisaa(b);
     * koe.getlkm() === 1;
     * koe.lisaa(e);
     * koe.lisaa(c);
     * koe.getlkm() === 3;
     * koe.lisaa(d);
     * koe.lisaa(a);
     * koe.getlkm() === 5;
     * koe.lisaa(f);
     * koe.lisaa(h);
     * koe.lisaa(g);
     * koe.getlkm() === 8;
     * </pre>
     */
    public int getlkm() {
        return this.lkm;
    }
    
    
    /** 
     * getteri alkioille
     * @return palauttaa tämänhetkiset Nimi-alkiot
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Nimet koe = new Nimet();
     * Nimi f = new Nimi(6, "F");
     * Nimi c = new Nimi(3, "C");
     * Nimi d = new Nimi(4, "D");
     * Nimi a = new Nimi(1, "A");
     * Nimi e = new Nimi(5, "E");
     * Nimi b = new Nimi(2, "B");
     * Nimi g = new Nimi(7, "G");
     * Nimi h = new Nimi(8, "H");
     * koe.lisaa(b);
     * koe.lisaa(e);
     * koe.lisaa(c);
     * koe.lisaa(d);
     * koe.lisaa(a);
     * koe.lisaa(f);
     * koe.lisaa(h);
     * Nimi[] koeAlkiot = koe.getAlkiot();
     * koeAlkiot.length === 7;
     * koeAlkiot[0].toString() === "2|B";
     * koeAlkiot[1].toString() === "5|E";
     * koeAlkiot[2].toString() === "3|C";
     * koe.lisaa(g);
     * koeAlkiot.length === 7;
     * koeAlkiot.equals(koe.getAlkiot()) === false;
     */
    public Nimi[] getAlkiot(){
        return this.alkiot;
    }
    
    /**
     * @return palauttaa alkioiden varman määrän, huomioi poistetut
     * TODO testit kuntoon kun poisto löytyy
     */
    public int getTosiMaara(){
        int t = 0;
        for (Nimi n : alkiot) {
            if (n != null) t++;
        }
        return t;
    }
    
    
    /** 
     * getteri tiedostonimelle
     * @return palauttaa tiedostonimen
     * @example
     * <pre name="test">
     * Nimet tKoe = new Nimet("testitiedosto");
     * tKoe.getTdNimi() === "testitiedosto.dat";
     * Nimet tyhjKoe = new Nimet("");
     * tyhjKoe.getTdNimi() === ".dat";
     * Nimet oletus = new Nimet();
     * oletus.getTdNimi() === null;
     * </pre>
     */
    public String getTdNimi() {
        if (this.tiedosto == null) return null;
        return this.tiedosto + ".dat";
    }
    
    
    /** 
     * getteri varatiedostonimelle
     * @return palauttaa varatiedostonimen
     * @example
     * <pre name="test">
     * Nimet tKoe = new Nimet("testitiedosto");
     * tKoe.getBkNimi() === "testitiedosto.bak";
     * Nimet tyhjKoe = new Nimet("");
     * tyhjKoe.getBkNimi() === ".bak";
     * Nimet oletus = new Nimet();
     * oletus.getBkNimi() === null;
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
     * Nimet mKoe = new Nimet();
     * Nimi uusi = new Nimi (3, "uusi");
     * mKoe.getMuutoksia() === false;
     * mKoe.lisaa(uusi);
     * mKoe.getMuutoksia() === true;
     * Nimet mKoe2 = new Nimet();
     * mKoe2.getMuutoksia() === false;
     * mKoe2.getTdNimi();
     * mKoe2.getlkm();
     * mKoe2.getMuutoksia() === false;
     * </pre>
     */
    public boolean getMuutoksia(){
        return this.muutoksia;
    }
    
    
    /**
     * ilmoittaa uusista muutoksista asettamalla muutoksia = true
     */
    public void setMuutoksia() {
       this.muutoksia = true;
    }
    
    
    /** hakee suurimmman id:n alkioista, eli tämän hetken juoksevan id:n
     * @return palauttaa alkioiden suurimman id:n
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi f = new Nimi(6, "F");
     * Nimi c = new Nimi(3, "C");
     * Nimi d = new Nimi(4, "D");
     * Nimi a = new Nimi(1, "A");
     * Nimi e = new Nimi(5, "E");
     * Nimi b = new Nimi(2, "B");
     * Nimi g = new Nimi(7, "G");
     * Nimi h = new Nimi(8, "H");
     * koe.getJuoksevaId() === 0;
     * koe.lisaa(b);
     * koe.lisaa(e);
     * koe.lisaa(c);
     * koe.getJuoksevaId() === 5;
     * koe.lisaa(d);
     * koe.lisaa(a);
     * koe.getJuoksevaId() === 5;
     * koe.lisaa(h);
     * koe.lisaa(f);
     * koe.lisaa(g);
     * koe.getJuoksevaId() === 8;
     * 
     * </pre>
     */
    public int getJuoksevaId() {
        int suurin = 0;
        for(Nimi n : alkiot) {
            if(n == null) continue;
            if(n.getRataId() >= suurin) suurin = n.getRataId(); 
        }
        return suurin;
    }
    
    /**
     * hakee nimen  tietystä taulukon paikasta
     * @param paikka paikka taulukossa
     * @return palauttaa paikassa olevan nimen
     * @throws IndexOutOfBoundsException jos yli taulukon rajoista
     * @example
     * <pre name="test">
     * #THROWS IndexOutOfBoundsException
     * Nimet koe = new Nimet();
     * Nimi n3 = new Nimi(3, "Kolmas");
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * koe.lisaa(n1);
     * koe.anna(1) === null; #THROWS IndexOutOfBoundsException
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * koe.anna(0).toString() === "1|eka";
     * koe.anna(1).toString() === "3|Kolmas";
     * koe.anna(2).toString() === "2|toinen";
     * koe.anna(3) === null; #THROWS IndexOutOfBoundsException
     * </pre>
     */
    public Nimi anna(int paikka) throws IndexOutOfBoundsException{
            if ( paikka < 0 || lkm <= paikka ) throw new IndexOutOfBoundsException("Indeksi ulkona taulukosta: " + paikka);
            Nimi tulos = this.alkiot [paikka];
            if( tulos == null ) return null;
            return tulos;
            
    }
    
    
    /** 
     * hakee nimen alkioista id:n perusteella
     * @param id Rataid minkä pohjalta etsitään
     * @return palauttaa id:tä vastaavan nimiolion, jos ei löydy palauttaa null
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi n3 = new Nimi(3, "Kolmas");
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * koe.lisaa(n1);
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * koe.etsiNimi(1).toString() === "1|eka";
     * koe.etsiNimi(3).toString() === "3|Kolmas";
     * koe.etsiNimi(2).toString() === "2|toinen";
     * koe.etsiNimi(0) === null;
     * </pre>
     */
    public Nimi etsiNimi(int id) {
        for (int i = 0; i < this.getlkm(); i++) {
            if( anna(i).getRataId() == id) return anna(i);
        }
        return null;
    }

    
    
    /**
     * hakee nimen paikan alkioista id:n perusteella jos ei löydy palauttaa -1
     * @param id Rataid minkä pohjalta etsitään
     * @return palauttaa nimen paikan alkioissa, jos ei löydy palauttaa -1
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * Nimi n3 = new Nimi(3, "Kolmas");
     * koe.lisaa(n1);
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * koe.etsiPaikka(1) === 0;
     * koe.etsiPaikka(2) === 2;
     * koe.etsiPaikka(3) === 1;
     * koe.etsiPaikka(0) === -1;
     * </pre>
     */
    public int etsiPaikka(int id) {
        for (int i = 0; i < this.getlkm(); i++) {
            if( anna(i).getRataId() == id) return i;
        }
        return -1;
    }
    
    

    /** 
     * tallennusmetodi nimille, tallentaa tiedot jos muutoksia tullut
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * 
     * VertaaTiedosto.tuhoaTiedosto("nKoe.dat");
     * 
     * String tulos =
     *      ";Kenttien järjestys tiedostossa on seuraava:\n;rataId | radan nimi" +
     *      "\n1|Ykkönen" +
     *      "\n3|Kolmonen" +
     *      "\n2|Kakkonen" +
     *      "\n4|Nelonen" +
     *      "\n7|Seiska" +
     *      "\n20|ToistKyt";
     *  
     * Nimet talKoe = new Nimet("nKoe");
     * talKoe.getMuutoksia() === false;
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("nKoe.dat",tulos) === "Tiedosto ei aukea: nKoe.dat";
     * talKoe.lisaa(new Nimi(1,"Ykkönen"));
     * talKoe.lisaa(new Nimi(3,"Kolmonen"));
     * talKoe.lisaa(new Nimi(2,"Kakkonen"));
     * talKoe.lisaa(new Nimi(4,"Nelonen"));
     * talKoe.lisaa(new Nimi(7,"Seiska"));
     * talKoe.lisaa(new Nimi(20,"ToistKyt"));
     * talKoe.getMuutoksia() === true;
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("nKoe.dat",tulos) === null;
     * talKoe.getMuutoksia() === false;
     * Nimi uusi = new Nimi(11,"Yksvielä");
     * talKoe.lisaa(uusi);
     * talKoe.tallenna();
     * VertaaTiedosto.vertaaFileString("nKoe.dat",tulos) === "Rivi 9: Jono loppui ensin, nKoe.dat on 11|Yksvielä";
     * VertaaTiedosto.tuhoaTiedosto("nKoe.dat");
     * VertaaTiedosto.tuhoaTiedosto("nKoe.bak");
     * </pre>
     */
    public void tallenna() {
        if (!getMuutoksia()) return;
        
        File nBak = new File (getBkNimi());
        File nTied = new File(getTdNimi());
        nBak.delete();
        nTied.renameTo(nBak);
        
        try (PrintStream ulos = new PrintStream(new FileOutputStream(nTied, true))) {
            ulos.printf(";Kenttien järjestys tiedostossa on seuraava:\n;rataId | radan nimi");
            for(int i = 0; i < getlkm(); i++) {
                Nimi n = alkiot[i];
                ulos.printf("\n" + n.toString());
            }
        }    catch (FileNotFoundException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
        muutoksia = false;
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
     * VertaaTiedosto.tuhoaTiedosto("nKoe.dat");
     * 
     * VertaaTiedosto.kirjoitaTiedosto("nKoe.dat",
     *      ";Kenttien järjestys tiedostossa on seuraava:\n;rataId | radan nimi" +
     *      "\n1|Ykkönen" +
     *      "\n3|Kolmonen" +
     *      "\n2|Kakkonen" +
     *      "\n4|Nelonen" +
     *      "\n7|Seiska" +
     *      "\n20|ToistKyt");
     *      
     * Nimet lukuKoe = new Nimet("nKoe");
     * lukuKoe.getMuutoksia() === false;
     * lukuKoe.getlkm() === 0;
     * lukuKoe.lueTiedosto();
     * lukuKoe.getlkm() === 6;
     * lukuKoe.getJuoksevaId() === 20;
     * lukuKoe.getMuutoksia() === true;
     * lukuKoe.etsiNimi(4).toString() === "4|Nelonen";
     * Nimi[]td = lukuKoe.getAlkiot();
     * td[0].toString() === "1|Ykkönen";
     * td[5].toString() === "20|ToistKyt";
     * 
     * VertaaTiedosto.tuhoaTiedosto("nKoe.dat");
     * VertaaTiedosto.tuhoaTiedosto("nKoe.bak");
     * </pre>
     */
    public void lueTiedosto() {
        
        String rivi;
        try (Scanner fi = new Scanner(new FileInputStream(new File(getTdNimi())))){
            
            while(fi.hasNext()) {
                rivi = fi.nextLine();
                if (rivi.startsWith(";")) continue;
                
                Nimi nimi = new Nimi();
                nimi.parse(rivi);
                lisaa(nimi);
                
            }
        } catch (IOException e) {
            System.err.println("Tiedosto ei löydy/aukea");
        }
    }
    
    

    /**
     * poistaa nimitiedon alkioista id:n perusteella, palauttaa 1 jos onnistui, muuten 0
     * @param id poistettavan id
     * @return palauttaa 1 jos onnistui, 0 jos tietoja ei ollut 
     * @example
     * <pre name="test">
     * Nimet koe = new Nimet();
     * Nimi n3 = new Nimi(3, "Kolmas");
     * Nimi n1 = new Nimi(1, "eka");
     * Nimi n2 = new Nimi(2, "toinen");
     * koe.lisaa(n1);
     * koe.lisaa(n3);
     * koe.lisaa(n2);
     * koe.getlkm() === 3;
     * koe.poista(1) === 1;
     * koe.poista(1) === 0;
     * koe.getlkm() === 2;
     * koe.getMuutoksia() === true;
     * koe.poista(2) === 1;
     * koe.getTosiMaara() === 1;
     * koe.getlkm() === 1;
     * </pre>
     */
    public int poista(int id) {
        int ind = etsiPaikka(id);
        if (ind < 0) return 0;
        this.lkm--;
        
        for(int i = ind; i < this.lkm; i++) {
            this.alkiot[i] =  this.alkiot[i +1];
        }
        this.alkiot[this.lkm] = null;
        setMuutoksia();
        return 1;
    }
    
// ===================================================================================    
// testiä ja main
    
    /** 
     * lisää nimen testejä varten
     *  TODO poisto ku toimii
     * @param rataId id radalle
     */
    public void perusNimi(int rataId) {
        Nimi perus = new Nimi(rataId, "PerusNimi");
        lisaa(perus);
    }
    
    
    /** 
     * testiohojelmaa
     * @param args ei kayt
    */ 
    public static void main (String[] args) {
        Nimet perus = new Nimet();
        perus.perusNimi(15);
        Nimi puolanka = new Nimi(6
                ,"Puolanka");
        perus.lisaa(puolanka);
        
        System.out.println(perus.etsiNimi(6).toString());
        System.out.println(perus.etsiNimi(15).toString());
    }


     
}
