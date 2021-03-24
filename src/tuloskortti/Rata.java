package tuloskortti;

/**
 * @author tahvpwzw
 * @version 21.3.2021
 *
 */
public class Rata extends Tuloskortti{
    
    /**
     *  RataId on juokseva luku joka periytyy alaluokille luokkien tietojen yhdistämistä varten
     */
    protected int rataId;
    private static int juoksevaId = 1;
    // TODO ei tietoa miksi ei anna luoda Nimet tai Parit luokkien atrribuutteja ilman Stackoverflow:ta, luotava atm erikseen pääohjelmassa
    
    
    
    /**
     * konstruktori
     */
    public Rata() {
    }
    
    
    /** kasaa radan tiedot String taulukkoon Parit ja Nimet luokista annetun id:n perusteella
     *  Taulukossa ensimmäisenä on radan nimi, jota seuraa ratojen Par luvut. Parin väylä vastaa parluvun paikkaa taulukossa
     * @param id rataid jonka pohjalta rata kasataan
     * @param nt Nimet olio
     * @param pt Parit olio
     * @return palauttaa taulukon jossa ensimmäisenä nimi jota seuraavat parit.
     */
    public String[] kasaaRata(int id, Nimet nt, Parit pt) {
        
        String[] valmis = new String[19];
        valmis[0] = nt.etsiNimi(id).getNimi();
        int[] parluvut = pt.getRadanParluvut(id);
        
        for (int i = 0; i < parluvut.length; i++) {
            valmis[i +1] = "" + parluvut[i];
        }
        
        return valmis;
    }
    
    
    
    /** lisää uuden radan tietoihin String taulukosta
     * @param tiedot Taulukko mistä tiedot kerätään, ensimmäisenä oltava radan nimi, jota seuraavat ratojen Par luvut.
     * @param nt Nimet olio
     * @param pt Parit olio
     */
    public void lisaaRata(String[] tiedot, Nimet nt, Parit pt) {
        this.rataId = juoksevaId;
        juoksevaId++;
        
        int id = this.rataId;
        String radanNimi = tiedot[0];
        
        Nimi uusiN = new Nimi(id, radanNimi);
        nt.lisaa(uusiN);
        
        for (int i = 1; i < tiedot.length; i++) {
            int luku = Integer.parseInt(tiedot[i]);
            Par uusiP = new Par(id, i, luku);
            pt.lisaa(uusiP);
        }
    }


    /** testipääohjelmaa
     * @param args ei kayt
     */
    public static void  main(String[] args) {
        Rata testirata = new Rata();
        
        Nimet tn = new Nimet();
        tn.perusNimi();
        
        Parit tp = new Parit();
        tp.perusParit();
        
        String[] uusirata = {"Toppila", "3", "3", "3", "3", "3", "3", "3", "3", "3", "4", "3", "3", "3", "3", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata, tn, tp);
        
        String[] uusirata2 = {"Virpiniemi", "3", "3", "4", "5", "4", "3", "3", "3", "3", "4", "3", "3", "3", "6", "3", "3", "3", "3"};
        testirata.lisaaRata(uusirata2, tn, tp);
        
        
        String[] perusrata = testirata.kasaaRata(15, tn, tp);
        perusrata.toString();
        
    }
}
