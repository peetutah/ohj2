package fxTuloskortti;


import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import tuloskortti.RataTieto;
import tuloskortti.Tuloskortti;


/**
 * Luokka käyttöliittymän käsittelyille
 * tahvpwzw@jyu.student.fi
 * @author tahvpwzw
 * @version 13.1.2021
 * TODO tallenustarvetta ei vielä varmisteta ennen sulkemista
 */

public class TuloskorttiGUIController implements Initializable{    
    
    @FXML private TextField hakuehto;
    @FXML private Label labelVirhe;
    @FXML private ScrollPane panelRata;
    @FXML private ListChooser<RataTieto> chooserRata;

    @FXML private TextField editNimi;
    @FXML private TextField editPar1;
    @FXML private TextField editPar2;
    @FXML private TextField editPar3;
    @FXML private TextField editPar4;
    @FXML private TextField editPar5;
    @FXML private TextField editPar6;
    @FXML private TextField editPar7;
    @FXML private TextField editPar8;
    @FXML private TextField editPar9;
    @FXML private TextField editPar10;
    @FXML private TextField editPar11;
    @FXML private TextField editPar12;
    @FXML private TextField editPar13;
    @FXML private TextField editPar14;
    @FXML private TextField editPar15;
    @FXML private TextField editPar16;
    @FXML private TextField editPar17;
    @FXML private TextField editPar18;
    
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) { 
        alusta();
    }
    
    
    /**
     * käsitteelee haun
     */
    @FXML private void handleHaku() {
        String ehto = hakuehto.getText();
        etsi(ehto);
    }
    
    
    /**
     * käsittelee uuden tuloskortin/radan luomisen
     */
    @FXML private void handleUusi(){
        boolean kumpi; 
        kumpi = (Dialogs.showQuestionDialog("Uusi", "Lisätäänkö rata vai tulos?", "Uusi rata", "Uusi tuloskortti"));
        if (kumpi == true) handleUusirata();
        if (kumpi == false) handleUusiTuloskortti();
    }
    
    
    /**
     * Käsittelee uuden tuloskortin
     */
    @FXML private void handleUusiTuloskortti() {
        Dialogs.showMessageDialog("Ei osata");
    }
    
    
    /** 
     * Käsittelee uuden radan
     */
    @FXML private void handleUusirata() {
        RataTieto uRata = new RataTieto();
        rataKohdalla = uRata;
        muokkaa();
    }
    
    
    /**
     * Käsittelee tallennuspyynnön
     */
    @FXML private void handleTallenna() {
        tallenna();
    }
    
    
    /**
     * Käsittelee lopetuskäskyn
     */
    @FXML private void handleLopeta()   {
        Platform.exit();
    }
    
    
    /**
     * Käsittelee radan/tuloksen poistamisen
     */
    @FXML private void handlePoista() {
        if (rataKohdalla == null) return;
        boolean kumpi; 
        kumpi = (Dialogs.showQuestionDialog("Poista", "Haluatko varmasti poistaa radan " + chooserRata.getSelectedText(), "Kyllä", "Peruuta"));
        if (kumpi == true) poista();
        if (kumpi == false) return;
    }
    
    
    /**
     * Käsittelee radan muokkauksen
     */
    @FXML private void handleMuokkaa() {
        if (rataKohdalla == null) return;
        muokkaa();
    }
    
    
    /**
     * Avaa suunnitelman tms
     */
    @FXML private void handleAbout() {
        about();
    }
    
    
