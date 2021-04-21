package tuloskortti;

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
     * koe.uusinId() === 0;
     * koe.rekisteroi();
     * koe.uusinId() === 1;
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
     * lisakoe.uusinId() === 4
     * </pre>
     */
    public void lisaaRata(RataTieto tiedot) {
        rekisteroi();
        
        int id = uusinId();
        String radanNimi = tiedot.getNimi();
        
        Nimi uusiN = new Nimi(id, radanNimi);
        nimet.lisaa(uusiN);
        
        int[] parTiedot = tiedot.getParit();
        
        for (int i = 1; i < parTiedot.length + 1; i++) {
            int luku = parTiedot[i - 1];
            Par uusiP = new Par(id, i, luku);
            this.parit.lisaa(uusiP);
        }
    }
    
    
    
    /**
     * korvaa vanhoja ratatietoja id:n perusteella
     * @param tiedot uudet tiedot
     */
    public void korvaaRata(RataTieto tiedot) {
        
        int id = tiedot.getId();
        Nimi kNimi = nimet.etsiNimi(id);
        kNimi.setNimi(tiedot.getNimi());
        
        int vayla = 0;
        
        List<Par> kParit = parit.getRadanPar(id);
        for (Par p : kParit) {
             vayla = p.getVayla();
             p.setPar(tiedot.getPar(vayla));
        }
        
        parit.setMuutoksia();
        nimet.setMuutoksia();
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
     * Arrays.toString(ok) === "[1, PerusNimi, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]";
     * ok = kasakoe.kasaaRata(2);
     * Arrays.toString(ok) === "[2, , null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]";
     * </pre>
     */
    
    public RataTieto kasaaRata(int id){
        
        RataTieto valmis = new RataTieto();
        valmis.setId(id);
        
        if(nimet.etsiNimi(id) == null) { return valmis; };
        
        Nimi rataN = nimet.etsiNimi(id);
        valmis.setNimi(rataN.getNimi());
        valmis.setParit(parit.getRadanParluvut(id));
        
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
    
    

    /** hakumetodi radan ID:lle
     * @return palauttaa rada id:n
     * @example
     * <pre name="test">
     * Rata koe = new Rata(1);
     * koe.uusinId() === 0;
     * koe.rekisteroi();
     * koe.uusinId() === 1;
     * koe.perusRata();
     * koe.uusinId() === 2;
     * </pre>
     */
    public int uusinId() {
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
        rataId = nimet.getJuoksevaId();
        parit.lueTiedosto();
    }
    
    
    /**
     * korvaa tai lisää ratatietoja, riippuen onko tietoja jo olemassa
     * @param tiedot uudet tiedot
     * @return palauttaa korvasiko (true) vai lisäsikö (false)
     */
    public boolean korvaaTaiLisaa(RataTieto tiedot) {
        int id = tiedot.getId(); 
        Nimi uNimi = nimet.etsiNimi(id);
        if (uNimi != null) { 
            korvaaRata(tiedot);
            return true;
        }
        lisaaRata(tiedot);
        return false;
        
    }
    
    
    /**
     * poistaa radan tiedot nimistä ja pareista
     * @param id poistettavan radan id
     * @return palauttaa 1 jos toinen onnistui, 2 jos molemmat, 0 jos epäonnistui
     */
    public int poista(int id) {
        int n = nimet.poista(id);
        int p = parit.poista(id);
        return n + p;
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
