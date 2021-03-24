package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import fi.jyu.mit.fxgui.ModalControllerInterface;

/**
 * Kontrolleri lisäämiselle ja muokkaukselle
 * @author tahvpwzw
 * @version 17.2.2021
 *
 */
public class UusiGUIController implements ModalControllerInterface<String>{
    
    @FXML private Button buttonPeruuta;
    @FXML private Button buttonTallenna;
    
    @Override
    public void handleShown() {
    // TODO Auto-generated method stub
    }

    @Override
    public void setDefault(String oletus) {
    // TODO Auto-generated method stub
    
    }
    
    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @FXML private void handleTallenna() {
        tallenna();
        ModalController.closeStage(buttonTallenna);
    }
    
    @FXML private void handlePeruuta() {
        ModalController.closeStage(buttonPeruuta);
    }
    
    @FXML private void handlePlus() {
        Dialogs.showMessageDialog("ei toimi +");
    }
      
    @FXML private void handleMiinus() {
        Dialogs.showMessageDialog("ei toimi -");
    }
    
    @FXML private void handleVayla() {
        Dialogs.showMessageDialog("ei voi vielä lisätä");
    }
    
    //TODO väylien poistaminen jos vahingossa lisätty radalle liikaa
    
    private void tallenna() {
        Dialogs.showMessageDialog("Ei toimi, mutta tallenetaan");
    }



}