//===========================================================================================    
// Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    

    private Tuloskortti tuloskortti;
    private RataTieto rataKohdalla;
    private TextField[] edits;
    
    /**
     * Tallentaa tiedot
     * @return null jos onnistuu, muuten virhe tekstinä
     */
    private String tallenna() {
            tuloskortti.tallenna();
            return null;
    }
    
    
    /**
     * Tarkistetaan onko tallennettu 
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean sulkuLupa() {
        return true;
    }
    
    
    /**
     *  alustaa 
     */
    protected void alusta() {
        panelRata.setFitToHeight(true);
        
        chooserRata.clear();
        chooserRata.addSelectionListener(e -> naytaRata());
        
        edits = new TextField[]{editNimi, editPar1, editPar2, editPar3,
                                editPar4, editPar5, editPar6, 
                                editPar7, editPar8, editPar9,
                                editPar10, editPar11, editPar12, 
                                editPar13, editPar14, editPar15,
                                editPar16, editPar17, editPar18};
    }
    
    /** 
     * 
     * näyttää radan tiedot
     */
    protected void naytaRata() {
        rataKohdalla = chooserRata.getSelectedObject();
        UusiGUIController.naytaRata(edits, rataKohdalla);
    }
    
    
    private void naytaVirhe(String virhe) {
        if (virhe == null || virhe.isEmpty()) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    } 

    
    /** asettaa ohjelman käyttöliittymään tuloskorttiolion
     * @param tuloskortti asetettava tuloskortti
     */
    public void setTuloskortti(Tuloskortti tuloskortti) {
        this.tuloskortti = tuloskortti;
        lueTiedosto();
        lataa();
    }
    
    
    /**
     * käsittelee uuden radan luomisen tai olemassaolevan radan muokkaamisen
     */
    private void muokkaa() {
        RataTieto rata;
        try {
            rata = UusiGUIController.kysyRata(null, (RataTieto)rataKohdalla.clone());
            
        if (rata == null) return;
        if(!tuloskortti.korvaaTaiLisaa(rata)) chooserRata.add(rata.getNimi(), rata);
        UusiGUIController.naytaRata(edits, rata);
        lataa();
        chooserRata.setSelectedIndex(tuloskortti.rataMaara() - 1);
        } catch (CloneNotSupportedException e) {
            System.err.print("kloonaus kusi");
        e.printStackTrace();
        }
        
    }
    
    
    /**
     * poistaa ratatiedot id:n mukaan
     */
    private void poista() {
        int id = rataKohdalla.getId();
        tuloskortti.poista(id);
        lataa();
        handleHaku();
        chooserRata.setSelectedIndex(0);
    }
    
    
    /**
     * hakee ratatiedot esitettäväksi
     * @param haku merkkijono jolla ratoja haetaan
     */
    protected void etsi(String haku) {
        naytaVirhe("");
        
        if (haku == null || haku.length() <= 0 ) {
            lataa();
            return;
        }
        
        List<RataTieto> rTiedot = tuloskortti.etsi(haku);
        chooserRata.clear();
        
        if(rTiedot.size() <= 0) {
            naytaVirhe("Ei hakutuloksia");
            UusiGUIController.naytaRata(edits, null);
            return;
        }
        
        for(RataTieto rt : rTiedot) {
            chooserRata.add(rt.getNimi(), rt);
        }
        chooserRata.setSelectedIndex(0);
    }
    
    
    /**
     * @param os virta minne tulostetaan
     * @param ratatiedot tulostettavat tratatiedot
     */
    public void tulosta(PrintStream os, String[] ratatiedot) {
        os.println("Radan nimi: " + ratatiedot[0]);
        for(int i = 1; i < ratatiedot.length; i++) {
            os.println("Väylä: "+ i + " Par: " + ratatiedot[i]);
        }
    }
    
    
    /**
     * lataa tiedostojen tiedot esille
     */
    public void lataa() {
        chooserRata.clear();
        int maara = tuloskortti.rataMaara();
        int lisatyt = 0;
        for(int i = 0; lisatyt < maara; i++) {            
            RataTieto tiedot = tuloskortti.annaRata(i);
            if(tiedot == null)continue;
            
            chooserRata.add(tiedot.getNimi(), tiedot);
            lisatyt++;
        }
        rataKohdalla = chooserRata.getSelectedObject();
    }
    
    
    /**
     * Näytetään ohjelman suunnitelma erillisessä selaimessa.
     */
    private void about() {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URI("https://tim.jyu.fi/view/kurssit/tie/ohj2/2021k/ht/tahvpwzw");
            desktop.browse(uri);
            } catch (URISyntaxException e) {
                return;
            } catch (IOException e) {
                return;
            }
        
    }
    
    
    /**
     * lukee tiedot tiedostoista
     */
    public void lueTiedosto() {
        tuloskortti.lueTiedostot();
    }
    
    
}
