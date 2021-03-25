package tuloskortti;

/**
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimet{
    

    private static final int maxNimia = 5; 
    private int lkm;
    private String tiedosto = ""; //TODO vaihto oikeaan
    private Nimi alkiot[] = new Nimi[maxNimia];
    
    
    /**
     * Tyhjä muodostaja luokalle
     */
    public Nimet(){
    // attribuutit alustuu luokkaa luodessa
    }
    
    
    @Override 
    public Nimet clone(){
        
        Nimet klooni = new Nimet();
        klooni.lkm = this.getlkm();
        klooni.alkiot = new Nimi[this.lkm + 2];
        
        for (int i = 0; i < this.alkiot.length; i++) {
            klooni.alkiot[i] = this.alkiot[i];
        }
        return klooni;
        
    }

    
    /** lisää uuden nimen tietoihin
     * @param n uusi nimi
     */
    public void lisaa(Nimi n){
        if(lkm >= alkiot.length) {
           this.alkiot = this.clone().alkiot;
        }
        alkiot[lkm] = n;
        lkm++;
    }
    
    /**
     * @return palauttaa tämänhetkisten nimien lukumäärän
     */
    public int getlkm() {
        return this.lkm;
    }
    
    
    /**hakee nimen  tietystä taulukon paikasta
     * @param paikka paikka taulukossa
     * @return palauttaa paikassa olevan nimen
     * @throws IndexOutOfBoundsException jos yli taulukon rajoista
     */
    public Nimi anna(int paikka) throws IndexOutOfBoundsException {
            if ( paikka < 0 || lkm <= paikka ) throw new IndexOutOfBoundsException("Indeksi ulkona taulukosta:" + paikka);
            return this.alkiot [paikka];
    }
    
    
    /** hakee nimen alkioista id:n perusteella
     * @param id Rataid minkä pohjalta etsitään
     * @return palauttaa id:tä vastaavan nimiolion
     * @throws NullPointerException jos ei löydy
     */
    public Nimi etsiNimi(int id) throws NullPointerException {
        for (int i = 0; i < this.getlkm(); i++) {
            if( anna(i).getRataId() == id) return anna(i);
        }
        return null;
    }


    /** tallennus nimelle, kutsuu yläluokkaa
     * @param nimi tallennettva nimiolio
     * //TODO lisää talletus
     *public void talletus(Nimi nimi) {
     *   super.talletus(tiedosto, nimi.toString());
     *}
     */
    
    /** lisää nimen testejä varten
     *  TODO poisto ku toimii
     * @param rataId id radalle
     */
    public void perusNimi(int rataId) {
        Nimi perus = new Nimi(rataId, "PerusNimi");
        lisaa(perus);
    }
    
    
    /** testiohjoelmaa
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
