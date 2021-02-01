package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
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
    
    /**
     * Käsittelee uuden tuloskortin
     */
    @FXML private void handleUusiTuloskortti() {
        Dialogs.showMessageDialog("Ei toimi ny");
    }
    
    /** 
     * Käsittelee uuden radan
     */
    @FXML private void handleUusirata() {
        Dialogs.showMessageDialog("Ei toimi tämäkään");
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
        tallenna();
        Platform.exit();
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
