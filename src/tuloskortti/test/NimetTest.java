package tuloskortti.test;
// Generated by ComTest BEGIN
import java.util.*;
import java.io.IOException;
import fi.jyu.mit.ohj2.VertaaTiedosto;
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.04.01 15:49:27 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class NimetTest {



  // Generated by ComTest BEGIN
  /** 
   * testClone49 
   * @throws IndexOutOfBoundsException when error
   */
  @Test
  public void testClone49() throws IndexOutOfBoundsException {    // Nimet: 49
    Nimet koe = new Nimet(); 
    Nimi n3 = new Nimi(3, "Kolmas"); 
    Nimi n1 = new Nimi(1, "eka"); 
    Nimi n2 = new Nimi(2, "toinen"); 
    koe.lisaa(n1); 
    koe.lisaa(n3); 
    koe.lisaa(n2); 
    Nimi[] koeAlkiot = koe.getAlkiot(); 
    assertEquals("From: Nimet line: 59", "1|eka", koeAlkiot[0].toString()); 
    assertEquals("From: Nimet line: 60", "3|Kolmas", koeAlkiot[1].toString()); 
    assertEquals("From: Nimet line: 61", "2|toinen", koeAlkiot[2].toString()); 
    try {
    assertEquals("From: Nimet line: 62", null, koeAlkiot[3]); 
    fail("Nimet: 62 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
    assertEquals("From: Nimet line: 63", 3, koeAlkiot.length); 
    Nimi[] klooni = koe.clone(); 
    assertEquals("From: Nimet line: 65", "1|eka", klooni[0].toString()); 
    assertEquals("From: Nimet line: 66", "3|Kolmas", klooni[1].toString()); 
    assertEquals("From: Nimet line: 67", "2|toinen", klooni[2].toString()); 
    assertEquals("From: Nimet line: 68", null, klooni[3]); 
    assertEquals("From: Nimet line: 69", 4, klooni.length); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaa88 */
  @Test
  public void testLisaa88() {    // Nimet: 88
    Nimet koe = new Nimet(); 
    Nimi n3 = new Nimi(3, "Kolmas"); 
    Nimi n1 = new Nimi(1, "eka"); 
    Nimi n2 = new Nimi(2, "toinen"); 
    assertEquals("From: Nimet line: 93", 0, koe.getlkm()); 
    koe.lisaa(n1); 
    koe.lisaa(n3); 
    koe.lisaa(n2); 
    assertEquals("From: Nimet line: 97", "1|eka", koe.anna(0).toString()); 
    assertEquals("From: Nimet line: 98", "3|Kolmas", koe.anna(1).toString()); 
    assertEquals("From: Nimet line: 99", "2|toinen", koe.anna(2).toString()); 
    assertEquals("From: Nimet line: 100", 3, koe.getlkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetlkm116 */
  @Test
  public void testGetlkm116() {    // Nimet: 116
    Nimet koe = new Nimet(); 
    Nimi f = new Nimi(6, "F"); 
    Nimi c = new Nimi(2, "C"); 
    Nimi d = new Nimi(4, "D"); 
    Nimi a = new Nimi(1, "A"); 
    Nimi e = new Nimi(5, "E"); 
    Nimi b = new Nimi(2, "B"); 
    Nimi g = new Nimi(7, "G"); 
    Nimi h = new Nimi(8, "H"); 
    assertEquals("From: Nimet line: 126", 0, koe.getlkm()); 
    koe.lisaa(b); 
    assertEquals("From: Nimet line: 128", 1, koe.getlkm()); 
    koe.lisaa(e); 
    koe.lisaa(c); 
    assertEquals("From: Nimet line: 131", 3, koe.getlkm()); 
    koe.lisaa(d); 
    koe.lisaa(a); 
    assertEquals("From: Nimet line: 134", 5, koe.getlkm()); 
    koe.lisaa(f); 
    koe.lisaa(h); 
    koe.lisaa(g); 
    assertEquals("From: Nimet line: 138", 8, koe.getlkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetAlkiot150 */
  @Test
  public void testGetAlkiot150() {    // Nimet: 150
    Nimet koe = new Nimet(); 
    Nimi f = new Nimi(6, "F"); 
    Nimi c = new Nimi(3, "C"); 
    Nimi d = new Nimi(4, "D"); 
    Nimi a = new Nimi(1, "A"); 
    Nimi e = new Nimi(5, "E"); 
    Nimi b = new Nimi(2, "B"); 
    Nimi g = new Nimi(7, "G"); 
    Nimi h = new Nimi(8, "H"); 
    koe.lisaa(b); 
    koe.lisaa(e); 
    koe.lisaa(c); 
    koe.lisaa(d); 
    koe.lisaa(a); 
    koe.lisaa(f); 
    koe.lisaa(h); 
    Nimi[] koeAlkiot = koe.getAlkiot(); 
    assertEquals("From: Nimet line: 170", 7, koeAlkiot.length); 
    assertEquals("From: Nimet line: 171", "2|B", koeAlkiot[0].toString()); 
    assertEquals("From: Nimet line: 172", "5|E", koeAlkiot[1].toString()); 
    assertEquals("From: Nimet line: 173", "3|C", koeAlkiot[2].toString()); 
    koe.lisaa(g); 
    assertEquals("From: Nimet line: 175", 7, koeAlkiot.length); 
    assertEquals("From: Nimet line: 176", false, koeAlkiot.equals(koe.getAlkiot())); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetTdNimi199 */
  @Test
  public void testGetTdNimi199() {    // Nimet: 199
    Nimet tKoe = new Nimet("testitiedosto"); 
    assertEquals("From: Nimet line: 201", "testitiedosto.dat", tKoe.getTdNimi()); 
    Nimet tyhjKoe = new Nimet(""); 
    assertEquals("From: Nimet line: 203", ".dat", tyhjKoe.getTdNimi()); 
    Nimet oletus = new Nimet(); 
    assertEquals("From: Nimet line: 205", null, oletus.getTdNimi()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetBkNimi218 */
  @Test
  public void testGetBkNimi218() {    // Nimet: 218
    Nimet tKoe = new Nimet("testitiedosto"); 
    assertEquals("From: Nimet line: 220", "testitiedosto.bak", tKoe.getBkNimi()); 
    Nimet tyhjKoe = new Nimet(""); 
    assertEquals("From: Nimet line: 222", ".bak", tyhjKoe.getBkNimi()); 
    Nimet oletus = new Nimet(); 
    assertEquals("From: Nimet line: 224", null, oletus.getBkNimi()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetMuutoksia235 */
  @Test
  public void testGetMuutoksia235() {    // Nimet: 235
    Nimet mKoe = new Nimet(); 
    Nimi uusi = new Nimi (3, "uusi"); 
    assertEquals("From: Nimet line: 240", false, mKoe.getMuutoksia()); 
    mKoe.lisaa(uusi); 
    assertEquals("From: Nimet line: 242", true, mKoe.getMuutoksia()); 
    Nimet mKoe2 = new Nimet(); 
    assertEquals("From: Nimet line: 244", false, mKoe2.getMuutoksia()); 
    mKoe2.getTdNimi(); 
    mKoe2.getlkm(); 
    assertEquals("From: Nimet line: 247", false, mKoe2.getMuutoksia()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetJuoksevaId258 */
  @Test
  public void testGetJuoksevaId258() {    // Nimet: 258
    Nimet koe = new Nimet(); 
    Nimi f = new Nimi(6, "F"); 
    Nimi c = new Nimi(3, "C"); 
    Nimi d = new Nimi(4, "D"); 
    Nimi a = new Nimi(1, "A"); 
    Nimi e = new Nimi(5, "E"); 
    Nimi b = new Nimi(2, "B"); 
    Nimi g = new Nimi(7, "G"); 
    Nimi h = new Nimi(8, "H"); 
    assertEquals("From: Nimet line: 268", 0, koe.getJuoksevaId()); 
    koe.lisaa(b); 
    koe.lisaa(e); 
    koe.lisaa(c); 
    assertEquals("From: Nimet line: 272", 5, koe.getJuoksevaId()); 
    koe.lisaa(d); 
    koe.lisaa(a); 
    assertEquals("From: Nimet line: 275", 5, koe.getJuoksevaId()); 
    koe.lisaa(h); 
    koe.lisaa(f); 
    koe.lisaa(g); 
    assertEquals("From: Nimet line: 279", 8, koe.getJuoksevaId()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testAnna298 
   * @throws IndexOutOfBoundsException when error
   */
  @Test
  public void testAnna298() throws IndexOutOfBoundsException {    // Nimet: 298
    Nimet koe = new Nimet(); 
    Nimi n3 = new Nimi(3, "Kolmas"); 
    Nimi n1 = new Nimi(1, "eka"); 
    Nimi n2 = new Nimi(2, "toinen"); 
    koe.lisaa(n1); 
    try {
    assertEquals("From: Nimet line: 305", null, koe.anna(1)); 
    fail("Nimet: 305 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
    koe.lisaa(n3); 
    koe.lisaa(n2); 
    assertEquals("From: Nimet line: 308", "1|eka", koe.anna(0).toString()); 
    assertEquals("From: Nimet line: 309", "3|Kolmas", koe.anna(1).toString()); 
    assertEquals("From: Nimet line: 310", "2|toinen", koe.anna(2).toString()); 
    try {
    assertEquals("From: Nimet line: 311", null, koe.anna(3)); 
    fail("Nimet: 311 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testEtsiNimi328 */
  @Test
  public void testEtsiNimi328() {    // Nimet: 328
    Nimet koe = new Nimet(); 
    Nimi n3 = new Nimi(3, "Kolmas"); 
    Nimi n1 = new Nimi(1, "eka"); 
    Nimi n2 = new Nimi(2, "toinen"); 
    koe.lisaa(n1); 
    koe.lisaa(n3); 
    koe.lisaa(n2); 
    assertEquals("From: Nimet line: 336", "1|eka", koe.etsiNimi(1).toString()); 
    assertEquals("From: Nimet line: 337", "3|Kolmas", koe.etsiNimi(3).toString()); 
    assertEquals("From: Nimet line: 338", "2|toinen", koe.etsiNimi(2).toString()); 
    assertEquals("From: Nimet line: 339", null, koe.etsiNimi(0)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testTallenna353 
   * @throws IOException when error
   */
  @Test
  public void testTallenna353() throws IOException {    // Nimet: 353
    VertaaTiedosto.tuhoaTiedosto("nKoe.dat"); 
    String tulos =
    ";Kenttien järjestys tiedostossa on seuraava:\n;rataId | radan nimi" +
    "\n1|Ykkönen" +
    "\n3|Kolmonen" +
    "\n2|Kakkonen" +
    "\n4|Nelonen" +
    "\n7|Seiska" +
    "\n20|ToistKyt"; 
    Nimet talKoe = new Nimet("nKoe"); 
    assertEquals("From: Nimet line: 370", false, talKoe.getMuutoksia()); 
    talKoe.tallenna(); 
    assertEquals("From: Nimet line: 372", "Tiedosto ei aukea: nKoe.dat", VertaaTiedosto.vertaaFileString("nKoe.dat",tulos)); 
    talKoe.lisaa(new Nimi(1,"Ykkönen")); 
    talKoe.lisaa(new Nimi(3,"Kolmonen")); 
    talKoe.lisaa(new Nimi(2,"Kakkonen")); 
    talKoe.lisaa(new Nimi(4,"Nelonen")); 
    talKoe.lisaa(new Nimi(7,"Seiska")); 
    talKoe.lisaa(new Nimi(20,"ToistKyt")); 
    assertEquals("From: Nimet line: 379", true, talKoe.getMuutoksia()); 
    talKoe.tallenna(); 
    assertEquals("From: Nimet line: 381", null, VertaaTiedosto.vertaaFileString("nKoe.dat",tulos)); 
    assertEquals("From: Nimet line: 382", false, talKoe.getMuutoksia()); 
    Nimi uusi = new Nimi(11,"Yksvielä"); 
    talKoe.lisaa(uusi); 
    talKoe.tallenna(); 
    assertEquals("From: Nimet line: 386", "Rivi 9: Jono loppui ensin, nKoe.dat on 11|Yksvielä", VertaaTiedosto.vertaaFileString("nKoe.dat",tulos)); 
    VertaaTiedosto.tuhoaTiedosto("nKoe.dat"); 
    VertaaTiedosto.tuhoaTiedosto("nKoe.bak"); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testLueTiedosto414 
   * @throws IOException when error
   */
  @Test
  public void testLueTiedosto414() throws IOException {    // Nimet: 414
    VertaaTiedosto.tuhoaTiedosto("nKoe.dat"); 
    VertaaTiedosto.kirjoitaTiedosto("nKoe.dat",
    ";Kenttien järjestys tiedostossa on seuraava:\n;rataId | radan nimi" +
    "\n1|Ykkönen" +
    "\n3|Kolmonen" +
    "\n2|Kakkonen" +
    "\n4|Nelonen" +
    "\n7|Seiska" +
    "\n20|ToistKyt"); 
    Nimet lukuKoe = new Nimet("nKoe"); 
    assertEquals("From: Nimet line: 432", false, lukuKoe.getMuutoksia()); 
    assertEquals("From: Nimet line: 433", 0, lukuKoe.getlkm()); 
    lukuKoe.lueTiedosto(); 
    assertEquals("From: Nimet line: 435", 6, lukuKoe.getlkm()); 
    assertEquals("From: Nimet line: 436", 20, lukuKoe.getJuoksevaId()); 
    assertEquals("From: Nimet line: 437", true, lukuKoe.getMuutoksia()); 
    assertEquals("From: Nimet line: 438", "4|Nelonen", lukuKoe.etsiNimi(4).toString()); 
    Nimi[]td = lukuKoe.getAlkiot(); 
    assertEquals("From: Nimet line: 440", "1|Ykkönen", td[0].toString()); 
    assertEquals("From: Nimet line: 441", "20|ToistKyt", td[5].toString()); 
    VertaaTiedosto.tuhoaTiedosto("nKoe.dat"); 
    VertaaTiedosto.tuhoaTiedosto("nKoe.bak"); 
  } // Generated by ComTest END
}