package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tuloskortti.RataTieto;
import fi.jyu.mit.fxgui.ModalControllerInterface;

/**
 * Kontrolleri lisäämiselle ja muokkaukselle
 * @author tahvpwzw
 * @version 17.2.2021
 *
 */
public class UusiGUIController implements ModalControllerInterface<RataTieto>, Initializable{
    
    @FXML private Label labelVirhe;
    @FXML private Button buttonValmis;
    @FXML private Button buttonPeruuta;
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
    
    
    @FXML private void handlePlus() {
        Dialogs.showMessageDialog("ei toimi +");
    }
      
    @FXML private void handleMiinus() {
        Dialogs.showMessageDialog("ei toimi -");
    }
    
    @FXML private void handleVayla() {
        Dialogs.showMessageDialog("ei voi vielä lisätä");
    }
    
    @FXML private void handleValmis() {
        if (!sulkulupa) {
            Dialogs.showMessageDialog(labelVirhe.getText());
            return;
        }
        ModalController.closeStage(labelVirhe);
    }
    
    @FXML private void handlePeruuta() {
        rataKohdalla = null;
        ModalController.closeStage(labelVirhe);
    }
    
    
    
  //===========================================================================================    
 // Tästä eteenpäin ei käyttöliittymään suoraan liittyvää koodia    
    

    private RataTieto rataKohdalla;   // = {"1", "Esimerkki", "1","2","3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
    private TextField edits[];
    private boolean sulkulupa;

    @Override
    public void handleShown() {
        editNimi.requestFocus();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle bundle) {
        alusta();
        sulkulupa = true;
    }
    
    
    /**
     * alustaa ikkunan
     */
    protected void alusta() {
        edits = new TextField[]{editNimi, editPar1, editPar2, editPar3,
                editPar4, editPar5, editPar6, 
                editPar7, editPar8, editPar9,
                editPar10, editPar11, editPar12, 
                editPar13, editPar14, editPar15,
                editPar16, editPar17, editPar18};
    int i = 0;
    for (TextField ed : edits) {
        final int k = i++;
        ed.setOnKeyReleased(e -> kasitteleMuutos(k, (TextField)(e.getSource())));
        }
    
    }
    


    /**
     * tyhjentää tekstikentät
     * @param edits taulukko jonka kentät tyhjenetään
     */
    public static void tyhjenna(TextField[] edits) {
        for (TextField e : edits)
            e.setText("");
    }

    
    /**
     * asettaa radan tiedot oletuksena
     * @param oletus esitettäväy ratatiedot
     */
    @Override
    public void setDefault(RataTieto oletus) {
        rataKohdalla = oletus;
        naytaRata(edits, rataKohdalla);
        
    }
    
    /** 
     * näyttää radan tiedot
     * @param edits editoitavat kentät
     * @param tiedot  näytettävän radan tiedot
     */
    protected static void naytaRata(TextField[] edits, RataTieto tiedot) {
        if (tiedot == null) return;
        
        edits[0].setText(tiedot.getNimi());
        for (int i = 1; i < edits.length; i++) {
            edits[i].setText("" + tiedot.getPar(i));
        }
    }

    
    /**
     * hakee radan pääohjelmalta
     * @param modalityStage ikkuna
     * @param oletus ratatiedot
     * @return palauttaa ratatiedot
     */
    public static RataTieto kysyRata(Stage modalityStage, RataTieto oletus) {
        
        return ModalController.<RataTieto, UusiGUIController>showModal(
                UusiGUIController.class.getResource("UusiRataView.fxml"),
                "Uusi rata",
                modalityStage, oletus, null 
               );
               
    }
    
    
    private void kasitteleMuutos(int k, TextField edit) {
        
        if (rataKohdalla == null) return;
        String s = edit.getText();
        String virhe = null;
        virhe = rataKohdalla.aseta(k, s);
        if ( virhe == null) {
            Dialogs.setToolTipText(edit,"");
            edit.getStyleClass().removeAll("virhe");
            naytaVirhe(virhe);
       } else {
           Dialogs.setToolTipText(edit,virhe);
           edit.getStyleClass().add("virhe");
           naytaVirhe(virhe);
       }
       
      
    }
    
    
    private void naytaVirhe(String virhe) {
        if (virhe == null || virhe.isEmpty()) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            sulkulupa = true;
            return;
        }
        sulkulupa = false;
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    }
     
    
    @Override
    public RataTieto getResult() {
        return rataKohdalla;
    }
    
}
    
    
    
    
    
    