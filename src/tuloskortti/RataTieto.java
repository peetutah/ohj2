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
     * palauttaa radan tietokenttien lukumäärän: 1 id, 2 nimi, 3-20 parit 
     * @return palauttaa 20
     */
    public int getKenttia() {
        return 20;
    }
    
    
    /**
     * muuntaa radan tiedot merkkijonoksi muotoa: id|nimi|par1,par2,par3,par4...par18
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
     * kloonaa ratatiedot, palauttaa kloonin
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        
        if (this.equals(null)) System.err.println("tyhjää kloonaat");
       
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
     * antaa halutun kentä tiedot, kentät: 0 = id, 1 = nimi, 2-19 = par 1-18 
     * @param k halutun kentän numero
     * @return palauttaa kentän sisällön merkkijonona
     */
    public String anna(int k) {
        switch (k) {
        case 0 : return "" + getId();
        case 1 : return getNimi();
        case 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19: return "" + getPar(k - 1);
        default : return "antaminen epäonnistui";
        }
    }
    
    
    /**
     * asetttaa tiedon haluttuun kenttään, kentät: 0 = nimi, 1-18 = par 1-18 
     * @param k kentä numero
     * @param jono asetettavat tiedot
     * @return palauttaa null jos onnistui
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
