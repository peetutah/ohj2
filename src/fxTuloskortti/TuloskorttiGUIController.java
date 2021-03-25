package fxTuloskortti;


import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import tuloskortti.Tuloskortti;


/**
 * Luokka käyttöliittymän käsittelyille
 * @author tahvpwzw
 * @version 13.1.2021
 * 
 */

public class TuloskorttiGUIController implements Initializable{    
    
    @FXML private TextField hakuehto;
    @FXML private Label labelVirhe;
    @FXML private ScrollPane panelRata;
    @FXML private ListChooser<String[]> chooserRata;
    
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) { 
        alusta();
    }
    
    
    @FXML private void handleHakuEhto() {
        String ehto = hakuehto.getText();
        
        if ( ehto.isEmpty() )
            naytaVirhe(null);
        else
            naytaVirhe("Ei osata vielä hakea "  + ": " + ehto);

    }
    
    
    @FXML private void handleAvaa() {
        avaa();
    }
    
    
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
        // uusiTulos();
        var resurssi = TuloskorttiGUIController.class.getResource("UusiTulosView.fxml");
        ModalController.showModal(resurssi, "Uusi Tuloskortti",null, "");
    }
    
    
    /** 
     * Käsittelee uuden radan
     */
    @FXML private void handleUusirata() {
        //Dialogs.showMessageDialog("Ei toimi radan lisäys");
        // var resurssi = TuloskorttiGUIController.class.getResource("UusirataView.fxml");
        //  ModalController.showModal(resurssi, "Uusi rata",null, "");
        String[] ratatiedot = {"Esimerkki", "1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
        uusiRata(ratatiedot);
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
        // poista();
        Dialogs.showMessageDialog("Ei toimi poisto");
    }
    
    
    /**
     * Käsittelee radan muokkauksen
     */
    @FXML private void handleMuokkaa() {
        // uusiRata(@par muokattava);
        Dialogs.showMessageDialog("Ei toimi");
        var resurssi = TuloskorttiGUIController.class.getResource("UusirataView.fxml");
        ModalController.showModal(resurssi, "Uusi rata",null, "");
    }
    
    
    /**
     * Avaa suunnitelman tms
     */
    @FXML private void handleAbout() {
        Dialogs.showMessageDialog("Ei toimi");
    }
    
    
//===========================================================================================    
// Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    

    private Tuloskortti tuloskortti;
    private String[] rataKohdalla;
    private TextArea areaRata = new TextArea();
    
    /**
     * Tallennus
     */
    private void tallenna() {
        Dialogs.showMessageDialog("Ei toimi, mutta tallenetaan");
    }
    
    
    /**
     * Tarkistetaan onko tallennettu 
     * TODO lisätä varmistus tallennustarpeelle
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean sulkuLupa() {
        return true;
    }
    
    
    /**
     *  alustaa 
     */
    protected void alusta() {
        panelRata.setContent(areaRata);
        areaRata.setFont(new Font ("Courier New",12));
        panelRata.setFitToHeight(true);
        
        chooserRata.clear();
        chooserRata.addSelectionListener(e -> naytaRata());
    }
    
    /** tulostaa radan tiedot
     * 
     */
    protected void naytaRata() {
        rataKohdalla = chooserRata.getSelectedObject();
        
        if (rataKohdalla == null) return;
        
        areaRata.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaRata)){
           tulosta(os, rataKohdalla);
        }
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
        naytaRata();
    }
    
    /**
     * lisää uuden radan muokattavaksi
     * @param ratatiedot tiedot minkä pohjalta uusi rata luodaan
     */
    protected void uusiRata(String[] ratatiedot){
        
        tuloskortti.uusiRata(ratatiedot);
        hae(tuloskortti.annaRataId());
    }
    
    
    
    /** hakee kohteen valittavaksi
     * @param hakuid luku jolla haetaan
     */
    protected void hae(int hakuid) {
        chooserRata.clear();
        
        int index = 0;
        for(int i = 0; i < tuloskortti.rataMaara(); i++) {
            String[] haku = tuloskortti.annaRata(i);
            if (tuloskortti.annaRataId() == hakuid) index = i;
            chooserRata.add(haku[0], haku);
        }
        chooserRata.setSelectedIndex(index);
            
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
     * @return palauttaa avausluvan
     */
    public boolean avaa() {
        // TODO Auto-generated method stub
        return true;
    }
    
    
    
}
