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
     */
    public void rekisteroi() {
        this.rataId = juoksevaId;
        juoksevaId++;
    }
    
    
    /** kasaa radan tiedot String taulukkoon Parit ja Nimet luokista annetun id:n perusteella
     *  Taulukossa ensimmäisenä on radan nimi, jota seuraa ratojen Par luvut. Parin väylä vastaa parluvun paikkaa taulukossa
     * @param id rataid jonka pohjalta rata kasataan
     * @return palauttaa taulukon jossa ensimmäisenä nimi jota seuraavat parit.
     */
    
    public String[] kasaaRata(int id) {
        
        String[] valmis = new String[19];
        valmis[0] = nimet.etsiNimi(id).getNimi();
        int[] parluvut = parit.getRadanParluvut(id);
        
        for (int i = 0; i < parluvut.length; i++) {
            valmis[i +1] = "" + parluvut[i];
        }
        
        return valmis;
    }
    
    /** luo ja palauttaa radan id:n pohjalta
     * @param id id jonka pohjalta rata luodaan
     * @return palauttaa uuden radan
     */
    public Rata annaRata(int id) {
        Rata uusi = new Rata();
        Nimi un = this.nimet.etsiNimi(id);
        List <Par> up = this.parit.getRadanPar(id);
        
        uusi.nimet.lisaa(un);
        for(Par p : up) {
            uusi.parit.lisaa(p);
        }
        
        return uusi;
    }
    
    
    /**
     * @return palauttaa radan nimen id:n pohjalta
     */
    public String getNimi(){
        return this.nimet.etsiNimi(getId()).getNimi();
    }
    
    
    /** lisää uuden radan tietoihin String taulukosta
     * @param tiedot Taulukko mistä tiedot kerätään, ensimmäisenä oltava radan nimi, jota seuraavat ratojen Par luvut.
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
     */
    public int annaRataMaara(){
        int tulos = 0;
        for (int i = 0; i < juoksevaId; i++) {
            if (nimet.etsiNimi(i) != null);
            tulos ++;
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
