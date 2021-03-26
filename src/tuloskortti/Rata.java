package tuloskortti;

import java.io.PrintStream;
import java.util.List;

/**
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Rata {
    
    /**
     *  RataId on juokseva luku joka periytyy alaluokille luokkien tietojen yhdistämistä varten
     */
    protected int rataId;
    private static int juoksevaId = 1;
    private final Nimet nimet = new Nimet();
    private final Parit parit = new Parit();
    
    
    
    /**
     * konstruktori
     */
    public Rata() {
    }
    
    
    
    /**
     * rekisteroi uuden radan
     * @example
     * <pre name="test">
     * Rata koe = new Rata();
     * koe.getId() === 0;
     * koe.rekisteroi();
     * koe.getId() === 1;
     * </pre>
     */
    public void rekisteroi() {
        this.rataId = juoksevaId;
        juoksevaId++;
    }
    
    //Arrays.toString(ok) === "["Perus", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3"]";
    /** kasaa radan tiedot String taulukkoon Parit ja Nimet luokista annetun id:n perusteella
     *  Taulukossa ensimmäisenä on radan nimi, jota seuraa ratojen Par luvut. Parin väylä vastaa parluvun paikkaa taulukossa
     * @param id rataid jonka pohjalta rata kasataan
     * @return palauttaa taulukon jossa ensimmäisenä nimi jota seuraavat parit.
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * Rata koe = new Rata();
     * koe.perusRata();
     * String[] ok = koe.kasaaRata(0);
     * Arrays.toString(ok) === "[PerusNimi, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]";
     * </pre>
     */
    
    public String[] kasaaRata(int id) {
        
        String[] valmis = new String[19];
        Nimi nimi = nimet.etsiNimi(id);
        valmis[0] = nimi.getNimi();
        int[] parluvut = parit.getRadanParluvut(id);
        
        for (int i = 0; i < parluvut.length; i++) {
            valmis[i +1] = "" + parluvut[i];
        }
        
        return valmis;
    }
    
    /** lisää uuden radan tietoihin String taulukosta
     * @param tiedot Taulukko mistä tiedot kerätään, ensimmäisenä oltava radan nimi, jota seuraavat ratojen Par luvut.
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * Rata koe = new Rata();
     * String[] em = {"Esimerkki", "1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
     * koe.lisaaRata(em);
     * String[] ok = koe.kasaaRata(0);
     * Arrays.toString(ok) === "[Esimerkki, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]";
     * </pre>
     */
    public void lisaaRata(String[] tiedot) {
        
        int id = this.rataId;
        String radanNimi = tiedot[0];
        
        Nimi uusiN = new Nimi(id, radanNimi);
        nimet.lisaa(uusiN);
        
        for (int i = 1; i < tiedot.length; i++) {
            int luku = Integer.parseInt(tiedot[i]);
            Par uusiP = new Par(id, i, luku);
            parit.lisaa(uusiP);
        }
    }
    
    
    /**
     * laskee ratojen maaran nimitietojen perusteella
     * @return palauttaa ratojen maaran
     * @example
     * <pre name="test">
     * Rata koe = new Rata();
     * koe.annaRataMaara() === 0;
     * koe.perusRata();
     * koe.annaRataMaara() === 1;
     * </pre>
     */
    public int annaRataMaara(){
        int tulos = 0;
        for (int i = 0; i < juoksevaId; i++) {
            if (nimet.etsiNimi(i) != null) tulos ++;
        }
        return tulos;
    }
    

    //TODO akuutisti päivitystä vailla
    /**
     * @param out Printstream jojhon tulostellaan
     */
    public void tulosta(PrintStream out) {
        
        String[] ratatieto = kasaaRata(rataId);
        
        for(String s : ratatieto) {
        out.println(s);    
        }
        
    }
    
    
    /**
     * lisää perusradan, id = 15, nimi = Perus, par =  3 x 18
     */
    public void perusRata() {
        nimet.perusNimi(rataId);
        parit.perusParit(rataId);
    }
    


    /** hakumetodi radan ID:lle
     * @return palauttaa rada id:n
     */
    public int getId() {
        return this.rataId;
    }
    
    
    /** testipääohjelmaa
     * @param args ei kayt
     */
    public static void  main(String[] args) {
        Rata testirata = new Rata();
        
        testirata.perusRata();

        testirata.parit.perusParit(testirata.rataId);
        testirata.nimet.perusNimi(testirata.rataId);
        
        testirata.tulosta(System.out);
        /*
        Nimet tn = new Nimet();
        tn.perusNimi();
        
        Parit tp = new Parit();
        tp.perusParit();
        
        
        String[] uusirata = {"Toppila", "3", "3", "3", "3", "3", "3", "3", "3", "3", "4", "3", "3", "3", "3", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata, tn, tp);
        
        String[] uusirata2 = {"Virpiniemi", "3", "3", "4", "5", "4", "3", "3", "3", "3", "4", "3", "3", "3", "6", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata2, tn, tp);
        
        
        String[] perusrata = testirata.kasaaRata(15, tn, tp);
        perusrata.toString();
        */
    }


}
