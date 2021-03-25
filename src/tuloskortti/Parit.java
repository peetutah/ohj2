package tuloskortti;

import java.util.*;

/**
 * luokka parien hallinnoimiseen
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Parit implements Iterable<Par>{
    
    private String tiedosto = ""; // TODO vaihto oikeaan
    private final Collection<Par> alkiot = new ArrayList<Par>();
    
    
    /**
     * tyhjä muodostaja
     */
    public Parit() {
        //
    }
        
    
    /** tallennus parille, kutsuu yläluokkaa
     * @param par tallennettava par-olio
     //TODO lisää talletus
    public void talletus(Par par) {
        super.talletus(tiedosto, par.toString());
    }
    */

    
    /** lisää uuden parin tietorakenteeseen
     * @param p  Par joka lisätään
     */
    public void lisaa(Par p) {
        alkiot.add(p);
    }
    
    
    /** palauttaa Parien lukumäärän
     * @return Parien lukumäärä
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe2 = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * koe2.lisaa(b);
     * koe2.lisaa(e);
     * koe2.getlkm() === 2;
     * koe2.lisaa(c);
     * koe2.lisaa(d);
     * koe2.lisaa(a);
     * koe2.lisaa(f);
     * koe2.getlkm() === 6;
     * </pre>
     */
    public int getlkm() {
        return alkiot.size();
    }
    
    
    /** Hakee annetusta Par-taulukosta vain väylien parit
     * @param id on rataId jonka perusteella haetaan
     * @return palauttaa väylien par-luvut taulukossa ja oikeassa järjestyksessä: väylä 1 => 0 | 2 => 1...
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Parit koe2 = new Parit();
     * Par f = new Par(9, 6, 6);
     * Par c = new Par(9, 3, 3);
     * Par d = new Par(9, 4, 4);
     * Par a = new Par(9, 1, 1);
     * Par e = new Par(9, 5, 5);
     * Par b = new Par(9, 2, 2);
     * koe2.lisaa(b);
     * koe2.lisaa(e);
     * koe2.lisaa(c);
     * koe2.lisaa(d);
     * koe2.lisaa(a);
     * koe2.lisaa(f);
     * int[] koeLuku = new int[18];
     * koeLuku = koe2.getRadanParluvut(9);
     * Arrays.toString(koeLuku) === "[1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
     * </pre>     
     * */
    public int[] getRadanParluvut(int id) {
        int[] rata = new int[18];
        List<Par> apuPar = getRadanPar(id);
        for (Par parluku : apuPar) {
            rata[parluku.getVayla()-1] = parluku.getPar();
        }
        return rata;
    }
    
    
    /** haetaan kaikki yhteen rataan liittyvät parit Par-listaan
     * @param id on rataId jonka perusteella haetaan
     * @return palauttaa parit listassa
     */
    public List<Par> getRadanPar(int id) {
        List<Par> rata = new ArrayList<Par>();
        for (Par p : alkiot) {
            if(p.getRataId() == id) rata.add(p);
        }
        return rata;
    }
    

    @Override
    public Iterator<Par> iterator() {
        return alkiot.iterator();
    }
    
    
    /**
     * lisää oletusradan testausta varten
     * TODO poista kun luokka toimii
     * @param rataId id radalle
     */
    public void perusParit(int rataId) {
        for(int i = 0; i < 18; i++) {
            lisaa(new Par(rataId, i + 1, 3));
        }
    }
    
    
    /** testiohjelmaa
     * @param args ei kayt
    */
    public static void main(String[] args) {
        Parit par = new Parit();
        par.perusParit(15);
        for(Par p : par.alkiot ) {
            System.out.println(p.toString());
        }
    }
}


