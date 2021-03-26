package tuloskortti;

/**
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimet{
    

    private static final int maxNimia = 2; 
    private int lkm;
    private String tiedosto = ""; //TODO vaihto oikeaan
    private Nimi alkiot[] = new Nimi[maxNimia];
    
    
    /**
     * Tyhjä muodostaja luokalle
     */
    public Nimet(){
    // attribuutit alustuu luokkaa luodessa
    }
    
    
    /**
     * Kuormittaa tavallisen kloonauksen, kloonaa taulukon lisäten sinne yhden lisäpaikan
     * @return palauttaa sisällöltään identtisen taulukon jossa yksi paikka enemmän
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
    
    
    /** lisää uuden nimen tietoihin
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
     * koe.getlkm() === 2;
     * koe.lisaa(n2);
     * koe.getlkm() === 3;
     * </pre>
     */
    public void lisaa(Nimi n){
        if(lkm >= alkiot.length) {
           this.alkiot = clone();
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
     * @throws NullPointerException jos ei ole löydy
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
            if ( paikka < 0 || lkm <= paikka ) throw new IndexOutOfBoundsException("Indeksi ulkona taulukosta:" + paikka);
            return this.alkiot [paikka];
    }
    
    
    /** hakee nimen alkioista id:n perusteella
     * @param id Rataid minkä pohjalta etsitään
     * @return palauttaa id:tä vastaavan nimiolion
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
