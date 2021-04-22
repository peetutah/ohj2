package tuloskortti;

/** 
 * luokka yhtä radan nimeä varten
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimi{
    
    private String nimi;
    private int nimiId;
    
    
    /**
     * @param id radanId
     * @param nimi radan nimi
     * @example
     * <pre name="test"> 
     *  Nimi n;
     *
     *  n = new Nimi($id,$nm); n.toString() === $tulos;
     *
     *     $id | $nm     | $tulos
     *  ----------------------------
     *      1  | "ABC"   | "1|ABC"
     *      3  | "12\n3" | "3|12\n3"
     *      1  | ""      | "1|"
     *     --- | "Tyhjä" | "1|"
     *     15  | "Perus" | "15|Perus"
     *     
     * </pre>
     */
    public Nimi(int id, String nimi){
        this.nimi = nimi;
        this.nimiId = id;
    }
    
    
    /**
     * tyhjä muodostaja
     */
    public Nimi() { }
    
    
    /**
     * @return palauttaa nimen merkkijonona     
     * @example
     * <pre name="test"> 
     *  Nimi n;
     *
     *  n = new Nimi($id,$nm); n.getNimi() === $tulos;
     *
     *     $id | $nm     | $tulos
     *  ----------------------------
     *      1  | "ABC"   | "ABC"
     *      3  | "12\n3" | "12\n3"
     *      1  | ""      | ""
     *     --- | "Tyhjä" | ""
     *     15  | "Perus" | "Perus"
     *     
     * </pre>
     */
    public String getNimi() {
        return this.nimi;
    }
    
    
    /**
     * @return palauttaa radan id luvun
     * @example
     * <pre name="test"> 
     *  Nimi n;
     *
     *  n = new Nimi($id,$nm); n.getRataId() === $tulos;
     *
     *     $id | $nm     | $tulos
     *  ----------------------------
     *      1  | "ABC"   | 1
     *      3  | "12\n3" | 3
     *      1  | ""      | 1
     *     --- | "Tyhjä" | 1
     *     15  | "Perus" | 15
     *     
     * </pre>
     */
    public int getRataId() {
        return this.nimiId;
    }
    
    
    /** 
     * palauttaa nimitiedot muodossa "id|nimi"
     */
    @Override
    public String toString(){
        return this.nimiId + "|" + this.nimi; 
    }
    
    
    /**
     * selvittää nimitiedot erotinmerkillä | erotellusta merkkijonosta
     * @param jono jonka tiedoista nimiä lisätään
     * @throws NumberFormatException jos jonossa ei ole id:tä
     * @example
     * <pre name="test">
     * #THROWS NumberFormatException
     * Nimi koe = new Nimi();
     * koe.parse("1 | koe");
     * koe.toString() === "1|koe"
     * koe.parse("      2 \n\n | \n             riviKoe \n");
     * koe.toString() === "2|riviKoe";
     * koe.parse(" | "); #THROWS NumberFormatException
     * </pre>
     */
    
    public void parse(String jono) throws NumberFormatException{
        
        String rivi = jono.trim();
        int erotin = rivi.indexOf("|");
        
        this.nimiId = Integer.parseInt(rivi.substring(0, erotin).trim());
        this.nimi = rivi.substring(erotin +1).trim();
        
    }
    
    
    /**
     * asettaa nimioliolle uuden nimen
     * @param uusinimi uusi nimi oliolle
     */
    public void setNimi(String uusinimi) {
        this.nimi = uusinimi;
    }

}
