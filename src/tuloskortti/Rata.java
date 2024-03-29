package tuloskortti;

import java.util.ArrayList;
import java.util.List;


/**
 * Rataluokka käsittelee ratojen tietoja attribuuteillaan. Siirto tämän ja pääluokan välillä tapahtuu pääosin RataTieto-luokalla. Vanhojen tietojen korvaaminen tapahtuu täällä
 * tahvpwzw@jyu.student.fi
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
     * konstruktori
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
     * lisää uuden radan tietoihin RataTieto oliosta, määrittää id:n annetuista tiedoista riippumatta tietorakenteeseen sopivaksi
     * @param tiedot olio mistä tiedot kerätään
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * 
     * Rata lisakoe = new Rata(1);
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(2, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(1, "rata3", koePar3);
     * lisakoe.lisaaRata(rata1);
     * lisakoe.annaRataMaara() === 1;
     * lisakoe.lisaaRata(rata2);  
     * lisakoe.lisaaRata(rata3);
     * lisakoe.annaRataMaara() === 3;
     * lisakoe.uusinId() === 3;
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
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * 
     * Rata kkoe = new Rata(1);
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(1, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(1, "rata3", koePar3);
     * kkoe.lisaaRata(rata1);
     * kkoe.lisaaRata(rata2);
     * kkoe.kasaaRata(1).toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * kkoe.kasaaRata(2).toString() === "2|rata2|3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3";
     * kkoe.korvaaRata(rata3);
     * kkoe.kasaaRata(1).toString() === "1|rata3|1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1";
     * kkoe.kasaaRata(2).toString() === "2|rata2|3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3";
     * </pre>
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
     * kasaa radan tiedot RataTieto-olioon, jos rataa ei ole tiedoissa palauttaa null
     * @param id rataid jonka pohjalta rata kasataan
     * @return RataTieto-olion jossa tiedot, jos rataa ei löydy palauttaa null.
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * 
     * Rata kasakoe = new Rata(1);
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(2, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(1, "rata3", koePar3);
     * kasakoe.lisaaRata(rata1);
     * kasakoe.lisaaRata(rata2);  
     * kasakoe.lisaaRata(rata3);
     * kasakoe.kasaaRata(1).toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * kasakoe.kasaaRata(3).toString() === "3|rata3|1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1";
     * kasakoe.kasaaRata(4) === null;
     * kasakoe.kasaaRata(-1) === null;
     * </pre> 
     */
    public RataTieto kasaaRata(int id){
        
        RataTieto valmis = new RataTieto();
        
        if(nimet.etsiNimi(id) == null) { return null; };

        Nimi rataN = nimet.etsiNimi(id);
        
        valmis.setId(id);
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
         return nimet.getlkm();
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
     * etsii radat nimien avulla tiedoista hakuehdolla
     * @param hakuehto merkkijono jota etsitään
     * @return palauttaa ratojen tiedot listassa
     * <pre name="test">
     * #import java.util.*;
     * 
     * Rata hakukoe = new Rata(1);
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(0, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(0, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(0, "rata3", koePar3);
     * hakukoe.lisaaRata(rata1);
     * hakukoe.lisaaRata(rata2);
     * hakukoe.lisaaRata(rata3);
     * List<RataTieto> hk = hakukoe.etsiRadat("eka");
     * hk.size() === 0;
     * hk = hakukoe.etsiRadat("ta");
     * hk.size() === 3;
     * hk = hakukoe.etsiRadat("rata3");
     * hk.size() === 1;
     * hk.get(0).toString() === "3|rata3|1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1";
     * hk = hakukoe.etsiRadat("");
     * hk.size() === 3;
     */
    public List<RataTieto> etsiRadat(String hakuehto) {
        List<RataTieto> tulokset = new ArrayList<RataTieto>();
        List<Nimi> loytyneet = nimet.etsiNimia(hakuehto);
        for(Nimi n : loytyneet) {
            int id = n.getRataId();
            RataTieto tulos = new RataTieto();
            tulos = kasaaRata(id);
            tulokset.add(tulos);
        }
        return tulokset;
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
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * 
     * Rata koe = new Rata(1);
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(2, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(1, "rata3", koePar3);
     * koe.korvaaTaiLisaa(rata1) === false;
     * koe.korvaaTaiLisaa(rata2) === false;
     * koe.annaRataMaara() === 2;
     * koe.kasaaRata(1).toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * koe.kasaaRata(2).toString() === "2|rata2|3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3";
     * koe.korvaaTaiLisaa(rata3) === true;
     * koe.annaRataMaara() === 2;
     * koe.kasaaRata(1).toString() === "1|rata3|1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1";
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
     */
    public void poista(int id) {
        nimet.poista(id);
        parit.poista(id);
    }
    
    
// ===================================================================================    
// testiä ja main
    
    
    /**
     * lisää perusradan, testeihin
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
        this.nimet = new Nimet();
        this.parit = new Parit();
    }
    
    
    /** 
     * testipääohjelmaa
     * @param args ei kayt
     */
    public static void main(String[] args) {
        //
    }

}
