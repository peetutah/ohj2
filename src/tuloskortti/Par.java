package tuloskortti;

/**
 * luokka yksittäistä paria varten
 * tahvpwzw@jyu.student.fi
 * @author tahvpwzw
 * @version 21.3.2021
 */

public class Par{
    private int parId;
    private int vayla;
    private int par;
    
    
    /**
     * konstruktori parin alustamista varten
     * @param id radan id
     * @param vayla monesko väylä radalla
     * @param par väylän par
     */
    public Par(int id, int vayla, int par) {
        this.parId =  id;
        this.vayla = vayla;
        this.par = par;
    }
    
    
    /**
     * tyhjä muodostaja
     */
    public Par() { }

    
    /** 
     * get-metodi rataId:lle
     * @return palauttaa radan id luvun    
     * @example
     * <pre name="test">
     * Par koe = new Par(0,1,3);
     * koe.getRataId() === 0;
     * Par koe2 = new Par(0,2,4);
     * koe2.getRataId() === 0;
     * Par koe3 = new Par(500,-1,0);
     * koe3.getRataId() === 500;
     * Par koe4 = new Par(0,0,0);
     * koe4.getRataId() === 0;
     * Par koe5 = new Par(1,20,3);
     * koe5.getRataId() === 1;
     * </pre>
     */
    public int getRataId() {
        return this.parId;
    }
    
    
    /** 
     * get-metodi väylälle
     * @return palauttaa olion väylän luvun
     * @example
     * <pre name="test">
     * Par koe = new Par(0,1,3);
     * koe.getVayla() === 1;
     * Par koe2 = new Par(0,2,4);
     * koe2.getVayla() === 2;
     * Par koe3 = new Par(500,-1,0);
     * koe3.getVayla() === -1;
     * Par koe4 = new Par(0,0,0);
     * koe4.getVayla() === 0;
     * Par koe5 = new Par(1,20,3);
     * koe5.getVayla() === 20;
     * </pre>
     */
    public int getVayla() {
        return this.vayla;
    }
    
    
    /**
     * get-metodi par-luvulle
     * @return palauttaa olion par luvun
     * @example
     * <pre name="test">
     * Par koe = new Par(0,1,3);
     * koe.getPar() === 3;
     * Par koe2 = new Par(0,2,4);
     * koe2.getPar() === 4;
     * Par koe3 = new Par(500,-1,0);
     * koe3.getPar() === 0;
     * Par koe4 = new Par(0,0,0);
     * koe4.getPar() === 0;
     * Par koe5 = new Par(1,20,3);
     * koe5.getPar() === 3;
     * </pre>
     */
    public int getPar() {
        return this.par;
    }
    
    
    /**
     * palauttaa olion tiedot merkkijonona muodossa "id|väylä|par"
     * @example
     * <pre name="test">
     * Par koe = new Par(0,1,3);
     * koe.toString() === "0|1|3";
     * Par koe2 = new Par(0,2,4);
     * koe2.toString() === "0|2|4";
     * Par koe3 = new Par(500,-1,0);
     * koe3.toString() === "500|-1|0";
     * Par koe4 = new Par(0,0,0);
     * koe4.toString() === "0|0|0";
     * Par koe5 = new Par(1,20,3);
     * koe5.toString() === "1|20|3";
     * </pre>
     */
    @Override
    public String toString(){
        return this.parId + "|" + this.vayla + "|" + this.par; 
    }
    
    
    /**
     * selvittää Partiedot erotinmerkeillä | erotellusta merkkijonosta
     * @param jono jonka tiedoista pareja lisätään
     * @throws NumberFormatException jos muita kuin numeroita
     * @example
     * <pre name="test">
     * #THROWS NumberFormatException
     * Par koe = new Par();
     * koe.parse("1 | 2 | 3");
     * koe.toString() === "1|2|3"
     * koe.parse("      4 \n\n | \n             5 \n|    \n  6 \n ");
     * koe.toString() === "4|5|6";
     * koe.parse("2 | esim | 1 "); #THROWS NumberFormatException
     * koe.parse("|"); #THROWS NumberFormatException 
     * </pre>
     */
    
    public void parse(String jono) throws NumberFormatException{
        
        String rivi = jono.trim();
        int a = 0;
        int b = 0;
        int[] tieto = new int[3];
        
        for (int i = 0; i <= tieto.length; i++){
            b = rivi.indexOf("|", a);
            if (b == -1) { tieto[i] = Integer.parseInt(rivi.substring(a).trim()); break; }
            tieto[i] = Integer.parseInt(rivi.substring(a, b).trim());
            a = b + 1;
        }
        this.parId = tieto[0];
        this.vayla = tieto[1];
        this.par = tieto[2];
    }
    
    
    /**
     * asettaa paroliolle uuden parluvun
     * @param uusipar uusi parluku oliolle
     */
    public void setPar(int uusipar) {
        this.par = uusipar;
    }
    
    
}
