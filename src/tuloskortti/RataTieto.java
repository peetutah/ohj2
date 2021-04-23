package tuloskortti;

/**
 * @author tahvpwzw
 * @version 20.4.2021
 *  luokka ratatietojen siirtoa varten
 */
public class RataTieto implements Cloneable{

    private int id;
    private String nimi;
    private int[] par = new int[18];
    
    /**
     * tyhjä konstruktori, asettaa nimen nulliksi
     */
    public RataTieto() {
        this.nimi = null;
    }
    
    /**
     * luo ratatiedot annetuista arvoista
     * @param id radan id
     * @param nimi radan nimi
     * @param par radan parit taulukossa, väylät järjestyksessä
     */
    public RataTieto(int id, String nimi, int[] par) {
        this.id = id;
        this.nimi = nimi;
        this.par = par;
    }
    
    /**
     * hakee radan parit taulukossa
     * @return palauttaa parluvut väyläjärjestyksessä
     */
    public int[] getParit(){
        return this.par;
    }
    
    
    /**
     * asettaa radalle parit taulukolla
     * @param par asetettavat parit taulukossa, oltava järjestyksessä!
     */
    public void setParit(int[] par) {
        this.par = par;
    }
    
    
    /**
     * hakee tietyn väylän parluvun
     * @param vayla halutun väylän par
     * @return palauttaa väylän parin
     */
    public int getPar(int vayla) {
        return this.par[vayla -1];
    }
    
    
    /**
     * asettaa parluvun tietylle väylälle
     * @param vayla asetettava väylä
     * @param par parluku joka asetetaan
     */
    public void setPar(int vayla, int par) {
        this.par[vayla - 1] = par;
    }
    
    
    /**
     * hakee radan nimen
     * @return palauttaa radan nimen
     */
    public String getNimi() {
        return this.nimi;
    }
    
    
    /**
     * asettaa nimen radalle
     * @param nimi radan uusi nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    /**
     * hakee radan id:n
     * @return palauttaa rataId:n
     */
    public int getId(){
        return this.id;
    }
    
    
    
    /**
     * asettaa id:n radalle
     * @param id uusi id radalle
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * muuntaa radan tiedot merkkijonoksi muotoa: id|nimi|par1,par2,par3,par4...par18
     * @example
     * <pre name="test">
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * int[] koePar2 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
     * RataTieto rata2 = new RataTieto(2, "rata2", koePar2);
     * int[] koePar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
     * RataTieto rata3 = new RataTieto(1, "rata3", koePar3);
     * RataTieto rata4 = new RataTieto();
     * rata1.toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * rata2.toString() === "2|rata2|3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3";
     * rata3.toString() === "1|rata3|1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1";
     * rata4.toString() === "0|null|0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
     * </pre>
     */
    @Override
    public String toString() {
        StringBuilder parTiedot = new StringBuilder();
        for (int i : par) {
            parTiedot.append(i +", ");
        }
        parTiedot.delete(parTiedot.length() -2, parTiedot.length());
        return id + "|" + nimi + "|" + parTiedot.toString();
    }
    
    /**
     * kloonaa ratatiedot, palauttaa kloonin. HUOM jos nimi = null se muutetaan tyhjäksi merkkijonoksi
     * @example
     * <pre name="test">
     * #THROWS CloneNotSupportedException
     * 
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * rata1.toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * RataTieto rata2 = (RataTieto)rata1.clone();
     * rata2.toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * rata1.setNimi("Muutettu"); 
     * rata1.toString() === "1|Muutettu|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18"; 
     * rata2.toString() === "1|rata1|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18";
     * </pre>
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        
        RataTieto klooni = (RataTieto)super.clone();
        
        if (this.nimi == null) this.setNimi("");
        
        klooni.setId(this.getId());
        klooni.setNimi(new String(this.getNimi()));
        
        int[] klooniParit = new int[18];
        for (int i = 0; i < klooniParit.length; i++) {
            klooniParit[i] = this.getPar(i + 1);
        }
        klooni.setParit(klooniParit);
        
        return klooni;
    }
    
    
    /**
     * asettaa tiedon haluttuun kenttään, kentät: 0 = nimi, 1-18 = par 1-18, palauttaa virhetekstin tai null jos ei virheitä
     * @param k kentän numero
     * @param jono asetettavat tiedot
     * @return palauttaa null jos onnistui, muuten virhetekstin
     * @example
     * <pre name="test">
     * #THROWS NumberFormatException
     * 
     * int[] koePar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
     * RataTieto rata1 = new RataTieto(1, "rata1" , koePar);
     * rata1.aseta(0, "Ensimmäinen") === null;
     * rata1.aseta(18, "100") === null;
     * rata1.aseta(0, "") === "Radalla täytyy olla nimi!";
     * rata1.aseta(2, "a") === "Par voi olla vain numero!";
     * rata1.aseta(20, "4") === "Asetus epäonnistui";
     * rata1.toString() === "1|Ensimmäinen|1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 100"; 
     * </pre>
     */
    public String aseta(int k, String jono) {
        String tjono = jono.trim();
        switch ( k ) {
        case 0 : 
            if (tjono.length() <= 0) return "Radalla täytyy olla nimi!";
            setNimi(tjono);
            return null;
        case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18: 
            try {
                setPar(k, Integer.parseInt(tjono));
                return null;
            } catch ( NumberFormatException e) {
                return "Par voi olla vain numero!";
            }
        
        default : return "Asetus epäonnistui";
        }
    }
    
}
