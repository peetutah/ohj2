package tuloskortti;

import java.util.List;

/** 
 * Pääluokka ohjelmalle
 * tahvpwzw@jyu.student.fi
 * @author tahvpwzw
 * @version 21.3.2021
 * TODO koko tulospuoli puuttuu vielä 
 */
public class Tuloskortti {
    
    private Rata rata;
    
    /**
     * tyhjä konstruktori
     */
    public Tuloskortti() {
       this.rata = new Rata("nimet", "par");
    }

    
    /**
     * etsii radat nimien avulla tiedoista hakuehdolla
     * @param hakuehto merkkijono jota etsitään
     * @return palauttaa ratojen tiedot
     */
    public List<RataTieto> etsi(String hakuehto) {
        return rata.etsiRadat(hakuehto);
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
     */
    public RataTieto annaRata(int id){
        return rata.kasaaRata(id);
    }

    
    /** 
     * lisää uuden radan tietoihin, luo sen annettujen tietojen pohjalta
     * @param ratatiedot taulukko minkä pohjalta uusi rata luodaan
     */
    public void lisaaRata(RataTieto ratatiedot) {
        rata.lisaaRata(ratatiedot);        
    }
    
    
    /**
     * korvaa vanhaa ratatietoa, jos tietoa ei ole olemassa valmiiksi niin lisää sen
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
    
}
