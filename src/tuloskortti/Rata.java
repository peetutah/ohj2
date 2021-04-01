package tuloskortti;

import java.io.PrintStream;

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
    private final Nimet nimet;
    private final Parit parit;
    
    
    
    /**
     * konstruktori,
     */
    public Rata() {
        this.nimet =new Nimet();
        this.parit = new Parit();
    }
    
    
    /** luo radan tiedostoista
     * @param nTiedosto käsiteltävä nimitiedosto
     * @param pTiedosto käsiteltävä partiedosto
     */
    public Rata(String nTiedosto, String pTiedosto) {
        this.nimet = new Nimet(nTiedosto);
        this.parit = new Parit(pTiedosto);
    }
    
    
    
    /**
     * rekisteroi uuden radan
     * @example
     * <pre name="test">
     * Rata koe = new Rata(1);
     * koe.getId() === 0;
     * koe.rekisteroi();
     * koe.getId() === 1;
     * </pre>
     */
    public void rekisteroi() {
        this.rataId = juoksevaId;
        juoksevaId++;
    }
    

    
    /** 
     * lisää uuden radan tietoihin String taulukosta
     * @param tiedot Taulukko mistä tiedot kerätään, ensimmäisenä oltava radan nimi, jota seuraavat ratojen Par luvut.
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * Rata lisakoe = new Rata(1);
     * lisakoe.perusRata(); 
     * String[] em = {"Esimerkki", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
     * lisakoe.lisaaRata(em);
     * String[] uusirata = {"Toppila", "3", "3", "3", "3", "3", "3", "3", "3", "3", "4", "3", "3", "3", "3", "3", "3", "3", "3"};
     * lisakoe.lisaaRata(uusirata);  
     * String[] uusirata2 = {"Virpiniemi", "3", "3", "4", "5", "4", "3", "3", "3", "3", "4", "3", "3", "3", "6", "3", "3", "3", "3"};
     * lisakoe.lisaaRata(uusirata2);
     * lisakoe.annaRataMaara() === 4;
     * lisakoe.getId() === 4
     * </pre>
     */
    public void lisaaRata(String[] tiedot) {
        rekisteroi();
        
        int id = getId();
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
     * kasaa radan tiedot String taulukkoon Parit ja Nimet luokista annetun id:n perusteella
     *  Taulukossa ensimmäisenä on radan nimi, jota seuraa ratojen Par luvut. Parin väylä vastaa parluvun paikkaa taulukossa
     *  jos rataa ei löydy palautetaan taulukko jossa ensimmäisenä ""
     * @param id rataid jonka pohjalta rata kasataan
     * @return palauttaa taulukon jossa ensimmäisenä nimi jota seuraavat parit.
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * Rata kasakoe = new Rata(1);
     * kasakoe.perusRata();
     * String[] ok = kasakoe.kasaaRata(1);
     * Arrays.toString(ok) === "[PerusNimi, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]";
     * ok = kasakoe.kasaaRata(2);
     * Arrays.toString(ok) === "[, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]";
     * </pre>
     */
    
    public String[] kasaaRata(int id){
        
        String[] valmis = new String[19];
        if(nimet.etsiNimi(id) == null) { valmis[0] = ""; return valmis; };
        
        Nimi rataN = nimet.etsiNimi(id);
        valmis[0] = rataN.getNimi();
        int[] parluvut = parit.getRadanParluvut(id);
        
        for (int i = 0; i < parluvut.length; i++) {
            valmis[i +1] = "" + parluvut[i];
        }
        return valmis;
    }
    
    
    /**
     * laskee ratojen maaran nimitietojen perusteella
     * @return palauttaa ratojen maaran
     * @example
     * <pre name="test">
     * Rata koe = new Rata(1);
     * koe.annaRataMaara() === 0;
     * koe.perusRata();
     * koe.annaRataMaara() === 1;
     * </pre>
     */
    public int annaRataMaara(){
         return nimet.getTosiMaara();
    }
    

    //TODO akuutisti päivitystä vailla, ehkä turha
    /**
     * @param out Printstream johon tulostellaan
     * @param id tulostettavan radan id
     */
    public void tulosta(PrintStream out, int id) {
        
        String[] ratatieto = kasaaRata(id);
        
        for(String s : ratatieto) {
        out.println(s);    
        }
        
    }
    

    /** hakumetodi radan ID:lle
     * @return palauttaa rada id:n
     * @example
     * <pre name="test">
     * Rata koe = new Rata(1);
     * koe.getId() === 0;
     * koe.rekisteroi();
     * koe.getId() === 1;
     * koe.perusRata();
     * koe.getId() === 2;
     * </pre>
     */
    public int getId() {
        return this.rataId;
    }
    
    
    /**
     * tallentaa tiedot par ja ratatiedot
     */
    public void tallenna() {
        nimet.tallenna();
        parit.tallenna();
    }
    
    
    /**
     * lukee itselleen par ja nimitiedot tiedostoista, päivittää juoksevan id:n
     */
    public void lueTiedostot() {
        nimet.lueTiedosto();
        juoksevaId = nimet.getJuoksevaId() +1;
        parit.lueTiedosto();
    }
    
// ===================================================================================    
// testiä ja main
    
    
    /**
     * lisää perusradan, id = 15, nimi = Perus, par =  3 x 18
     */
    public void perusRata() {
        rekisteroi();
        nimet.perusNimi(rataId);
        parit.perusParit(rataId);
    }
    
    
    /** luo radan jonka juokseva numero on valmiiksi määritelty testusta varten
     * @param testi asetettava juoksevaId
     */
    public Rata(int testi) {
        juoksevaId = testi;
        this.nimet =new Nimet();
        this.parit = new Parit();
    }
    
    /** 
     * testipääohjelmaa
     * @param args ei kayt
     */
    public static void main(String[] args) {
        /*
        Rata testirata = new Rata();
        
        testirata.perusRata();
        
        String[] uusirata = {"Toppila", "3", "3", "3", "3", "3", "3", "3", "3", "3", "4", "3", "3", "3", "3", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata);
        
        String[] uusirata2 = {"Virpiniemi", "3", "3", "4", "5", "4", "3", "3", "3", "3", "4", "3", "3", "3", "6", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata2);
        
        testirata.kasaaRata(1);
        */
    }

}
