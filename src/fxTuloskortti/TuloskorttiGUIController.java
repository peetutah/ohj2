package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Luokka käyttöliittymän käsittelyille
 * 
 * @author tahvpwzw
 * @version 13.1.2021
 * 
 */

public class TuloskorttiGUIController implements Initializable{    
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //
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
        var resurssi = TuloskorttiGUIController.class.getResource("UusirataView.fxml");
        ModalController.showModal(resurssi, "Uusi rata",null, "");
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
        tallenna();
        return true;
    }
}
