package tuloskortti;

/** Pääluokka ohjelmalle
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Tuloskortti {
    
    private Rata rata; //TODO korjaa ku luku toimii
    
    /**
     * tyhjä konstruktori
     */
    public Tuloskortti() {
       this.rata = new Rata("nimet", "par");
    }

    
    /**
     * Parsii tekstirivin taulukkoon erotinmerkkien kohdalta, poistaa kaikki ylimääräiset whitespacet
     * @param jono mikä pätkitään
     * @return  palauttaa pätkityn merkkijonotaulukon
     * @example
     * <pre name="test">
     * String[] koe = patki("15        | testi ");
     * koe[0] === "15";
     * koe[1] === "testi";
     * String[] koe2 = patki(" 150 \n | \n rivivaihto             ");
     * koe2[0] === "150";
     * koe2[1] === "rivivaihto";
     * String[] koe3 = patki("|");
     * koe3[0] === "";
     * koe3[1] === "";
     * </pre>
     */
    public static String[] patki(String jono){ //TODO KORJAA; YHÄ PARMUODOSSA!!
        String[] valmis = new String[3];
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
     * laskee ratojen maaran nimitiedoista aliohjelmalla
     * @return ratojen maara
     */
    public int rataMaara() {
        return rata.annaRataMaara();
    }
    
    
    /** 
     * kutsuu rataoliota hakemaan radan id:n phjalta
     * @param id millä haetaan
     * @return id:stä kasattu rata
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     * Tuloskortti tkoe = new Tuloskortti(1);
     * tkoe.lisaaPerus();
     * String[] ok = tkoe.annaRata(1);
     * Arrays.toString(ok) === "[PerusNimi, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]"
     * ok = tkoe.annaRata(2);
     * Arrays.toString(ok) === "[, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]";
     * </pre>
     */
    public RataTieto annaRata(int id){
        RataTieto tulos = rata.kasaaRata(id);
        return tulos;
    }

    
    /** 
     * lisää uuden radan tietoihin, luo sen annettujen tietojen pohjalta
     * @param ratatiedot taulukko minkä pohjalta uusi rata luodaan
     */
    public void lisaaRata(RataTieto ratatiedot) {
        rata.lisaaRata(ratatiedot);        
    }
    
    
    /**
     * korvaa vanhaa ratatietoa, jos ei ole olemass niin lisää
     * @param uusi uudet tiedot
     * @return palauttaa korvasiko (true) vai lisäsikö (false)
     */
    public boolean korvaaTaiLisaa(RataTieto uusi) {
        return rata.korvaaTaiLisaa(uusi);
    }
    
    /** 
     * hakee uusimman radan id:n
     * @return palauttaa viimeisen rekisteröidyn rataid:n
     */
    public int uusinId() {
        return rata.uusinId();
    }

    
    /**
     * kutsuu tallennusmetodeja
     */
    public void tallenna() {
        rata.tallenna();
    }
    
    
    /**
     * kutsuu rataa keräämään tiedot tiedostoista
     */
    public void lueTiedostot() {
        rata.lueTiedostot();
    }
    

    /**
     * poistaa ratatiedot id:n perusteella
     * @param id poistettavan radan id
     */
    public void poista(int id) {
        rata.poista(id);
    }
    
// ===================================================================================    
// testiä ja main   
    
    /**
     * testitarkoituksiin
     * @param testi radan juoksevanumero
     */
    public Tuloskortti(int testi) {
       this.rata = new Rata(testi);
    }
    
    
    /**
     *  kutsuu rataa lisäämään perusradan // TODO poista
     */
    public void lisaaPerus() {
        rata.perusRata();
    }
    
    /** testis
     * @param args ei kay
     */
    public static void main(String[] args) {
        Tuloskortti ok = new Tuloskortti();
        ok.lisaaPerus();
        ok.annaRata(1);
    }


}
