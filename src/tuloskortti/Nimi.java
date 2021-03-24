package tuloskortti;

/** luokka yhtä radan nimeä varten
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Nimi extends Nimet{
    
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
    
    @Override
    public String toString(){
        return this.nimiId + "|" + this.nimi; 
    }
}
