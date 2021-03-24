package tuloskortti;

/**
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimet extends Rata {
    
    private String tiedosto = "nimikoe.txt"; //TODO vaihto oikeaan
    
    private int lkm;
    private static final int maxNimia = 36; // riittää kahteen täyteen rataan
    private Nimi alkiot[] = new Nimi[maxNimia];
    
    
    /**
     * Tyhjä muodostaja luokalle
     */
    public Nimet(){
    // attribuutit alustuu luokkaa luodessa
    }

    
    /** lisää uuden nimen tietoihin
     * @param n uusi nimi
     */
    public void lisaa(Nimi n){
        if(lkm >= alkiot.length) System.err.println("Liikaa alkioita!");
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
    public Nimi getNimi(int paikka) throws IndexOutOfBoundsException {
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
            if( getNimi(i).getRataId() == id) return getNimi(i);
        }
        return null;
    }


    /** tallennus nimelle, kutsuu yläluokkaa
     * @param nimi tallennettva nimiolio
     */
    public void talletus(Nimi nimi) {
        super.talletus(tiedosto, nimi.toString());
    }
    
    /** lisää nimen testejä varten, id = 15 
     *  TODO poisto ku toimii
     */
    public void perusNimi() {
        Nimi perus = new Nimi(15, "PerusNimi");
        lisaa(perus);
    }
    
    
    /** testiohjoelmaa
     * @param args ei kayt
    */ 
    public static void main (String[] args) {
        Nimet perus = new Nimet();
        perus.perusNimi();
        Nimi puolanka = new Nimi(6
                ,"Puolanka");
        perus.lisaa(puolanka);
        String[] rata2 = perus.patki(perus.getNimi(0).toString());
        System.out.println("Radan ID: " + rata2[0] + ", Radan nimi: " + rata2[1]);
        
        System.out.println(perus.etsiNimi(6).toString());
        System.out.println(perus.etsiNimi(15).toString());
    }
     
}
